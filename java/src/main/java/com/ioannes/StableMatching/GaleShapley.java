package com.ioannes.StableMatching;
import java.util.Arrays;

public class GaleShapley {

    private int N;
    private int[][] men_preference;
    private int[][] women_preference;
    private int[] women_partner;
    private int[] men_queue;
    private int[][] women_ranking;

	public GaleShapley(int[][] men_preference, int[][] women_preference) {
		this.N = men_preference.length;
		this.men_preference = men_preference;
		this.women_preference = women_preference;
		this.women_partner = new int[N];
		this.men_queue = new int[N];
		this.women_ranking = new int[N][N];

		Arrays.fill(women_partner, -1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) 
				women_ranking[i][women_preference[i][j]] = j;
		}
	}

	public void match() {
		int[] free_men = new int[N];
		int size = N;
		
		for (int i = 0; i < N; i++)
			free_men[i] = i;

		while (size > 0) {
			int man = free_men[--size];

			for (int i = men_queue[man]; i < N; i++, men_queue[man]++) {
				int woman = men_preference[man][i];
				if(women_partner[woman] == -1) {
					women_partner[woman] = man;
					break;
				}
				else {
					int current_parter = women_partner[woman];
					if (women_ranking[woman][man] < women_ranking[woman][current_parter]) {
						women_partner[woman] = man;
						free_men[size++] = current_parter;
						break;
					}
				}
			}
		}
	}

	public void printMatches() {
        System.out.println("Man\tWoman");
        for (int i = 0; i < N; i++) {
            System.out.println(women_partner[i] + "\t" + i);
        }
    }

    public static void main(String[] args) {
        int[][] menPreference = {
            {3, 1, 2, 0, 4},
            {4, 2, 1, 0, 3},
            {1, 4, 0, 3, 2},
            {4, 1, 3, 2, 0},
            {3, 0, 1, 2, 4}
        };

        int[][] womenPreference = {
			{3, 1, 4, 2, 0},
			{1, 0, 3, 2, 4},
			{0, 2, 4, 3, 1},
			{3, 0, 2, 1, 4},
			{1, 4, 0, 2, 3}
        };

        GaleShapley galeShapley = new GaleShapley(menPreference, womenPreference);
        galeShapley.match();
        galeShapley.printMatches();
    }
}
