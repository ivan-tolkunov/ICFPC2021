import com.google.gson.Gson;
import okhttp3.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int id = 51;
        String json = getProblem(id);
        Gson gson = new Gson();
        Problem problem = gson.fromJson(json, Problem.class);

        JFrame frame = new JFrame("Window");
        frame.setLayout(new BorderLayout());
        frame.setSize(700, 700);
        frame.setVisible(true);
        DrawIO drawIO = new DrawIO(problem);
        frame.add(drawIO);
        JButton b = new JButton("push me");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println(setProblem(gson.toJson(drawIO.solution), id));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        b.setBounds(20, 40, 10, 20);
        frame.add(b, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static String getProblem(int id) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://poses.live/api/problems/" + id)
                .addHeader("Authorization", "Bearer d73be585-fe48-41ef-895c-6674e7951d06")
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String  setProblem(String json, int id) throws IOException {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url("https://poses.live/api/problems/" + id + "/solutions")
                .addHeader("Authorization", "Bearer d73be585-fe48-41ef-895c-6674e7951d06")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
