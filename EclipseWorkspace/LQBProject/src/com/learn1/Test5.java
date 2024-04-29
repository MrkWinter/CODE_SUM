package com.learn1;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int len = scanner.nextInt();
		AreaUnionFind areaUnionFind1 = new AreaUnionFind(len);
		for (int i = 0; i < len * len; i++) {
			areaUnionFind1.quickUnionArea(i, scanner.nextInt());
		}
		AreaUnionFind areaUnionFind2 = new AreaUnionFind(len);
		for (int i = 0; i < len * len; i++) {
			areaUnionFind2.quickUnionArea(i, scanner.nextInt());
		}
		int result = 0;
		if (areaUnionFind1.isClose() || areaUnionFind2.isClose()) {
			result =  Math.max(areaUnionFind1.getMaxAreas(), areaUnionFind2.getMaxAreas());
		} else {
			int around1 = areaUnionFind1.getAroundMaxAreas();
			int around2 = areaUnionFind2.getAroundMaxAreas();
			areaUnionFind1.clearAroundSize();
			areaUnionFind2.clearAroundSize();
			int center1 = areaUnionFind1.getMaxAreas();
			int center2 = areaUnionFind2.getMaxAreas();
			result = Math.max(around1 + around2,Math.max(center1, center2));
		}
		System.out.println(result);
	}

	static class AreaUnionFind {
		// 基于size的 优化 方便拿数据
		int len;// 土地的长
		int[] area;
		int[] size;

		AreaUnionFind(int len) {
			this.area = new int[len * len];
			this.size = new int[len * len];
			for (int i = 0; i < area.length; i++) {
				area[i] = i;
			}
			this.len = len;
		}

		public void quickUnionArea(int index, int isArea) {
			if (isArea == 0)
				return;
			// 将左边和上边的土地并成一个集和
			size[index] = 1;
			int left = index - 1;
			int top = index - len;
			if ((left + 1) % len != 0 && size[left] > 0) {
				union(left, index);
			}
			if (top >= 0 && size[top] > 0) {
				union(top, index);
			}
		}

		public void union(int index1, int index2) {
			int p1 = find(index1);
			int p2 = find(index2);
			if (p1 == p2)
				return;
			if (size[p1] > size[p2]) {
				area[p2] = p1;
				size[p1] += size[p2];
				size[p2] = 1;
			} else if (size[p1] <= size[p2]) {
				area[p1] = p2;
				size[p2] += size[p1];
				size[p1] = 1;
			}

		}

		public int find(int index) {
			while (area[index] != index) {
				index = area[index];
			}
			return index;
		}

		public int getAreaSize(int index) {
			return size[find(index)];
		}

		public boolean isSame(int index1, int index2) {
			return find(index1) == find(index2);
		}

		public boolean isClose() {
			int len = size.length;
			for (int i = 0; i < len; i++) {
				if (size[i] != 0 || size[len - i - 1] != 0)
					return false;
				if (size[len * i] != 1 || size[(i + 1) * len-1] != 0)
					return false;
			}
			return true;
		}

		public int getAroundMaxAreas() {
			int max = 0;
			int temp = 0;
			for (int i = 0; i < len; i++) {
				if ((temp = getAreaSize(i)) > max) {
					max = temp;
				}
				if ((temp = getAreaSize(len - i - 1)) > max) {
					max = temp;
				}
				if ((temp = getAreaSize(len * i)) > max) {
					max = temp;
				}
				if ((temp = getAreaSize((i + 1) * len-1)) > max) {
					max = temp;
				}
			}
			return max;
		}

		public int getMaxAreas() {
			int max = 0;
			int temp = 0;
			for (int i = 0; i < area.length; i++) {
				if ((temp = getAreaSize(i)) > max) {
					max = temp;
				}
			}
			return max;
		}
		public void clearAroundSize() {
			for (int i = 0; i < len; i++) {
				size[find(i)] = 1;
				size[find(len - i - 1)] = 1;
				size[find(len * i)] = 1;
				size[find((i + 1) * len-1)] = 1;
			}
		}
	}
}
