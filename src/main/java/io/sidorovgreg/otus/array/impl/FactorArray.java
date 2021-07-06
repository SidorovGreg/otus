package io.sidorovgreg.otus.array.impl;

import io.sidorovgreg.otus.array.Array;

public class FactorArray<T> implements Array<T> {

    private Object[] array;
    private int factor;
    private int size;

    public FactorArray(int factor, int initLength) {
        this.factor = factor;
        array = new Object[initLength];
        size = 0;
    }

    public FactorArray() {
        this(50, 10);
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

    private void resize() {
        Object[] newArray = new Object[array.length + array.length * factor / 100];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
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
}
