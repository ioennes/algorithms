package StableMatching;

public class GaleShapley {

	int[][] men_preference;
	int[][] women_preference;

	public GaleShapley() {
		men_preference = new int[][] {
			{1, 2, 3, 0},
				{0, 2, 3, 1},
				{1, 0, 3, 2},
				{0, 3, 1, 2}
		};
		women_preference = new int[][] {
			{3, 1, 0, 2},
				{0, 1, 3, 2},
				{0, 3, 1, 2},
				{0, 3, 1, 2}
		};
	}

	int[][] createRankings(int[][] women_preference) {

		int[][] ranking = new int[women_preference.length][women_preference.length];

		for (int i = 0; i < women_preference.length; i++) {
			for (int j = 0; j < women_preference.length; j++) {
				ranking[i][women_preference[i][j]] = j;
			}
		}

		return ranking;
	}

	void match(int[][] mp, int[][] wp, int[][] ranking) {
		int n = wp.length;
		int[] free = new int[n];
		int[] match = new int[n];
		int[] queue = new int[n];
		for (int i = 0; i < n; i++) {
			match[i] = -1;
			free[i] = 1;
		}
		int q = 0;
		boolean has_free = true; 
		while (has_free) {
			has_free = false;
			for (int i = 0; i < n; i++) {
				if (free[i] == 1) {
					q = i;
					has_free = true; 
					break;
				}
			}

			if (!has_free) break;

			// where match[mp[q][queue[q]]] is the first available woman in m's preference list

			if (match[mp[q][queue[q]]] == -1) {
				match[mp[q][queue[q]]] = q;
				free[q] = 0;
			}
			else {
				if (ranking[mp[q][queue[q]]][match[mp[q][queue[q]]]] > ranking[mp[q][queue[q]]][q]) {
					free[match[mp[q][queue[q]]]] = 1;
					free[q] = 0;
					match[mp[q][queue[q]]] = q;
				}
				else {
					queue[q]++;
				}
			}
		}

		for (int i = 0; i < n; i++)
			System.out.println(i + ": " + match[i]);
	}

	public static void main(String[] args) {
		GaleShapley g = new GaleShapley();
		g.match(g.men_preference, g.women_preference, g.createRankings(g.women_preference));
	}
}
