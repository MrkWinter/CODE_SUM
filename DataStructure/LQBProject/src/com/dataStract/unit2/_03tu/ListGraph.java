package com.dataStract.unit2._03tu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import com.dataStract.unit2._02unionfind.UnionFindT;

public class ListGraph<V, E> extends Graph<V, E> {
	public Map<V, Vertex<V, E>> vertexs = new HashMap();
	public Set<Edge<V, E>> edges = new HashSet();
	public Comparator<E> comparator;

	public ListGraph(WightManager<E> wightManager) {
		this();
		super.wightManager = wightManager;
	}

	public ListGraph(Comparator<E> comparator) {
		this();
		this.comparator = comparator;
	}

	public ListGraph() {
		super.wightManager = new WightManager<E>() {

			@Override
			public int compare(E w1, E w2) {
				return compareWeight(w1, w2);
			}

			@Override
			public E add(E w1, E w2) {
				if (w1 instanceof Integer && w2 instanceof Integer) {
					return (E) (Integer) (((Integer) w1 + (Integer) w2));
				} else if (w1 instanceof String && w2 instanceof String) {
					return (E) ((String) w1 + (String) w2);
				} else {
					return null;
				}
			}
		};
	}

	@Override
	public int vertexSize() {
		return vertexs.size();
	}

	@Override
	public int edgeSize() {
		return edges.size();
	}

	@Override
	public void addVertex(V v1) {
		if (vertexs.containsKey(v1))
			return;
		Vertex<V, E> ver = new Vertex<V, E>(v1);
		vertexs.put(v1, ver);
	}

	@Override
	public void addEdge(V from, V to, E weigth) {
		addVertex(from);
		addVertex(to);
		//
		Vertex<V, E> fVer = vertexs.get(from);
		Vertex<V, E> tVer = vertexs.get(to);
		Edge<V, E> edge = null;
		if (weigth != null)
			edge = new Edge<V, E>(fVer, tVer, weigth);
		else
			edge = new Edge<V, E>(fVer, tVer);
		if (edges.contains(edge))
			edges.remove(edge);
		edges.add(edge);
		//
		if (fVer.outEdge.contains(edge))
			fVer.outEdge.remove(edge);
		fVer.outEdge.add(edge);
		if (tVer.inEdge.contains(edge))
			tVer.inEdge.remove(edge);
		tVer.inEdge.add(edge);
	}

	@Override
	public void addEdge(V from, V to) {
		addEdge(from, to, null);
	}

	@Override
	public void delVertex(V v1) {
		Vertex<V, E> ver = vertexs.remove(v1);
		if (ver == null)
			return;
		Set<Edge<V, E>> inEdge = ver.inEdge;
		Set<Edge<V, E>> outEdge = ver.outEdge;
		Iterator<Edge<V, E>> it = inEdge.iterator();
		while (it.hasNext()) {
			Edge<V, E> next = it.next();
			edges.remove(next);
			next.from.outEdge.remove(next);
			it.remove(); // remove 可以删除迭代器本身的遍历 的元素 不会影响遍历
		}

		it = outEdge.iterator();
		while (it.hasNext()) {
			Edge<V, E> next = it.next();
			edges.remove(next);
			next.to.inEdge.remove(next);
			it.remove();
		}
	}

	@Override
	public void delEdge(V from, V to) {
		Vertex<V, E> fVer = vertexs.get(from);
		Vertex<V, E> tVer = vertexs.get(to);
		if (fVer == null || tVer == null)
			return;
		Edge<V, E> edge = new Edge<V, E>(fVer, tVer);
		if (!edges.contains(edge))
			return;
		edges.remove(edge);
		fVer.outEdge.remove(edge);
		tVer.inEdge.remove(edge);
	}

	public void print() {
		vertexs.forEach((V v1, Vertex<V, E> ver) -> {
			System.out.println("点:" + v1 + "  inEdge" + ver.inEdge + "  outEdge" + ver.outEdge);
		});
		edges.forEach((Edge<V, E> e) -> {
			System.out.println("边  " + e.from + " " + e.to + "  权值 " + e.weight);
		});
	}

	public static class Vertex<V, E> {
		public V value;
		public Set<Edge<V, E>> inEdge = new HashSet();
		public Set<Edge<V, E>> outEdge = new HashSet();

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertex other = (Vertex) obj;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		public Vertex(V value) {
			super();
			this.value = value;
		}

	}

