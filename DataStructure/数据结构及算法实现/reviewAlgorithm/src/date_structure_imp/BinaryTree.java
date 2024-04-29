package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class BinaryTree {
    public static void main(String[] args) {

    }
}

class BinaryT {
    private TNode root;

    //前序遍历
    public void perOrder() {
        if (this.root != null) {
            root.preOrder();
        }
    }
}

class TNode {
    private int date;
    private TNode left;
    private TNode right;

    //前序遍历
    public void preOrder() {
        System.out.println(date);
        if (this.left != null) {
            left.preOrder();
        }
        if (right != null) {
            right.preOrder();
        }
    }

    public void infixOrder() {

        if (this.left != null) {
            left.preOrder();
        }
        System.out.println(date);

        if (right != null) {
            right.preOrder();
        }
    }

    public void postOrder() {

        if (this.left != null) {
            left.preOrder();
        }
        if (right != null) {
            right.preOrder();
        }
        System.out.println(date);

    }

    public TNode(int date) {
        this.date = date;
    }

    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TNode{" +
                "date=" + date +
                '}';
    }
}
