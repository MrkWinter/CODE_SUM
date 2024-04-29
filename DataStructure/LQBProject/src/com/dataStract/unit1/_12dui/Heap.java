package com.dataStract.unit1._12dui;

public interface Heap<E> {
	int size();
	boolean isEmpty();
	void clear();
	void add(E element);
	E get();
	E remove();
	E replace(E element);
	void add();
}
