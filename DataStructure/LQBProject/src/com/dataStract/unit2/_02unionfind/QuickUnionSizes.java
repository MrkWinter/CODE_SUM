package com.dataStract.unit2._02unionfind;

public class QuickUnionSizes extends QuickUnion {
	private int[] size;

	public QuickUnionSizes(int capacity) {
		super(capacity);
		size = new int[capacity];
		for (int i = 0; i < size.length; i++) {
			size[i] = 1;
		}
	}

	@Override
	public void union(int v1, int v2) {
		int r1 = find(v1);
		int r2 = find(v2);
		if(r1 == r2)
			return;
		if(size[r1]>size[r2]) {
			parent[r2] = r1;
			size[r1]+=size[r2];
		} else {
			parent[r1] = r2;
			size[r2]+=size[r1];
		}	
	}

}