	public static class Edge<V, E> {
		public E weight;
		public Vertex<V, E> from;
		public Vertex<V, E> to;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((from == null) ? 0 : from.hashCode());
			result = prime * result + ((to == null) ? 0 : to.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (from == null) {
				if (other.from != null)
					return false;
			} else if (!from.equals(other.from))
				return false;
			if (to == null) {
				if (other.to != null)
					return false;
			} else if (!to.equals(other.to))
				return false;
			return true;
		}

		public Edge(Vertex<V, E> from, Vertex<V, E> to, E weight) {
			super();
			this.weight = weight;
			this.from = from;
			this.to = to;
		}

		public Edge(Vertex<V, E> from, Vertex<V, E> to) {
			super();
			this.from = from;
			this.to = to;
		}

	}

	@Override
	public void bfs(V v1) {
		Vertex<V, E> ver = vertexs.get(v1);
		if (ver == null)
			return;
		LinkedList<Vertex<V, E>> queue = new LinkedList<Vertex<V, E>>();
		Set<V> vSet = new HashSet<V>();
		queue.offer(ver);
		vSet.add(ver.value);
		while (!queue.isEmpty()) {
			ver = queue.poll();
			System.out.println(ver.value);
			for (Edge<V, E> e : ver.outEdge) {
				if (!vSet.contains(e.to.value)) {
					queue.add(e.to);
					vSet.add(e.to.value);
				}
			}
		}
	}

	@Override
	public void dfs(V v1) {
		Vertex<V, E> ver = vertexs.get(v1);
		if (ver == null)
			return;
		Stack<Vertex<V, E>> stack = new Stack<Vertex<V, E>>();
		Set<V> vSet = new HashSet<V>();
		stack.push(ver);
		vSet.add(ver.value);
		System.out.println(ver.value);
		while (!stack.isEmpty()) {
			ver = stack.pop();
			for (Edge<V, E> e : ver.outEdge) {
				if (!vSet.contains(e.to.value)) {
					stack.push(e.from);
					stack.push(e.to);
					vSet.add(e.to.value);
					System.out.println(e.to.value);
					break;
				}
			}
		}
	}

	public void dfsD(V v1, Set<V> vSet) {
		Vertex<V, E> ver = vertexs.get(v1);
		if (ver == null)
			return;
		System.out.println(v1);
		vSet.add(v1);
		for (Edge<V, E> e : ver.outEdge) {
			if (!vSet.contains(e.to.value))
				dfsD(e.to.value, vSet);
		}
	}

	@Override
	public List<V> toPogSort() {
		ArrayList<V> result = new ArrayList<V>();
		HashMap<V, Integer> inDage = new HashMap<V, Integer>();
		LinkedList<V> queue = new LinkedList<V>();
		for (Vertex<V, E> ver : vertexs.values()) {
			int indge = ver.inEdge.size();
			if (indge == 0)
				queue.offer(ver.value);
			inDage.put(ver.value, indge);
		}
		while (!queue.isEmpty()) {
			V p = queue.poll();
			vertexs.get(p).outEdge.forEach((Edge<V, E> e) -> {
				int indge = inDage.get(e.to.value) - 1;
				if (indge == 0) {
					queue.offer(e.to.value);
				}
				inDage.put(e.to.value, indge);
			});
			result.add(p);
		}
		return result;
	}

	public int compareWeight(E w1, E w2) {
		if (w1 == null || w2 == null)
			throw new IllegalArgumentException("weight ==null");
		if (comparator != null)
			return comparator.compare(w1, w2);
		return ((Comparable<E>) w1).compareTo(w2);
	}

	// 普利姆算法 最小生成树
	@Override
	public Set<EdgeInfo<V, E>> prim(V v1) {
		HashSet<Vertex<V, E>> verSet = new HashSet<Vertex<V, E>>();
		HashSet<EdgeInfo<V, E>> resSet = new HashSet<EdgeInfo<V, E>>();
		Vertex<V, E> ver = vertexs.get(v1);
		if (ver == null)
			return null;
		verSet.add(ver);
		while (resSet.size() < vertexSize() - 1) {
			Edge<V, E> minEdge = null;
			for (Vertex<V, E> v : verSet) {
				for (Edge<V, E> e : v.outEdge) {
					if (verSet.contains(e.to))
						continue;
					if (minEdge == null)
						minEdge = e;
					else {
						if (wightManager.compare(e.weight, minEdge.weight) > 0) {
							minEdge = e;
						}
					}
				}
			}
			if (minEdge == null)
				break;
			EdgeInfo<V, E> edgeInfo = new EdgeInfo<V, E>(minEdge.from.value, minEdge.to.value, minEdge.weight);
			resSet.add(edgeInfo);
			verSet.add(minEdge.to);
		}
		return resSet;
	}

