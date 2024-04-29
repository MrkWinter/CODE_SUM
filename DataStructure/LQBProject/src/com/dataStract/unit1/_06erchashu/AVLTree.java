package com.dataStract.unit1._06erchashu;

import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E> {
	public AVLTree(Comparator<E> comparer) {
		super(comparer);
	}

	@Override
	protected void afterAdd(Node<E> node) {
		while ((node = node.parent) != null) {
			if (isBalance(node)) {
				updateHight(node);
			} else {
				reBalance(node);
				break;
			}
		}
	}

	@Override
	protected void afterRemove(Node<E> node,Node<E> replaceNode) {
		while ((node = node.parent) != null) {
			if (isBalance(node)) {
				updateHight(node);
			} else {
				reBalance(node);
			}
		}
	}
	private void reBalance(Node<E> node) {
		if (getLeftHigth(node) - getRightHigth(node) > 1) {
			// LL ÓÒÐý
			if (getRightHigth(node.left) - getLeftHigth(node.left) >= 1) {
				// LR ÏÈ×óÐý ºóÓÒÐý
				leftRoal(node.left);
			}
			rightRoal(node);

		} else {
			// RR ×óÐý
			if (getLeftHigth(node.right) - getRightHigth(node.right) >= 1) {
				// RL ÏÈÓÒÐý ºó×óÐý
				rightRoal(node.right);
			}
			leftRoal(node);
		}
	}

	private void rightRoal(Node<E> node) {
		Node<E> newNode = createNode(node.element, node.parent);
		newNode.right = node.right;
		if (node.right != null)
			node.left.parent = newNode;
		newNode.left = node.left.right;
		if (newNode.left != null)
			newNode.left.parent = newNode;
		node.element = node.left.element;
		node.left = node.left.left;
		if (node.left != null)
			node.left.parent = node;
		node.right = newNode;
		newNode.parent = node;
		updateHight(newNode);
		updateHight(node);
	}

	private void leftRoal(Node<E> node) {
		Node<E> newNode = createNode(node.element, node.parent);
		newNode.left = node.left;
		if (node.left != null)
			node.left.parent = newNode;
		newNode.right = node.right.left;
		if (newNode.right != null)
			newNode.right.parent = newNode;
		node.element = node.right.element;
		node.right = node.right.right;
		if (node.right != null)
			node.right.parent = node;
		node.left = newNode;
		newNode.parent = node;

		updateHight(newNode);
		updateHight(node);

	}

	private int getLeftHigth(Node<E> node) {
		if(node.left ==null)
			return 0;
		return ((AVLNode) (node.left)).hight;
	}

	private int getRightHigth(Node<E> node) {
		if(node.right ==null)
			return 0;
		return ((AVLNode) (node.right)).hight;
	}

	private void updateHight(Node<E> node) {
		AVLNode aNode = (AVLNode) node;
		aNode.hight = Math.max(getLeftHigth(aNode), getRightHigth(aNode)) + 1;
	}

	@Override
	protected Node<E> createNode(E e1, Node<E> parent) {
		return new AVLNode(e1, parent);
	}

	protected boolean isBalance(Node<E> ANode) {
		if (getBalanceFactor(ANode) <= 1) {
			return true;
		}
		return false;
	}

	protected int getBalanceFactor(Node<E> ANode) {
		int leftHight = ANode.left == null ? 0 : ((AVLNode) (ANode.left)).hight;
		int rightHight = ANode.right == null ? 0 : ((AVLNode) (ANode.right)).hight;
		return Math.abs(leftHight - rightHight);
	}

	public static class AVLNode<E> extends Node<E> {
		public int hight = 1;

		public AVLNode(E element, Node<E> parent) {
			super(element, parent);
		}

	}
}
