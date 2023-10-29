package UnionFind;

public class QuickFind {

	int[] id;

	public QuickFind(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public int find(int p) {
		return id[p];
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public void union(int p, int q) {
		if (!connected(p, q)) {
			int id_p = find(p);
			int id_q = find(q);
			for (int i = 0; i < id.length; i++) {
				if (id[i] == id_p) {
					id[i] = id_q;
				}
			}
		}
	}
}
