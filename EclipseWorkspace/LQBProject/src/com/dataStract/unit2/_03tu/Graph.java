package com.dataStract.unit2._03tu;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Graph<V, E> {
	WightManager<E> wightManager;

	public Graph(WightManager<E> wightManager) {
		super();
		this.wightManager = wightManager;
	}

	public Graph() {
		this(null);
	}

	public int vertexSize() {
		return 0;
	}

	public int edgeSize() {
		return 0;
	}

	public void addVertex(V v1) {
	}

	public void addEdge(V from, V to, E weigth) {
	}

	public void addEdge(V from, V to) {
	}

	public void delVertex(V v1) {
	}

	public void delEdge(V from, V to) {
	}

	public void bfs(V v1) {
	}

	public void dfs(V v1) {
	}

	public List<V> toPogSort() {
		return null;
	}

	public Set<EdgeInfo<V, E>> prim(V v1) {
		return null;
	}

	public interface WightManager<E> {
		public int compare(E w1, E w2);

		public E add(E w1, E w2);
	}

	public class EdgeInfo<V, E> {
		V from;
		V to;
		E weight;

		public EdgeInfo(V from, V to, E weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public class PathInfo<V, E> {
		List<EdgeInfo<V, E>> path = new ArrayList<EdgeInfo<V, E>>();
		E allWeight;
		V begin;
		V end;
		boolean fix;

		public PathInfo(E allWeight) {
			super();
			this.allWeight = allWeight;
		}

		public PathInfo() {
		}

		public PathInfo(V begin, V end,E allWeight) {
			this.allWeight = allWeight;
			this.begin = begin;
			this.end = end;
		}

		@Override
		public String toString() {
			return "PathInfo [path=" + path + ", allWeight=" + allWeight + ", begin=" + begin + ", end=" + end + "]";
		}
		
	}
}
