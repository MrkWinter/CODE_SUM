package com.work03;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class TwoThreeSearchTree {
    private Node root;

    private class Node {
        private int[] keys;
        private Node[] children;
        private int size;

        public Node() {
            keys = new int[2];
            children = new Node[3];
            size = 0;
        }

        public boolean isLeaf() {
            return children[0] == null;
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node();
            root.keys[0] = value;
            root.size++;
        } else {
            Node newNode = insert(root, value);
            if (newNode != null) {
                Node oldRoot = root;
                root = new Node();
                root.keys[0] = newNode.keys[0];
                root.children[0] = oldRoot;
                root.children[1] = newNode;
                root.size = 1;
            }
        }
    }

    private Node insert(Node node, int value) {
        int i = node.size - 1;
        while (i >= 0 && value < node.keys[i]) {
            node.keys[i + 1] = node.keys[i];
            i--;
        }

        i++;

        if (node.isLeaf()) {
            node.keys[i] = value;
            node.size++;
        } else {
            Node newNode = insert(node.children[i], value);
            if (newNode != null) {
                int j = node.size - 1;
                while (j >= i) {
                    node.keys[j + 1] = node.keys[j];
                    node.children[j + 2] = node.children[j + 1];
                    j--;
                }
                node.keys[i] = newNode.keys[0];
                node.children[i + 1] = newNode;
                node.size++;
            }
        }

        if (node.size == 3) {
            Node newNode = new Node();
            newNode.keys[0] = node.keys[2];
            newNode.children[0] = node.children[2];
            newNode.children[1] = node.children[3];
            newNode.size = 1;
            node.size = 2;
            return newNode;
        }

        return null;
    }

    public static void main(String[] args) {
        TwoThreeSearchTree tree = new TwoThreeSearchTree();
        int[] ints = {7, 15, 8, 10, 25, 100};
        for (int i : ints) {
            tree.insert(i);
        }
    }
}

