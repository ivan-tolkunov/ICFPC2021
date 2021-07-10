import java.awt.*;
import java.util.ArrayList;

public class DrawIO extends Canvas {
    Problem problem;

    public DrawIO(Problem problem) {
        this.problem = problem;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GREEN);
        for (int i = 0; i < problem.hole.size(); i++) {
            int j = (i + 1) % problem.hole.size();
            g.drawLine(problem.hole.get(i).get(0), problem.hole.get(i).get(1), problem.hole.get(j).get(0), problem.hole.get(j).get(1));
        }
        g.setColor(Color.RED);
        for (ArrayList<Integer> a : problem.figure.edges) {
            g.drawLine(problem.figure.vertices.get(a.get(0)).get(0),
                    problem.figure.vertices.get(a.get(0)).get(1),
                    problem.figure.vertices.get(a.get(1)).get(0),
                    problem.figure.vertices.get(a.get(1)).get(1));

        }
    }

}

