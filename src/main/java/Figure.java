import java.util.ArrayList;

public class Figure {
    ArrayList<ArrayList<Integer>> edges;
    ArrayList<ArrayList<Integer>> vertices;

    @Override
    public String toString() {
        return "Figure{" +
                "edges=" + edges +
                ", vertices=" + vertices +
                '}';
    }
}
