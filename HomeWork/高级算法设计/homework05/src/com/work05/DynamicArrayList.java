package com.work05;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class DynamicArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public DynamicArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return (T) elements[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null;
        size--;
    }

    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == elements.length) {
            resize();
        }

        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }

        elements[index] = element;
        size++;
    }

    public void append(T element) {
        if (size == elements.length) {
            resize();
        }

        elements[size] = element;
        size++;
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        DynamicArrayList<Integer> list = new DynamicArrayList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.insert(1, 4);
        list.remove(2);

        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
    }
}
