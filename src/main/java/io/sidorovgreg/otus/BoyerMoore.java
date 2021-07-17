package io.sidorovgreg.otus;

class GFG {
    private static void preprocess_strong_suffix(int[] shift, int[] bpos, char[] pat, int m) {
        int i = m, j = m + 1;
        bpos[i] = j;
        while (i > 0) {
            while (j <= m && pat[i - 1] != pat[j - 1]) {
                if (shift[j] == 0)
                    shift[j] = j - i;
                j = bpos[j];
            }
            i--;
            j--;
            bpos[i] = j;
        }
    }

    private static void preprocess_case2(int[] shift, int[] bpos,

                                 char[] pat, int m) {
        int i, j;
        j = bpos[0];
        for (i = 0; i <= m; i++) {
            if (shift[i] == 0)
                shift[i] = j;
            if (i == j)
                j = bpos[j];
        }
    }

    public static void search(char[] text, char[] pat) {
        int s = 0, j;
        int m = pat.length;
        int n = text.length;
        int[] bpos = new int[m + 1];
        int[] shift = new int[m + 1];
        for (int i = 0; i < m + 1; i++)
            shift[i] = 0;
        preprocess_strong_suffix(shift, bpos, pat, m);
        preprocess_case2(shift, bpos, pat, m);
        while (s <= n - m) {
            j = m - 1;
            while (j >= 0 && pat[j] == text[s + j])
                j--;
            if (j < 0 ) {
                System.out.printf("pattern occurs at shift = %d\n", s);
                s += shift[0];
            } else
                s += shift[j + 1];
        }
    }
}