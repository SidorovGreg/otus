package io.sidorovgreg.otus.tasks;

import io.sidorovgreg.otus.Task;

import java.math.BigInteger;
import java.util.List;

public class FibonacciTask implements Task {
    @Override
    public String execute(final List<String> args) {
        return String.valueOf(fibonacci(Integer.parseInt(args.get(0))));
    }

    public static BigInteger[][] matrixMultiplication(BigInteger[][] a, BigInteger[][] b) {
        return new BigInteger[][]{
                {a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])), a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))},
                {a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])), a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))},
        };
    }

    public static BigInteger[][] matrixPowerFast(BigInteger[][] a, int n) {
        if (n == 0) {
            return new BigInteger[][]{
                    {BigInteger.ONE, BigInteger.ZERO},
                    {BigInteger.ZERO, BigInteger.ONE}
            };
        } else if (n % 2 == 0) {
            return matrixPowerFast(matrixMultiplication(a, a), n / 2);
        } else {
            return matrixMultiplication(matrixPowerFast(a, n - 1), a);
        }
    }

    public static BigInteger fibonacci(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }

        BigInteger[][] a = {
                {BigInteger.ONE, BigInteger.ONE},
                {BigInteger.ONE, BigInteger.ZERO}
        };
        BigInteger[][] powerOfA = matrixPowerFast(a, n - 1);
        return powerOfA[0][0];
    }
}
