import com.google.gson.Gson;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String json = "{\n" +
                "\"hole\": [\n" +
                "[55, 80], [65, 95], [95, 95], [35, 5], [5, 5],\n" +
                "[35, 50], [5, 95], [35, 95], [45, 80]\n" +
                "],\n" +
                "\"figure\": {\n" +
                "\"edges\": [\n" +
                "[2, 5], [5, 4], [4, 1], [1, 0], [0, 8], [8, 3], [3, 7],\n" +
                "[7, 11], [11, 13], [13, 12], [12, 18], [18, 19], [19, 14],\n" +
                "[14, 15], [15, 17], [17, 16], [16, 10], [10, 6], [6, 2],\n" +
                "[8, 12], [7, 9], [9, 3], [8, 9], [9, 12], [13, 9], [9, 11],\n" +
                "[4, 8], [12, 14], [5, 10], [10, 15]\n" +
                "],\n" +
                "\"vertices\": [\n" +
                "[20, 30], [20, 40], [30, 95], [40, 15], [40, 35], [40, 65],\n" +
                "[40, 95], [45, 5], [45, 25], [50, 15], [50, 70], [55, 5],\n" +
                "[55, 25], [60, 15], [60, 35], [60, 65], [60, 95], [70, 95],\n" +
                "[80, 30], [80, 40]\n" +
                "]\n" +
                "},\n" +
                "\"epsilon\": 150000\n" +
                "}";
        Gson gson = new Gson();
        Problem problem = gson.fromJson(json, Problem.class);


        JFrame frame = new JFrame("nameOf");
        frame.setSize(200,200);
        frame.setVisible(true);
//        Canvas canvas = new MyCanvas();
        frame.add(new DrawIO(problem));
//        frame.add(canvas);
//        frame.setVisible(true);
//        System.out.println(problem.toString());
    }
}