	public Set<EdgeInfo<V, E>> primD(V v1) {
		Vertex<V, E> ver = vertexs.get(v1);
		if (ver == null)
			return null;
		HashSet<Vertex<V, E>> verSet = new HashSet<Vertex<V, E>>();
		PriorityQueue<Edge<V, E>> edgeHeap = new PriorityQueue<Edge<V, E>>((Edge<V, E> w1, Edge<V, E> w2) -> {
			return wightManager.compare(w1.weight, w2.weight);
		});
		HashSet<EdgeInfo<V, E>> resSet = new HashSet<EdgeInfo<V, E>>();
		verSet.add(ver);
		edgeHeap.addAll(ver.outEdge);
		while (!edgeHeap.isEmpty() && resSet.size() <= vertexSize() - 1) {
			Edge<V, E> minEdge = edgeHeap.remove();
			EdgeInfo<V, E> edgeInfo = new EdgeInfo<V, E>(minEdge.from.value, minEdge.to.value, minEdge.weight);
			resSet.add(edgeInfo);
			verSet.add(minEdge.to);
			minEdge.to.outEdge.forEach((Edge<V, E> e) -> {
				if (verSet.contains(e.to))
					return;
				edgeHeap.add(e);
			});
		}
		return resSet;
	}

	// 克鲁斯卡尔算法 最小生成树
	public Set<EdgeInfo<V, E>> kruskal(V v1) {
		PriorityQueue<Edge<V, E>> edgeHeap = new PriorityQueue<Edge<V, E>>((Edge<V, E> w1, Edge<V, E> w2) -> {
			return wightManager.compare(w1.weight, w2.weight);
		});
		HashSet<EdgeInfo<V, E>> resSet = new HashSet<EdgeInfo<V, E>>();
		UnionFindT<Vertex<V, E>> unionFind = new UnionFindT<Vertex<V, E>>(vertexs.values());
		edgeHeap.addAll(edges);
		while (!edgeHeap.isEmpty() && resSet.size() <= vertexSize() - 1) {
			Edge<V, E> minEdge = edgeHeap.remove();
			if (unionFind.isSame(minEdge.from, minEdge.to))
				continue;
			unionFind.union(minEdge.from, minEdge.to);
			EdgeInfo<V, E> edgeInfo = new EdgeInfo<V, E>(minEdge.from.value, minEdge.to.value, minEdge.weight);
			resSet.add(edgeInfo);
		}
		return resSet;
	}

	// 迪杰克斯拉算法 最短路径 不能有负权边
	public Map<V, PathInfo<V, E>> dijkstra(V begin, E maxE, E zeroE) {
		Map<V, PathInfo<V, E>> pathMap = new HashMap<V, PathInfo<V, E>>();
		// 初始化
		for (V end : vertexs.keySet()) {
			pathMap.put(end, new PathInfo<V, E>(begin, end, maxE));
		}
		Graph<V, E>.PathInfo<V, E> beginPath = pathMap.get(begin);
		beginPath.allWeight = zeroE;
		PathInfo<V, E> minPath = null;
		// 找到最小路径 并将对应的点其固定
		while ((minPath = getMinPath(pathMap)) != null) {
			minPath.fix = true;
			Vertex<V, E> minVer = vertexs.get(minPath.end);
			// 松弛最新固定的点的 相关边
			for (Edge<V, E> rEdge : minVer.outEdge) {
				if (pathMap.get(rEdge.to.value).fix)
					continue;
				relextion(rEdge, pathMap);
			}
		}
		return pathMap;
	}

	private PathInfo<V, E> getMinPath(Map<V, PathInfo<V, E>> pathMap) {
		PathInfo<V, E> minPath = null;
		for (V v : pathMap.keySet()) {
			Graph<V, E>.PathInfo<V, E> pathInfo = pathMap.get(v);
			if (pathInfo.fix)
				continue;
			if (minPath == null)
				minPath = pathInfo;
			else if (wightManager.compare(minPath.allWeight, pathInfo.allWeight) > 0) {
				minPath = pathInfo;
			}
		}
		return minPath == null ? null : minPath;
	}

