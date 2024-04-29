package com.dataStract.unit2._02unionfind;

// Â·¾¶·ÖÁÑ
public class QuickUnionRanksPS extends QuickUnionRanks {

	public QuickUnionRanksPS(int capacity) {
		super(capacity);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int find(int v) {
		ensureEle(v);
		while(parent[v] != v) {
			int p = parent[v];
			parent[v] = parent[parent[v]];
			v = p;
		}
		return v;
	}
}
