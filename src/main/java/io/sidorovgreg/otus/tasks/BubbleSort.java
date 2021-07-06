package io.sidorovgreg.otus.tasks;

import io.sidorovgreg.otus.Task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort implements Task {
    @Override
    public String execute(final List<String> args) {
        int[] array = Arrays.stream(args.get(1).split(" ")).mapToInt(Integer::parseInt).toArray();
        bubbleSort(array);
        return Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

    }


}
