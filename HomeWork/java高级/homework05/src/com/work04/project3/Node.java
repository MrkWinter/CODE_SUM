package com.work04.project3;

public class Node {
	
	String name;
	int weight;
	Node left;
	Node right;
	
	Node(String n,int w, Node l,Node r)
	{
		this.name=n;
		this.weight=w;
		this.left=l;
		this.right=r;
	}

}
