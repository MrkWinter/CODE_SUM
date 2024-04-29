package com.dataStract.unit2._skiplist;

import java.util.Comparator;

public class SkipList<K, V> {
	private static final int MAX_LEVEL = 32;
	private static final double PROBABLITY = 0.25;
	private int size;
	private Comparator<K> comparator;

	private Node<K, V> frist = new Node<K,V>();
	private int fLevel;

	public SkipList(Comparator<K> comparator) {
		this();
		this.comparator = comparator;

	}

	public SkipList() {
		frist.nexts = new Node[MAX_LEVEL];
	}

	public int compare(K k1, K k2) {
		if (comparator != null) {
			return comparator.compare(k1, k2);
		}
		return ((Comparable<K>) k1).compareTo(k2);
	}

	public int getLevel() {
		int count = 0;
		while (Math.random() > PROBABLITY && count < MAX_LEVEL) {
			count++;
		}
		return count;
	}

	public void keyChack(K k) {
		if (k == null) {
			throw new IllegalArgumentException("error");
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public V put(K key, V value) {
		keyChack(key);
		Node<K, V> node = frist;
		Node<K, V>[] keepNode = new Node[MAX_LEVEL];
		for (int i = fLevel; i >= 0; i--) {
			int cmp = -1;
			while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
				node = node.nexts[i];
			}
			if (cmp == 0) {
				V ret = node.nexts[i].value;
				node.nexts[i].value = value;
				return ret;
			}
			keepNode[i] = node;
		}
		int level = getLevel();
		Node<K, V> newNode = new Node<K, V>(level+1, key, value);
		size += 1;
		for (int i = 0; i <= level; i++) {
			if (i > fLevel) {
				// 修改首结点指针
				frist.nexts[i] = newNode;
			} else {
				newNode.nexts[i] = keepNode[i].nexts[i];
				keepNode[i].nexts[i] = newNode;
			}
		}
		fLevel = Math.max(fLevel, level);
		return value;
	}

	public V get(K key) {
		keyChack(key);
		Node<K, V> node = frist;
		for (int i = fLevel; i >= 0; i--) {
			Node<K, V> next = node.nexts[i];
			int cmp = -1;
			if (next != null && (cmp = compare(key, next.key)) > 0) {
				node = next;
				i++;
			} else if (cmp == 0) {
				return next.value;
			}
		}
		return null;
	}

	public V remove(K key) {
		keyChack(key);
		Node<K, V> node = frist;
		Node<K, V>[] frontNode = new Node[MAX_LEVEL];
		Node<K,V> ret = null;
		for (int i = fLevel; i >= 0; i--) {
			int cmp = -1;
			while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
				node = node.nexts[i];
			}
			if (cmp == 0) {
				ret = node.nexts[i];
			}
			frontNode[i] = node;
		}
		if(ret == null)
			return null;
		size -= 1;
		for (int i = 0; i < ret.nexts.length; i++) {
			frontNode[i].nexts[i] = ret.nexts[i];
		}
		// 更新最高层
		while (fLevel >= 0 && frist.nexts[fLevel] == null) {
			fLevel -= 1;
		}
		return ret.value;
	}

	class Node<K, V> {
		Node<K, V> nexts[];
		K key;
		V value;

		public Node(int size, K key, V value) {
			super();
			this.nexts = new Node[size];
			this.key = key;
			this.value = value;
		}

		public Node() {

		}

	}
}
