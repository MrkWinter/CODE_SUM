package com.dataStract.unit2._02unionfind;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UnionFindT<V> {
	Map<V, Node<V>> parent = new HashMap();

	public UnionFindT(Collection<V> c) {
		makeSet(c);
	}

	public UnionFindT() {
	}

	public void makeSet(V v) {
		if (v == null)
			return;
		Node<V> node = new Node<V>(v);
		parent.put(v, node);
	}

	public void makeSet(Collection<V> c) {
		for (V v : c) {
			makeSet(v);
		}
	}

	public V find(V v) {
		Node<V> findNode = findNode(v);
		return findNode == null ? null : findNode.value;
	};

	public Node<V> findNode(V v) {
		Node<V> node = parent.get(v);
		if (node == null)
			return null;
		while (!Objects.equals(node.value, node.parent.value)) {
			node.parent = node.parent.parent;
			node = node.parent;
		}
		return node;
	};

	public void union(V v1, V v2) {
		Node<V> node1 = findNode(v1);
		Node<V> node2 = findNode(v2);
		if (node1 == null || node2 == null)
			return;
		if (Objects.equals(node1.value, node2.value))
			return;
		if (node1.rank > node2.rank) {
			node2.parent = node1;
		} else if (node1.rank < node2.rank) {
			node1.parent = node2;
		} else {
			node1.parent = node2;
			node2.rank += 1;
		}
	};

	public boolean isSame(V v1, V v2) {
		return Objects.equals(find(v1), find(v2));
	};

	public class Node<V> {
		V value;
		Node<V> parent = this;
		int rank = 1;

		public Node(V value) {
			super();
			this.value = value;
		}
	}
}
