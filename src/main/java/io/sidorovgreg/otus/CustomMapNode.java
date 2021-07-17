package io.sidorovgreg.otus;

public class CustomMapNode<K, V> {
    K key;
    V value;
    final int hashCode;

    // Reference to next node
    CustomMapNode<K, V> next;

    // Constructor
    public CustomMapNode(K key, V value, int hashCode)
    {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}
