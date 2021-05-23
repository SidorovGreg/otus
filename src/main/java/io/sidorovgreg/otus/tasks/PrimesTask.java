package io.sidorovgreg.otus.tasks;

import io.sidorovgreg.otus.Task;

import java.util.Arrays;
import java.util.List;

public class PrimesTask implements Task {
    @Override
    public String execute(final List<String> args) {
        return String.valueOf(eratosfenPrimes(Integer.parseInt(args.get(0))));
    }

    public static int eratosfenPrimes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < max; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int result = 0;
        for (int i = 2; i < max; i++) {
            if (isPrime[i]) {
                result++;
            }
        }
        return result;
    }
}
