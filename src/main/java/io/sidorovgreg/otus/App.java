package io.sidorovgreg.otus;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<KruskalAlgorithm.Edge> graph[] = new ArrayList[4];
        KruskalAlgorithm.Edge edges[] = new KruskalAlgorithm.Edge[5];
        for (int i = 0; i < 4; i++)
            graph[i] = new ArrayList<>();
        graph[0].add(new KruskalAlgorithm.Edge(0, 1, 5));
        graph[0].add(new KruskalAlgorithm.Edge(0, 2, 8));
        graph[1].add(new KruskalAlgorithm.Edge(1, 0, 5));
        graph[1].add(new KruskalAlgorithm.Edge(1, 2, 10));
        graph[1].add(new KruskalAlgorithm.Edge(1, 3, 15));
        graph[2].add(new KruskalAlgorithm.Edge(2, 0, 8));
        graph[2].add(new KruskalAlgorithm.Edge(2, 1, 10));
        graph[2].add(new KruskalAlgorithm.Edge(2, 3, 20));
        graph[3].add(new KruskalAlgorithm.Edge(3, 1, 15));
        graph[3].add(new KruskalAlgorithm.Edge(3, 2, 20));
        edges[0] = new KruskalAlgorithm.Edge(0, 1, 5);
        edges[1] = new KruskalAlgorithm.Edge(0, 2, 8);
        edges[2] = new KruskalAlgorithm.Edge(1, 2, 10);
        edges[3] = new KruskalAlgorithm.Edge(1, 3, 15);
        edges[4] = new KruskalAlgorithm.Edge(2, 3, 20);

        KruskalAlgorithm.findPrintMST(graph, edges);
    }
}
