package io.sidorovgreg.otus.array.impl;

import io.sidorovgreg.otus.array.Array;

public class SingleArray<T> implements Array<T> {

    private Object[] array;

    public SingleArray () {
        array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        increment();
        array[size() - 1] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public void add(final T item, final int index) {
        int oldSize = size();
        increment();
        System.arraycopy(array, index, array, index + 1, oldSize - index);
        array[index] = item;
    }

    @Override
    public T remove(final int index) {
        Object result = array[index];
        System.arraycopy(array, index + 1, array, index, size() - 1 - index);
        decrement();
        return (T)result;
    }

    private void increment() {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }

    private void decrement() {
        Object[] newArray = new Object[size() - 1];
        System.arraycopy(array, 0, newArray, 0, size() - 1);
        array = newArray;
    }
}
