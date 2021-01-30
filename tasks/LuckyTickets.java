package tasks;

public class LuckyTickets implements Task {
    private Integer n;
    private Integer qty;

    public String execute(final String args)
    {
        this.n = Integer.parseInt(args);
        qty = 0;
        NextDigit(0, 0, 0);
        return qty.toString();
    }

    public void NextDigit(int nr, int sum1, int sum2)
    {
        if (nr == 2 * n)
        {
            if (sum1 == sum2)
                qty++;
            return;
        }
        for (int a = 0; a <= 9; a ++)
            if (nr < n)
                NextDigit(nr + 1, sum1 + a, sum2);
            else
                NextDigit(nr + 1, sum1, sum2 + a);
    }
}
