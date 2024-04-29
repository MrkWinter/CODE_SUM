package com.dataStract.unit2._02unionfind;

//Â·¾¶¼õ°ë
public class QuickUnionRanksPH extends QuickUnionRanks {

	public QuickUnionRanksPH(int capacity) {
		super(capacity);
	}
	@Override
	public int find(int v) {
		ensureEle(v);
		while(parent[v] != v) {
			parent[v] = parent[parent[v]];
			v = parent[v];
		}
		return v;
	}
}
