package com.dataStract.unit2._02unionfind;

//QuickUnion + Ranks平衡高度 + 路径压缩
public class QuickUnionRanksPC extends QuickUnionRanks {
	public QuickUnionRanksPC(int capacity) {
		super(capacity);

	}

	@Override
	public int find(int v) {
		ensureEle(v);
		while(parent[v] != v) {
			parent[v] = find(parent[v]);
		}
		return parent[v];
	}
}
