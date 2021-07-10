import java.util.ArrayList;

public class Problem {
    ArrayList<ArrayList<Integer>> hole;
    Figure figure;
    int epsilon;

    @Override
    public String toString() {
        return "Problem{" +
                "hole=" + hole +
                ", figure=" + figure +
                ", epsilon=" + epsilon +
                '}';
    }
}
