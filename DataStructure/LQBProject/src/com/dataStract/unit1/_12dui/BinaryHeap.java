package com.dataStract.unit1._12dui;

import java.util.Comparator;

public class BinaryHeap<E> implements Heap<E> {
	private E[] elements;
	private int size;
	private Comparator<E> comparator;
	private final static int DEFAULT_CATACITY = 10;

	public BinaryHeap(E[] elements, Comparator<E> comparator) {
		this.comparator = comparator;
		elements = (E[]) new Object[DEFAULT_CATACITY];
		if (elements == null)
			return;
		ensureCapacity(elements.length);
		for (int i = 0; i < elements.length; i++) {
			this.elements[i] = elements[i];
		}
		size = elements.length;
		heapify();
	}

	public void heapify() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			siftDown(i);
		}
	}

		
	public BinaryHeap(E[] elements) {
		this(elements, null);
	}

	public BinaryHeap() {
		this(null, null);
	}

	public BinaryHeap(Comparator<E> comparator) {
		this(null, comparator);

	}

	private int compare(E e1, E e2) {
		if (comparator == null) {
			return ((Comparable) e1).compareTo(e2);
		} else {
			return comparator.compare(e1, e2);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
	}

	public E[] clearAndGetTopK(E[] element,int k) {
		clear();
		for (int i = 0; i < element.length; i++) {
			if(size<k) {
				add(element[i]);
			} else if(compare(element[i], get())>0) {
				replace(element[i]);
			}
		}
		return elements;
	}
	@Override
	public void add(E element) {
		objectCheck(element);
		ensureCapacity(size + 1);
		elements[size++] = element;
		// иобк
		int index = size - 1;
		siftUp(index);
	}

	private void siftUp(int index) {
//		while(index >0 && compare(elements[index],elements[(index - 1)/2])> 0) {
//			E temp = elements[index];
//			elements[index] = elements[(index - 1)/2];
//			elements[(index - 1)/2] = temp;
//			index = (index - 1)/2;
//		}

		E comEle = elements[index];
		while (index > 0 && compare(comEle, elements[(index - 1) / 2]) > 0) {
			elements[index] = elements[(index - 1) / 2];
			index = (index - 1) / 2;
		}
		elements[index] = comEle;

	}

	@Override
	public E get() {
		emptyCheck();
		return elements[0];

	}

	public void emptyCheck() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("Heap is empty");
		}
	}

	public void objectCheck(E e) {
		if (e == null) {
			throw new IndexOutOfBoundsException("OBject is empty");
		}
	}

	@Override
	public E remove() {
		emptyCheck();
		int lastIndex = --size;
		E repEle = elements[0];
		elements[0] = elements[lastIndex];
		elements[lastIndex] = null;
		siftDown(0);
		return repEle;
	}

	public void siftDown(int index) {
		E rootEle = elements[index];
//		while (true) {
//			int lIndex = index * 2 + 1;
//			int rIndex = index * 2 + 2;
//			boolean lIs = false;
//			boolean rIs = false;
//			if (lIndex <= size - 1 && compare(elements[lIndex], rootEle) > 0) {
//				lIs = true;
//
//			} else if (rIndex <= size - 1 && compare(elements[rIndex], rootEle) > 0) {
//				rIs = true;
//
//			} else {
//				break;
//			}
//			if (lIs && rIs) {
//				if (compare(elements[lIndex], elements[rIndex]) > 0) {
//					elements[index] = elements[lIndex];
//					index = lIndex;
//				} else {
//					elements[index] = elements[rIndex];
//					index = rIndex;
//				}
//			} else if (lIs) {
//				elements[index] = elements[lIndex];
//				index = lIndex;
//			} else if (rIs) {
//				elements[index] = elements[rIndex];
//				index = rIndex;
//			}
//		}
		while (index < size / 2) {
			int repIndex = index * 2 + 1;
			if (repIndex + 1 <= size - 1 && compare(elements[repIndex + 1], elements[repIndex]) > 0) {
				repIndex += 1;
			}
			if (compare(rootEle, elements[repIndex]) > 0)
				break;
			elements[index] = elements[repIndex];
			index = repIndex;
		}
		elements[index] = rootEle;
	}

	@Override
	public E replace(E element) {
		objectCheck(element);
		if (size == 0) {
			elements[0] = element;
			size++;
		}
		E result = elements[0];
		elements[0] = element;
		siftDown(0);
		return result;
	}

	public void ensureCapacity(int size) {
		int length = elements.length;
		if (size < length) {
			return;
		}
		while (length <= size) {
			length *= 1.5;
		}
		E[] newEle = (E[]) new Object[(int) length];
		for (int i = 0; i < length; i++) {
			newEle[i] = elements[i];
		}
		elements = newEle;
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub

	}

}
