package io.sidorovgreg.otus;

public class App {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int value = 1;
        tree.insertNode(value);
        System.out.println(tree.search(value));
        tree.deleteNode(value);
        System.out.println(tree.search(value) == null);
    }
}
