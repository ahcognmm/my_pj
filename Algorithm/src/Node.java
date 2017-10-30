import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Node {

    int vertices;
//	adj Chỗ chứa liên kết của từng node 
    private HashMap<Integer, LinkedList<Integer>> adj = new HashMap<>();
    int[] values;

//	tạo node và chỗ chứa các liên kết của node
    public Node(int vertices, int... value) {

        this.vertices = vertices;
        this.values = value;
        for (int v : values) {
            adj.put(v, new LinkedList<>());
        }
    }

// 	tạo liên kết giữa các node để thành đồ thị
    public void addEdge(int dataPar, int dataChil) {
        adj.get(dataPar).add(dataChil);
//	Tạo liên kết vô hướng cho đồ thị
//        adj.get(dataChil).add(dataPar); 
    }

    public void printNode() {
        for (int v : values) {
            System.out.println(adj.get(v).toString());
        }
    }
//	Duyệt bfs
    public void bfs(int startNode, int endNode) {

        LinkedList<Integer> result = new LinkedList<>();
        HashMap<Integer, Boolean> visted = new HashMap<>();
        HashMap<Integer, Boolean> inQueue = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();

//	Khởi tạo các điều kiện ban đầu cho từng node (chưa thăm , chưa vào queue)
        for (int i : values) {
            visted.put(i, false);
            inQueue.put(i, false);
        }

        queue.add(startNode);
        inQueue.put(startNode, true);

        while (queue.size() != 0) {

            for (int i : adj.get(queue.getFirst())) {
                if (!visted.get(i) && !inQueue.get(i)) {
                    queue.add(i);
                    inQueue.put(i, true);
                }
            }
            visted.put(queue.getFirst(), true);
            result.add(queue.getFirst());
            if (queue.getFirst() == endNode) {
                break;
            }
            queue.pop();
        }

        System.out.println(result.toString());

    }

//	Duyệt dfs
    public void dfs(int startNode) {

        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        boolean hasNode = true;
        HashMap<Integer, Boolean> inQueue = new HashMap<>();

//	Khởi tạo các điều kiện ban đầu cho node 
        for (int i : values) {
            visited.put(i, false);
            inQueue.put(i, false);
        }

        queue.add(startNode);
        result.add(startNode);
        inQueue.put(startNode, true);
        visited.put(startNode, true);

        while (queue.size() != 0) {
            int test = queue.getLast();
            for (int i : adj.get(queue.getLast())) {
                if (!visited.get(i)) {
                    queue.add(i);
                    visited.put(i, true);
                    inQueue.put(i, true);
                    result.add(i);
                    hasNode = true;
                    break;
                }
            }

            if (adj.get(queue.getLast()).size() != 0) {
                for (int i : adj.get(queue.getLast())) {
                    if (visited.get(i) && inQueue.get(i)) {
                        hasNode = false;
                    } else {
                        hasNode = true;
                        break;
                    }
                }
            } else hasNode = false;
            if (!hasNode) {
                queue.pollLast();
            }
        }
        System.out.println(result.toString());
    }

}
