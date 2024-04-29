package com.dataStract.unit2._02unionfind;

public class QuickUnionRanks extends QuickUnion {
	private int[] ranks;

	public QuickUnionRanks(int capacity) {
		super(capacity);
		ranks = new int[capacity];
		for (int i = 0; i < ranks.length; i++) {
			ranks[i] = 1;
		}
	}

	@Override
	public void union(int v1, int v2) {
		int r1 = find(v1);
		int r2 = find(v2);
		if (r1 == r2)
			return;
		if (ranks[r1] > ranks[r2]) {
			parent[r2] = r1;
		} else if (ranks[r1] < ranks[r2]) {
			parent[r1] = r2;
		} else {
			parent[r1] = r2;
			ranks[r2]+=1;
		}
	}
}
