package com.work04;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class LinkedList<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        E removedData;
        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node<E> previousNode = getNode(index - 1);
            removedData = previousNode.next.data;
            previousNode.next = previousNode.next.next;
        }
        size--;
        return removedData;
    }

    public void add(int index, E data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            Node<E> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> previousNode = getNode(index - 1);
            Node<E> newNode = new Node<>(data);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }
        size++;
    }

    public void append(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    private Node<E> getNode(int index) {
        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}

