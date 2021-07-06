package io.sidorovgreg.otus.array.impl;

import io.sidorovgreg.otus.array.Array;

public class MatrixArray<T> implements Array<T> {

    private int size;
    private int vector;
    private Array<Array<T>> array;

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new SingleArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size == array.size() * vector)
            array.add(new VectorArray<T>(vector));
        array.get(size / vector).add(item);
        size ++;
    }

    @Override
    public T get(int index) {
        return array.get(index / vector).get(index % vector);
    }

    @Override
    public void add(final T item, final int index) {
        if (size() == array.size() * vector)
            array.add(new VectorArray<>(vector));
        array.get(index / vector).add(item, index);
        size++;
    }

    @Override
    public T remove(final int index) {
        size--;
        return array.get(index / vector).remove(index);
    }
}