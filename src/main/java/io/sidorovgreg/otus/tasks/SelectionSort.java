package io.sidorovgreg.otus.tasks;

import io.sidorovgreg.otus.Task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionSort implements Task {

    @Override
    public String execute(final List<String> args) {
        int[] array = Arrays.stream(args.get(1).split(" ")).mapToInt(Integer::parseInt).toArray();
        selectionSort(array);
        return Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
}
