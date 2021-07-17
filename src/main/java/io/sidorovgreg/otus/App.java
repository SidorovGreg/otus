package io.sidorovgreg.otus;

public class App {
    public static void main(String[] args) {
        char[] text = "ABAASDSABADDAABAACD".toCharArray();
        char[] pat = "ABA".toCharArray();
        GFG.search(text, pat);
    }
}
