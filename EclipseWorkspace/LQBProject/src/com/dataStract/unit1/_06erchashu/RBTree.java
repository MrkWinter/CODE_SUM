package com.dataStract.unit1._06erchashu;

import java.util.Comparator;

public class RBTree<E> extends BinarySearchTree<E> {
	private static final boolean RED = false;
	private static final boolean BLACK = true;

	public RBTree() {
		this(null);
	}

	public RBTree(Comparator<E> comparer) {
		super(comparer);
	}

	private Node<E> color(Node<E> node, boolean color) {
		if (node == null)
			return node;
		((RBNode<E>) node).color = color;
		return node;
	}

	@Override
	protected void afterAdd(Node<E> node) {
		// 1. ���ֲ���Ⱦɫ��������� duble ��
		if (isBlack(node.parent)) {
			if (node.parent == null) {
				black(node);
			}
			return;
		}
		Node<E> p = node.parent;
		Node<E> g = p.parent;
		// ʣ�µ���duble��
		// 2. ������Ҫ��ת����� ll lr rl rr
		if (isBlack(p.sibling())) {
			if (p.isLeftChild()) {
				// lr
				if (node.isRightChild()) {
					black(node);
					red(g);
					leftRotate(p);
					rightRotate(g);
				}
				// ll
				else {
					black(p);
					red(g);
					rightRotate(g);
				}
			}
			if (p.isRightChild()) {
				// rl
				if (node.isLeftChild()) {
					black(node);
					red(g);
					rightRotate(p);
					leftRotate(g);
				}
				// rr
				else {
					black(p);
					red(g);
					leftRotate(g);
				}
			}
		}
		// 3. ���ֲ���Ҫ��ת�����
		else {
			black(p);
			black(p.sibling());
			red(node);
			afterAdd(node);
		}
	}

	// ע�� �����(����������)ɾ������������������ӽ�� ��ôһ����ǰ�� ɾ����ΪҶ�ӽ�� ���ߵ����ӽ��
	// ����� ����ɾ����һ��ΪҶ�ӽ����ߵ����ӽ��
	@Override
	protected void afterRemove(Node<E> node, Node<E> replaceNode) {
		// 1. ɾ�����Ϊ�� ֱ��ɾ�� ���ö��ಽ�� ��Ϊ double�ڲ���ͻ
		if (isRed(node)) {
			return;
		}
		// 2. ɾ�����Ϊ�� ��������� ( ���ɾ�����Ϊ�ڵĻ�)
		// ������Ϊ�� ֱ��Ⱦ�� �ú��������һ��
		if (isRed(replaceNode)) {
			black(replaceNode);
			return;
		}
		// ������Ϊ�� (��Ϊ�ս��)ֱ��ɾ������ٲ��� �ж������
		else {
			Node<E> p = node.parent;
			Node<E> s = null;
			boolean isLeft = p.left == null || node.isLeftChild();
			s = (isLeft ? p.right : p.left);
			if (p == null)
				return; // ���ڵ� ֱ��ɾ���� ���ò���

			// �ֵ��Ǻڵ�
			if (isBlack(s)) {
				// �к캢�� �ܽ�
				if (isRed(s.left)) {
					// ll
					if (s.isLeftChild()) {
						color(s, colorOf(p));
						black(p);
						black(s.left);
						rightRotate(p);
					}
					// rl
					else {
						color(s, colorOf(p));
						black(p);
						black(s.left);
						rightRotate(s);
						leftRotate(p);
					}
				} else if (isRed(s.right)) {
					// rr
					if (s.isRightChild()) {
						color(s, colorOf(p));
						black(p);
						black(s.left);
						leftRotate(p);
					}
					// lr
					else {
						color(s, colorOf(p));
						black(p);
						black(s.left);
						leftRotate(s);
						rightRotate(p);
					}
				}
				// û�к캢�� ���ܽ� ����
				else {
					if (isBlack(p)) {
						// ������ڵ��Ǻ�ɫ ���ڼ��������ڽ��
						afterRemove(node, null);
					}
					black(p);
					red(s);

				}
			}
			// �ֵ��Ǻ��
			else {
				red(p);
				black(s);
				if (s.isLeftChild()) {
					rightRotate(p);
				} else {
					leftRotate(p);
				}
				afterRemove(node, replaceNode);
			}
		}
	}

	private Node<E> red(Node<E> node) {
		return color(node, RED);
	}

	private Node<E> black(Node<E> node) {
		return color(node, BLACK);
	}

	private boolean colorOf(Node<E> node) {
		return node == null ? BLACK : ((RBNode<E>) node).color;
	}

	private boolean isBlack(Node<E> node) {
		return colorOf(node) == BLACK;
	}

	private boolean isRed(Node<E> node) {
		return colorOf(node) == RED;
	}

	public void leftRotate(Node<E> node) {
		// 1 ָ����
		Node<E> p = node.right;
		node.right = p.left;
		if (node.right != null) {
			node.right.parent = node;
		}
		// 2. �ض���
		if (node.isLeftChild()) {
			node.parent.left = p;
		} else if (node.isRightChild()) {
			node.parent.right = p;
		}
		p.parent = node.parent;
		// 3.��ת��
		p.left = node;
		node.parent = p;
	}

	public void rightRotate(Node<E> node) {
		Node<E> p = node.left;
		node.left = p.right;
		if (node.left != null) {
			node.left.parent = node;
		}

		p.parent = node.parent;
		if (node.isLeftChild()) {
			node.parent.left = p;
		} else if (node.isRightChild()) {
			node.parent.right = p;
		}

		p.right = node;
		node.parent = p;
	}

	@Override
	protected Node<E> createNode(E e1, Node<E> parent) {
		// TODO Auto-generated method stub
		return new RBNode<E>(e1, parent);
	}

	public static class RBNode<E> extends Node<E> {
		boolean color;

		public RBNode(E element, Node<E> parent) {

			super(element, parent);
			// TODO Auto-generated constructor stub
		}

	}
}
