package UnionFind;

public class QuickUnion {

	int[] roots;

	public QuickUnion(int n) {
		roots = new int[n];
		for (int i = 0; i < n; i++) {
			roots[i] = i;
		}
	}

	public int find(int p) {
		while (roots[p] != p) 
			p = roots[p];
		return p;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int root_p = find(p);
		int root_q = find(q);
		if (root_p != root_q) {
			roots[root_p] = root_q;
		}
	}
}
