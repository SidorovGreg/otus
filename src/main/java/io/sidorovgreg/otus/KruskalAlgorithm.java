package io.sidorovgreg.otus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class KruskalAlgorithm {
    private static int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
    private static void Union(Subset subsets[], int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);
        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }
    public static void findPrintMST(ArrayList<Edge> graph[], Edge edges[]) {
        Arrays.sort(edges, Edge.comp);
        Edge mst[] = new Edge[graph.length - 1];
        for (int i = 0; i < graph.length - 1; i++) {
            mst[i] = new Edge(-1, -1, -1);
        }
        int e = 0;

        Subset subsets[] = new Subset[graph.length];
        for (int i = 0; i < graph.length; i++) {
            subsets[i] = new Subset();
        }
        for (int i = 0; i < graph.length; i++) {
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        for (int i = 0; i < edges.length; i++) {
            int x = find(subsets, edges[i].from);
            int y = find(subsets, edges[i].to);
            if (x != y) {
                mst[e].from = edges[i].from;
                mst[e].to = edges[i].to;
                mst[e].weight = edges[i].weight;
                Union(subsets, x, y);
                e++;
            } else {
            }
            if (e == graph.length - 1) {
                break;
            }
        }

        // Print the MST
        for (int i = 0; i < graph.length - 1; i++) {
            System.out.println("From " + mst[i].from + " to " + mst[i].to + " weight " + mst[i].weight);
        }
    }

    static class Edge {
        int from;
        int to;
        int weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public static final Comparator<Edge> comp = Comparator.comparingInt(o -> o.weight);
    }
    static class Subset {
        int parent;
        int rank;
    }
}