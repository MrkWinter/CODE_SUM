package com.dataStract.unit1._06erchashu;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> extends BinaryTree<E> {

	private Comparator<E> comparator;

	public BinarySearchTree(Comparator<E> comparer) {
		this.comparator = comparer;
	}

	public BinarySearchTree() {
		super();
	}

	protected Node<E> createNode(E e1,Node<E> parent) {
		return new Node<E>(e1, null);
	}
	protected void afterRemove(Node<E> ndoe,Node<E> replaceNode) {}
	protected void afterAdd(Node<E> node) {};
	//添加元素
	public void add(E element) {
		if (root == null) {
			root = createNode(element, null);
			size += 1;
			afterAdd(root);
			return;
		}
		Node<E> cur = root;
		int com = 0;
		while (true) {
			com = compare(element, cur.element);
			if (com < 0) {
				if (cur.left != null) {
					cur = cur.left;
				} else {
					cur.left = createNode(element, cur);
					size++;
					break;
				}
			} else if (com > 0) {
				if (cur.right != null) {
					cur = cur.right;
				} else {
					cur.right = createNode(element, cur);
					size++;
					break;
				}
			} else {
				cur.element = element;
				break;
			}
		}
		afterAdd(cur);
	}

	public int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable) e1).compareTo(e2);

	}

	public void remove(E element) {
		removeNode(findNode(element));
	}
	//删除元素
	private void removeNode(Node<E> node) {
		if (node == null)
			return;
		size--;
		if (haveTwoChild(node)) {
			Node<E> s = successor(node);
			node.element = s.element;
			node = s;
		}

		Node<E> replaceNode = node.left != null ? node.left : node.right;

		if (replaceNode != null) {
			replaceNode.parent = node.parent;
		}
		if (node.parent == null) {
			root = replaceNode;
		} else if (node.isLeftChild()) {
			node.parent.left = replaceNode;
		} else {
			node.parent.right = replaceNode;
		}
		afterRemove(node,replaceNode);
	}

	private void removeNodeV(Node<E> node) {
		if (node == null) {
			return;
		}
		size--;
		if (haveTwoChild(node)) {
			Node<E> s = successor(node);
			node.element = s.element;
			node = s;
		}

		Node<E> replaceNode = node.left != null ? node.left : node.right;

		if (replaceNode != null) {
			replaceNode.parent = node.parent;
			// 删除 有一个孩子的结点
			if (node.parent == null) {
				root = replaceNode;
			} else if (node.parent.left == node) {
				node.parent.left = replaceNode;
			} else {
				node.parent.right = replaceNode;
			}
		} else {
			// 删除没有孩子的结点
			if (node.parent == null) {
				root = null;
			} else if (node.parent.left == node) {
				node.parent.left = null;
			} else {
				node.parent.right = null;
			}

		}
	}
	//查找元素
	protected Node<E> findNode(E element) {
		Node<E> fNode = root;
		while (fNode != null) {
			if (compare(element, fNode.element) < 0) {
				fNode = fNode.left;
			} else if (compare(element, fNode.element) > 0) {
				fNode = fNode.right;
			} else {
				return fNode;
			}
		}
		return null;
	}

	//是否为空
	public boolean contains(E element) {
		return findNode(element) == null;
	}

	public static interface Visitor<E> {
		public void visit(Node<E> element);
	}
}
