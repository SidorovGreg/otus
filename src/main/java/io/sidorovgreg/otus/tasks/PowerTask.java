package io.sidorovgreg.otus.tasks;

import io.sidorovgreg.otus.Task;

import java.util.List;

public class PowerTask implements Task {
    @Override
    public String execute(final List<String> args) {
        return String.valueOf(pow(Double.parseDouble(args.get(0)), Long.parseLong(args.get(1))));
    }

    public static double pow(double x, long n)
    {
        double temp;
        if(n == 0)
            return 1;
        temp = pow(x, n/2);
        if (n%2 == 0)
            return temp*temp;
        else
            return x*temp*temp;
    }
}
