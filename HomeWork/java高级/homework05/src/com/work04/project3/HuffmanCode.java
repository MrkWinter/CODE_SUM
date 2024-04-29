package com.work04.project3;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanCode {

	List<Node> charCounters;
	Node root;
	List<String> listNode;

	public HuffmanCode() {
		this.charCounters = new ArrayList<>();
		root = null;
		listNode = new ArrayList<>();
	}

	public void count(String str) {
		for (char c : str.toCharArray()) {
			boolean found = false;
			for (Node node : charCounters) {
				if (node.name.equals(String.valueOf(c))) {
					node.weight++;
					found = true;
					break;
				}
			}
			if (!found) {
				charCounters.add(new Node(String.valueOf(c), 1, null, null));
			}
		}
	}

	public void createHuffmanTree() {
		Queue<Node> queue = new PriorityQueue<>(charCounters.size(), (n1, n2) -> n1.weight - n2.weight);

		for (Node node : charCounters) {
			queue.add(node);
		}

		while (queue.size() > 1) {
			Node n1 = queue.poll();
			Node n2 = queue.poll();
			Node parent = new Node(n1.name + n2.name, n1.weight + n2.weight, n1, n2);
			queue.add(parent);
		}

		root = queue.poll();
	}

	private void preOrder(Node node) {
		if (node != null) {
			listNode.add(node.name);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public String toString() {
		preOrder(root);
		return listNode.toString();
	}

	public static void main(String[] args) {
		HuffmanCode hf = new HuffmanCode();
		hf.count("abcdeadded");
		hf.createHuffmanTree();
		System.out.println(hf.toString());
	}
}
