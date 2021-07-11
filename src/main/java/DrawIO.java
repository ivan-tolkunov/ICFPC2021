import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class DrawIO extends JPanel implements MouseMotionListener, MouseWheelListener {
    Problem problem;
    int x;
    int y;
    static int SCALE = 4;
    Solution solution;


    public DrawIO(Problem problem) {
        this.problem = problem;
        this.addMouseMotionListener(this);
        this.addMouseWheelListener(this);
        ArrayList<ArrayList<Integer>> cloneFigure = new ArrayList<>();
        for (int i = 0; i < problem.figure.vertices.size(); i++) {
            cloneFigure.add((ArrayList<Integer>) this.problem.figure.vertices.get(i).clone());
        }
        solution = new Solution(cloneFigure);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        for (int i = 0; i < problem.hole.size(); i++) {
            int j = (i + 1) % problem.hole.size();
            g.drawLine(SCALE * problem.hole.get(i).get(0), SCALE * problem.hole.get(i).get(1), SCALE * problem.hole.get(j).get(0), SCALE * problem.hole.get(j).get(1));
        }
        for (ArrayList<Integer> a : problem.figure.edges) {
            if (correct(problem.figure.vertices.get(a.get(0)),
                    problem.figure.vertices.get(a.get(1)),
                    solution.vertices.get(a.get(0)),
                    solution.vertices.get(a.get(1)))) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.RED);
            }
            g.drawLine(SCALE * solution.vertices.get(a.get(0)).get(0),
                    SCALE * solution.vertices.get(a.get(0)).get(1),
                    SCALE * solution.vertices.get(a.get(1)).get(0),
                    SCALE * solution.vertices.get(a.get(1)).get(1));

        }
        g.setColor(Color.PINK);
        g.fillOval(SCALE * this.x - 5, SCALE * this.y - 5, 10, 10);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int mouseX = e.getX() / SCALE;
        int mouseY = e.getY() / SCALE;
        for (ArrayList<Integer> a : solution.vertices) {
            if (this.x == a.get(0) && this.y == a.get(1)) {
                a.set(0, mouseX);
                a.set(1, mouseY);
                this.x = a.get(0);
                this.y = a.get(1);
                repaint();
            }
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseX = e.getX() / SCALE;
        int mouseY = e.getY() / SCALE;
        for (ArrayList<Integer> a : solution.vertices) {
            int newX = a.get(0) - mouseX;
            int newY = a.get(1) - mouseY;
            if (Math.abs(newX) <= 5 && Math.abs(newY) <= 5) {
                this.x = a.get(0);
                this.y = a.get(1);
                repaint();
            }
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        if (notches < 0) {
            SCALE++;
        } else {
            SCALE--;
        }
        repaint();
    }

    public int d(ArrayList<Integer> p, ArrayList<Integer> q) {
        return (int) (Math.pow((p.get(0) - q.get(0)), 2) + Math.pow((p.get(1) - q.get(1)), 2));
    }

    public boolean correct(ArrayList<Integer> p, ArrayList<Integer> q, ArrayList<Integer> pNew, ArrayList<Integer> qNew) {
        return Math.abs((d(pNew, qNew) / d(p, q)) - 1) <= (problem.epsilon / 1000000);
    }

}

