import java.util.ArrayList;

public class Solution {
    ArrayList<ArrayList<Integer>> vertices;

    public Solution(ArrayList<ArrayList<Integer>> vertices) {
        this.vertices = vertices;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "vertices=" + vertices +
                '}';
    }
}
