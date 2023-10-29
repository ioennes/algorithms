package UnionFind;

public class WeightedQuickUnion {

	int[] roots;
	int[] size;

	public WeightedQuickUnion(int n) {
		roots = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			roots[i] = i;
			size[i] = 1;
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
			if (size[root_p] < size[root_q]) {
				roots[root_p] = root_q;
				size[root_q] = size[root_p] + size[root_q];
			}
			else {
				roots[root_q] = root_p;
				size[root_q] = size[root_p] + size[root_q];
			}
		}
	}
}
