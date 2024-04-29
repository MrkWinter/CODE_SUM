package com.dataStract.unit2._03tu;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.dataStract.unit2._03tu.Graph.PathInfo;

public class Test {
	public static void main(String[] args) {
		ListGraph<String, Integer> listGraph = new ListGraph<String, Integer>();

		listGraph.addEdge("a", "b", 3);
		listGraph.addEdge("b", "c", 5);
		listGraph.addEdge("c", "f", 6);
		listGraph.addEdge("a","c",7); 
//		listGraph.primD("a");
//		listGraph.kruskal("a");

//		Map<String, Graph<String, Integer>.PathInfo<String, Integer>> dijkstra = listGraph.dijkstra("a", 100000,0);
//		Collection<Graph<String, Integer>.PathInfo<String, Integer>> values = dijkstra.values();
//		for(Graph<String, Integer>.PathInfo<String, Integer> p : values) {
//			System.out.println(p);
//		}
		 HashMap<String, HashMap<String, Graph<String, Integer>.PathInfo<String, Integer>>> floyd = listGraph.floyd(100000,0);
		 for(HashMap<String,Graph<String, Integer>.PathInfo<String, Integer>> p: floyd.values()) {
			 for ( Graph<String, Integer>.PathInfo<String, Integer> h: p.values()) {
				System.out.println(h);
				 
			}
		 }
	}
}
