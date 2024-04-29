package com.dataStract.unit1._06erchashu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> {
	protected int size;
	protected Node<E> root;

	public BinaryTree() {
		super();
	}

	public int getTreeHight() {
		return getHight(root);
	}

	// 递归得到树高
	public int getHight(Node<E> node) {
		return node == null ? 0 : Math.max(getHight(node.left), getHight(node.right)) + 1;
	}

	// 非递归得到树高
	public int getTreeHight2() {
		if (root == null)
			return 0;
		Queue<Node<E>> queue = new LinkedList<Node<E>>();
		queue.offer(root);
		int levelNum = 1;
		int hight = 0;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelNum--;

			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null)
				queue.offer(node.right);

			if (levelNum == 0) {
				levelNum = queue.size();
				hight++;
			}
		}
		return hight;
	}

	public boolean isComplete() {
		return isComplete(root);
	}

	// 判断是否为完全二叉树
	private boolean isComplete(Node<E> root) {
		if (root == null)
			return true;
		Queue<Node<E>> queue = new LinkedList<Node<E>>();
		queue.offer(root);
		boolean leaf = false;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (leaf && (node.left != null || node.right != null))
				return false;

			if (node.left != null) {
				queue.offer(node.left);
			} else if (node.right != null) {
				return false;
			}

			if (node.right != null) {
				queue.offer(node.right);
			} else {
				leaf = true;
			}
		}
		return true;
	}

	public void reverseTree() {
		reverseTree(root);
	}

	// 反转二叉树
	private void reverseTree(Node<E> node) {
		if (node == null)
			return;
		Node<E> temp = node.left;
		node.left = node.right;
		node.right = temp;
		reverseTree(node.left);
		reverseTree(node.right);

	}

	// 找中序遍历结点的前驱
	protected Node<E> predecessor(Node<E> node) {
		if (node == null)
			return null;
		// 左
		Node<E> p = node.left;
		if (p != null) {
			while (p.right != null) {
				p = p.right;
			}
			return p;
		}

		// 右上
		p = node;
		while (p != null && p.parent.right != p) {
			p = p.parent;
		}
		return p.parent;
	}

	// 找后继
	protected Node<E> successor(Node<E> node) {
		if (node == null)
			return null;
		// 左
		Node<E> p = node.right;
		if (p != null) {
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}

		// 右上
		p = node;
		while (p != null && p.parent.left != p) {
			p = p.parent;
		}
		return p.parent;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		size = 0;
		root = null;
	}

	// 先序展示二叉树
	private void showTree(Node<E> node) {
		if (node != null)
			System.out.println(node);
		else
			return;
		showTree(node.left);
		showTree(node.right);
	}

	// 非递归 先序遍历  有两种方法
	private void preShow(Visitor<E> vis) {
		if (root == null || vis == null)
			return;
		Node<E> node = root;
		Stack<Node<E>> stack = new Stack();
		while (true) {
			if (node != null) {
				vis.visit(node);
				if (node.right != null)
					stack.push(node.right);
				node = node.left;
			} else if (!stack.isEmpty()) {
				node = stack.pop();
			} else {
				return;
			}
		}
	}

	public void midShow(Visitor<E> vis) {
		if (root == null || vis == null)
			return;
		Node<E> node = root;
		Stack<Node<E>> stack = new Stack();
		while (true) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else if (!stack.isEmpty()) {
				node = stack.pop();
				vis.visit(node);
				node = node.right;
			} else {
				return;
			}
		}
	}

	public void postShow(Visitor<E> vis) {
		if (root == null || vis == null)
			return;
		Node<E> node = root;
		Node<E> preNode = null;
		Stack<Node<E>> stack = new Stack();
		stack.push(root);
		while (!stack.isEmpty()) {
			node = stack.peek();
			if (node.isLeaf() || preNode!=null && node == preNode.parent) {
				node = stack.pop();
				preNode = node;
				vis.visit(node);
			} else {
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
			}
		}
	}

	// 层次处理二叉树每个结点
	public void levelOrder(Visitor<E> vis) {
		if (root == null)
			return;
		Queue<Node<E>> queue = new LinkedList<Node<E>>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (vis != null)
				vis.visit(node);
			else
				System.out.println(node);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null)
				queue.offer(node.right);
		}
	}

	public void showTree() {
		showTree(root);
	}

	public boolean haveTwoChild(Node<E> node) {
		if (node.left != null && node.right != null) {
			return true;
		}
		return false;
	}

	private void elementNull(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element is null");
		}
	}

	public static interface Visitor<E> {
		public void visit(Node<E> element);
	}

	protected static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;

		public Node(E element, Node<E> parent) {
			super();
			this.element = element;
			this.parent = parent;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}

		public boolean haveTwoChild() {
			return left != null && right != null;
		}

		public boolean haveChild() {
			return left != null || right != null;
		}

		public boolean isLeftChild() {
			return parent != null && parent.left == this;
		}

		public boolean isRightChild() {
			return parent != null && parent.right == this;
		}

		public Node<E> sibling() {
			if (this.isLeftChild()) {
				return parent.right;
			}

			if (this.isRightChild()) {
				return parent.left;
			}
			return null;
		}

		@Override
		public String toString() {
			return "Node [element=" + element + "]";
		}

		public boolean haveChild(Node<E> s) {
			return left == s || right == s;
		}

	}
}
