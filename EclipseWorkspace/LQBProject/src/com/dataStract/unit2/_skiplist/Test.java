package com.dataStract.unit2._skiplist;

public class Test {
	public static void main(String[] args) {
		SkipList<Integer, String> skipList = new SkipList<Integer, String>();
		skipList.put(1, "a");
		skipList.put(2, "a");
		skipList.put(3, "b");
		skipList.put(4, "a");
		skipList.put(5, "a");
		String string = skipList.get(3);
		System.out.println(string);
		skipList.remove(2);
	}

}
