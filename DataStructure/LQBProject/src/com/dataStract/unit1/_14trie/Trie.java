package com.dataStract.unit1._14trie;

import java.util.HashMap;

//×ÖµäÊ÷
public class Trie<V> {
	private int size;
	private Node<V> root;

	public int size() {
		return 0;
	}

	public Trie(Node<V> root) {
		root = new Node<V>();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		size = 0;
		root.childen = null;
	}

	public V get(String key) {
		Node<V> result = getNode(key);
		if (result == null) {
			return null;
		}
		return result.value;
	}

	public boolean contains(String key) {
		return getNode(key) != null;
	}

	public V add(String key, V value) {
		keyCheck(key);
		if (root == null)
			return null;
		Node<V> node = root;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			Node<V> nextNode = node.getChilden().get(c);
			if (nextNode == null) {
				nextNode = new Node<V>();
				node.getChilden().put(c, nextNode);
			}
			node = nextNode;
		}
		V result = null;
		if (node.word == true) {
			result = node.value;
			node.value = value;
		} else {
			node.word = true;
			node.value = value;
			size += 1;
		}
		return result;
	}

	public V remove(String key) {
		if (!contains(key))
			return null;
		size--;
		keyCheck(key);
		if (root == null)
			return null;
		Node<V> node = root;
		Node<V> delNode = root;
		char delKey = key.charAt(0);
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			HashMap<Character, Node<V>> childen = node.getChilden();
			if (childen.size() >= 2 || node.word == true) {
				delNode = node;
				delKey = c;
			}
			node = childen.get(c);
		}
		V result = node.value;
		if (node.getChilden().size() > 0) {
			node.word = false;
			node.value = null;
		} else {
			delNode.getChilden().remove(delKey);
		}
		return result;
	}

	public boolean startsWith(String prefix) {
		keyCheck(prefix);
		if (root == null)
			return false;
		Node<V> node = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			Node<V> nextNode = node.getChilden().get(c);
			if (nextNode == null)
				return false;
			node = nextNode;
		}
		return true;
	}

	public Node<V> getNode(String key) {
		keyCheck(key);
		if (root == null)
			return null;
		Node<V> node = root;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			Node<V> nextNode = node.getChilden().get(c);
			if (nextNode == null)
				return null;
			node = nextNode;
		}
		return node.word ? node : null;
	}

	public void keyCheck(String key) {
		if (key == null || key.length() == 0)
			throw new IllegalArgumentException("key error");
	}

	private static class Node<V> {
		HashMap<Character, Node<V>> childen;
		V value;
		boolean word;

		public HashMap<Character, Node<V>> getChilden() {
			return childen == null ? (childen = new HashMap<Character, Node<V>>()) : childen;
		}

	}
}
