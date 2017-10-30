import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

public class Submit {

    int vertices;
    private HashMap<Integer, LinkedList<Integer>> adj = new HashMap<>();
    int[] values;

    public Submit(int vertices) {

        this.vertices = vertices;
        this.values = new int[vertices];
        for (int i = 0; i < vertices ; i++) {
            values[i] = i;
        }

        for (int v : values) {
            adj.put(v, new LinkedList<>());
        }
    }

    public void printNode() {
        for (int v : values) {
            System.out.println(adj.get(v).toString());
        }
    }

    public void addEdge(int dataPar, int dataChil) {
        adj.get(dataPar).add(dataChil);
        adj.get(dataChil).add(dataPar);
    }


    public int result(int level) {
        ArrayList result = new ArrayList();
        LinkedList<Integer> queue = new LinkedList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        boolean hasNode = false;


        for (int i : values) {
            visited.put(i, false);
        }
        queue.add(0);
        visited.put(0, true);

        while (queue.size() != 0) {
            for (int i : adj.get(queue.getLast())) {
                if (!visited.get(i)) {
                    queue.add(i);
                    visited.put(i, true);
                    hasNode = true;
                    break;
                }
            }
            if (adj.get(queue.getLast()).size() != 0) {
                for (int i : adj.get(queue.getLast())) {
                    if (visited.get(i)) {
                        hasNode = false;
                    } else {
                        hasNode = true;
                        break;
                    }
                }
            } else hasNode = false;
            if (queue.size() == level) {
                result.add(queue.get(level - 1));
            }
            if (!hasNode || queue.size() == level) {
                queue.pollLast();
            }
        }

        return result.size();
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Submit bsf = new Submit(n);
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            bsf.addEdge(a - 1, b - 1);
        }
        int level = in.nextInt();
//        bsf.printNode();
        System.out.print(bsf.result(level));
    }
}
