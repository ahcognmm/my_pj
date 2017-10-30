import java.util.HashMap;
import java.util.LinkedList;

public class TestNode {

    public static void main(String[] args) {
        Node graph = new Node(20, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        graph.addEdge(1, 11);
        graph.addEdge(1, 2);
        graph.addEdge(1, 8);
        graph.addEdge(11, 17);
        graph.addEdge(11, 6);
        graph.addEdge(2, 7);
        graph.addEdge(2, 14);
        graph.addEdge(17, 15);
        graph.addEdge(17, 5);
        graph.addEdge(15, 18);
        graph.addEdge(15, 12);
        graph.addEdge(15, 9);
        graph.addEdge(15, 4);
        graph.addEdge(15, 16);
        graph.addEdge(5, 13);
        graph.addEdge(9, 19);
        graph.addEdge(4, 10);
        graph.addEdge(16, 20);
        graph.addEdge(13, 3);
        graph.printNode();
//        graph.bfs(0,7);
        graph.dfs(1);
//
//        LRUcache<Integer> lrUcache = new LRUcache(10);
//        lrUcache.set(4);
//        lrUcache.set(3);
//
//        lrUcache.set(2);
//        lrUcache.set(4);
//        lrUcache.set(1);
//        lrUcache.set(5);
//        lrUcache.set(6);
//        lrUcache.set(3);
//        lrUcache.set(2);
//        lrUcache.set(7);
//        lrUcache.set(9);
//        lrUcache.set(8);
//        lrUcache.set(10);
//        lrUcache.set(11);
//        lrUcache.set(5);

//        lrUcache.set(1);
//        lrUcache.print();
//        System.out.println(lrUcache.totalInCache() + "\n" + lrUcache.count);
//        System.out.println(graph.result(3));


    }
}
