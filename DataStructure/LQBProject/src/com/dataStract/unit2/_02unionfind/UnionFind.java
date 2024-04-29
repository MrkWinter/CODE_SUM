package com.dataStract.unit2._02unionfind;

public abstract class UnionFind {
	int[] parent;

	public abstract int find(int v);

	public abstract void union(int v1, int v2);

	public abstract boolean isSame(int v1, int v2);
}
