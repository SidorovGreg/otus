package io.sidorovgreg.otus;

import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] array = (new Random()).ints(100000000L, 0, 65535).toArray();
        MergeSort.mergeSort(array, 0, array.length - 1);
    }
}