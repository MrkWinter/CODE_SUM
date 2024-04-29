package com.dataStract.unit1._06erchashu;

import com.dataStract.unit1._06erchashu.BinarySearchTree;

public class Test {
	public static void main(String[] args) {
		Integer[] arr = { 7, 4, 5, 8, 12, 11, 3 };
//		BinarySearchTree<Integer> binTree = new AVLTree<Integer>(null);
		RBTree<Integer> binTree = new RBTree<Integer>();
		for (int i = 0; i < arr.length; i++) {
			binTree.add(arr[i]);
		}
//		binTree.showTree();

//		binTree.levelOrder(new Visitor<Integer>() {
//			
//			@Override
//			public void visit(Node<Integer> node) {
//				System.out.println(node + "ddd");
//				
//			}
//		});
		
		System.out.println(binTree.getTreeHight2());
		
		System.out.println(binTree.isComplete());
		binTree.remove(12);
		binTree.remove(7);
		binTree.remove(4);
		binTree.remove(11);
		binTree.remove(3);
		binTree.remove(0);
		binTree.showTree();
		long a = 100_0_0_0_0;
	}
	
}