	// 克鲁斯卡尔松弛操作
	public void relextion(Edge<V, E> rEdge, Map<V, PathInfo<V, E>> pathMap) {
		V fV = rEdge.from.value;
		Graph<V, E>.PathInfo<V, E> fp = pathMap.get(fV);
		V tV = rEdge.to.value;
		Graph<V, E>.PathInfo<V, E> tp = pathMap.get(tV);
		E newWeigth = wightManager.add(fp.allWeight, rEdge.weight);
		if (wightManager.compare(tp.allWeight, newWeigth) > 0) {
			tp.allWeight = newWeigth;
			tp.path = new ArrayList<EdgeInfo<V, E>>(fp.path);
			tp.path.add(new EdgeInfo<V, E>(rEdge.from.value, rEdge.to.value, rEdge.weight));
		}
	}

	// 贝尔曼福特 松弛操作
	public boolean relex(Edge<V, E> rEdge, Map<V, PathInfo<V, E>> pathMap) {
		V fV = rEdge.from.value;
		Graph<V, E>.PathInfo<V, E> fp = pathMap.get(fV);
		if (!fp.fix) {
			// 支持贝尔曼 福特算法
			return false;
		}
		V tV = rEdge.to.value;
		Graph<V, E>.PathInfo<V, E> tp = pathMap.get(tV);
		E newWeigth = wightManager.add(fp.allWeight, rEdge.weight);
		if (wightManager.compare(tp.allWeight, newWeigth) > 0) {
			tp.allWeight = newWeigth;
			tp.path = new ArrayList<EdgeInfo<V, E>>(fp.path);
			tp.path.add(new EdgeInfo<V, E>(rEdge.from.value, rEdge.to.value, rEdge.weight));
			tp.fix = true;
			return true;
		}
		return false;
	}

	// 贝尔曼-福特算法 最短路径算法 可以有负权边
	public Map<V, PathInfo<V, E>> bellmanFord(V begin, E maxE, E zeroE) {
		Map<V, PathInfo<V, E>> pathMap = new HashMap<V, PathInfo<V, E>>();
		// 初始化
		for (V end : vertexs.keySet()) {
			pathMap.put(end, new PathInfo<V, E>(begin, end, maxE));
		}
		Graph<V, E>.PathInfo<V, E> beginPath = pathMap.get(begin);
		beginPath.allWeight = zeroE;
		beginPath.fix = true;
		for (int i = 0; i < vertexSize(); i++) {
			for (Edge<V, E> rEdge : edges) {
				relex(rEdge, pathMap);
			}
		}
		// 如果再次进行松弛操作 那么就有负权环

		return pathMap;
	}

//Floyd  弗洛伊德算法 多源最短路径算法
	public HashMap<V, HashMap<V, PathInfo<V, E>>> floyd(E maxE, E zeroE) {
		HashMap<V, HashMap<V, PathInfo<V, E>>> pathMap = new HashMap<V, HashMap<V, PathInfo<V, E>>>();
		for (V v1 : vertexs.keySet()) {
			for (V v2 : vertexs.keySet()) {
				HashMap<V, PathInfo<V, E>> toMap = pathMap.get(v1);
				if (toMap == null) {
					HashMap<V, PathInfo<V, E>> map = new HashMap<V, PathInfo<V, E>>();
					if (v1 != v2)
						map.put(v2, new PathInfo<V, E>(v1, v2, maxE));
					else
						map.put(v2, new PathInfo<V, E>(v1, v2, zeroE));
					pathMap.put(v1, map);
				} else {
					if (v1 != v2)
						toMap.put(v2, new PathInfo<V, E>(v1, v2, maxE));
					else
						toMap.put(v2, new PathInfo<V, E>(v1, v2, zeroE));
				}
			}
		}
		for (Edge<V, E> edge : edges) {
			V fV = edge.from.value;
			V tV = edge.to.value;
			Graph<V, E>.PathInfo<V, E> pathInfo = pathMap.get(fV).get(tV);
			pathInfo.allWeight = edge.weight;
			pathInfo.path.add(new EdgeInfo<V, E>(fV, tV, edge.weight));
		}

		for (V k : vertexs.keySet()) {
			for (V i : vertexs.keySet()) {
				for (V j : vertexs.keySet()) {
					PathInfo<V, E> ijPath = pathMap.get(i).get(j);
					PathInfo<V, E> ikPath = pathMap.get(i).get(k);
					PathInfo<V, E> kjPath = pathMap.get(k).get(j);
					E w1 = wightManager.add(ikPath.allWeight, kjPath.allWeight);
					E w2 = ijPath.allWeight;
					if (wightManager.compare(w2, w1) > 0) {
						ijPath.allWeight = w1;
						ijPath.path.clear();
						ijPath.path.addAll(ikPath.path);
						ijPath.path.addAll(kjPath.path);
					}
				}
			}
		}
		return pathMap;
	}
}
