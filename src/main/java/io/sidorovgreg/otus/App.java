package io.sidorovgreg.otus;

import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        CustomMap<Integer, Double> map = new CustomMap<>();
        IntStream.range(0, 100).forEach(i -> map.put(i, Math.pow(10, i)));
        System.out.println(map.get(99));
    }
}
