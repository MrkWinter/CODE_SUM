package com.dataStract.unit2._02unionfind;

public class QuickUnion extends UnionFind {

	public QuickUnion(int capacity) {
		if(capacity <0) {
			throw new IllegalArgumentException("capacity >=1");
		}
		parent = new int[capacity];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}
	@Override
	public int find(int v) {
		ensureEle(v);
		while(parent[v] != v) {
			v = parent[v];
		}
		return v;
	}

	@Override
	public void union(int v1, int v2) {
		int r1 = find(v1);
		int r2 = find(v2);
		if(r1 == r2)
			return;
		parent[r1] = r2;
	}

	@Override
	public boolean isSame(int v1, int v2) {
		return find(v1) == find(v2);
	}

	public void ensureEle(int v) {
		if (v < 0 || v >= parent.length) {
			throw new IllegalArgumentException("v error");
		}
	}
}
