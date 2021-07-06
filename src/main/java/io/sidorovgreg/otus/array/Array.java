package io.sidorovgreg.otus.array;

public interface Array<T> {
     int size();
     void add(T item);
     T get(int index);

    void add(T item, int index); // with shift to tail

    T remove(int index);
}
