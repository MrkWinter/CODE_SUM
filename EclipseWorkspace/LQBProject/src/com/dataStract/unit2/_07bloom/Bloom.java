package com.dataStract.unit2._07bloom;

public class Bloom<V> {
	private int bitSize;
	private long[] bits;
	private int hashSize;

	public Bloom(int n, double p) {
		if (n <= 0 || p <= 0) {
			throw new IllegalArgumentException("error");
		}
		double ln2 = Math.log(2);
		// 二进制个数
		bitSize = (int) (-(n * Math.log(p)) / (ln2 * ln2));
		// 哈希函数个数
		hashSize = (int) (bitSize * ln2 / n);
		bits = new long[(bitSize + Long.SIZE - 1) / Long.SIZE];
	}

	public boolean put(V v) {
		if (v == null)
			return false;
		int hash1 = v.hashCode();
		int hash2 = hash1 >>> 16;
		boolean flag = false;
		for (int i = 0; i < hashSize; i++) {
			int combinedHash = hash1 + (i * hash2);
			if (combinedHash < 0) {
				combinedHash = ~combinedHash;
			}
			if(setBit(combinedHash % bitSize)) {
				flag = true;
			}
		}
		return flag;
	}

	private boolean setBit(int i) {
		int b = i % Long.SIZE;
		int index = i / Long.SIZE;
		long temp = bits[index];
		bits[index] |=1L<<b;
		return temp != bits[index];
	}

	public boolean contains(V v) {
		if (v == null)
			return false;
		int hash1 = v.hashCode();
		int hash2 = hash1 >>> 16;
		for (int i = 0; i < hashSize; i++) {
			int combinedHash = hash1 + (i * hash2);
			if (combinedHash < 0) {
				combinedHash = ~combinedHash;
			}
			if (!getBit(combinedHash % bitSize))
				return false;
		}
		return true;
	}

	private boolean getBit(int i) {
		int b = i % Long.SIZE;
		int index = i / Long.SIZE;
		return (bits[index] & (1L<<b)) == 0;
	}
}
