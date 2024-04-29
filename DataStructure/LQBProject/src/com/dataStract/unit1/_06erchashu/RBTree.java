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
		// 1. 四种不用染色操作的情况 duble 黑
		if (isBlack(node.parent)) {
			if (node.parent == null) {
				black(node);
			}
			return;
		}
		Node<E> p = node.parent;
		Node<E> g = p.parent;
		// 剩下的是duble红
		// 2. 四种需要旋转的情况 ll lr rl rr
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
		// 3. 四种不需要旋转的情况
		else {
			black(p);
			black(p.sibling());
			red(node);
			afterAdd(node);
		}
	}

	// 注意 红黑树(二叉排序树)删除操作如果是两个孩子结点 那么一定有前驱 删除的为叶子结点 或者单孩子结点
	// 如果是 所以删除的一定为叶子结点或者单孩子结点
	@Override
	protected void afterRemove(Node<E> node, Node<E> replaceNode) {
		// 1. 删除结点为红 直接删除 不用多余步骤 因为 double黑不冲突
		if (isRed(node)) {
			return;
		}
		// 2. 删除结点为黑 分两种情况 ( 如果删除结点为黑的话)
		// 替代结点为红 直接染黑 用红结点替代这一层
		if (isRed(replaceNode)) {
			black(replaceNode);
			return;
		}
		// 替代结点为黑 (或为空结点)直接删除会减少层数 有多种情况
		else {
			Node<E> p = node.parent;
			Node<E> s = null;
			boolean isLeft = p.left == null || node.isLeftChild();
			s = (isLeft ? p.right : p.left);
			if (p == null)
				return; // 根节点 直接删除了 不用操作

			// 兄弟是黑的
			if (isBlack(s)) {
				// 有红孩子 能借
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
				// 没有红孩子 不能借 下溢
				else {
					if (isBlack(p)) {
						// 如果父节点是黑色 等于继续处理单黑结点
						afterRemove(node, null);
					}
					black(p);
					red(s);

				}
			}
			// 兄弟是红的
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
		// 1 指右下
		Node<E> p = node.right;
		node.right = p.left;
		if (node.right != null) {
			node.right.parent = node;
		}
		// 2. 重定根
		if (node.isLeftChild()) {
			node.parent.left = p;
		} else if (node.isRightChild()) {
			node.parent.right = p;
		}
		p.parent = node.parent;
		// 3.根转移
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
