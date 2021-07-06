package io.sidorovgreg.otus.array.impl;

import io.sidorovgreg.otus.array.Array;

public class VectorArray<T> implements Array<T> {

    private Object[] array;
    private int vector;
    private int size;

    public VectorArray(int vector) {
        this.vector = vector;
        array = new Object[0];
        size = 0;
    }

    public VectorArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length)
            resize();
        array[size] = item;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public void add(final T item, final int index) {
        int oldSize = size();
        if (oldSize == array.length)
            resize();
        System.arraycopy(array, index, array, index + 1, oldSize - index);
        array[index] = item;
        size++;
    }

    @Override
    public T remove(final int index) {
        Object result = array[index];
        System.arraycopy(array, index + 1, array, index, size() - 1 - index);
        size--;
        return (T)result;
    }

    private void resize() {
        Object[] newArray = new Object[array.length + vector];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}