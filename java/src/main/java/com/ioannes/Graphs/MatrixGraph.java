package com.ioannes.Graphs;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MatrixGraph {

	int[][] matrix;

	public MatrixGraph(int n) {
		matrix = new int[n][n];
	}

	public void printMatrixGraph(int[][] graph) {
		int rows = graph.length;
		int columns = graph[0].length;

		System.out.print("  ");
		for (int i = 0; i < columns; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 0; i < rows; i++) {
			System.out.print(i + " ");

			for (int j = 0; j < columns; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void addEdge(int u, int v) {
		if(u >= matrix.length || v >= matrix.length || v < 0 || u < 0)
			return;
		matrix[u][v] = matrix[v][u] = 1;
	}

	public void removeEdge(int u, int v) {
		if(u >= matrix.length || v >= matrix.length || v < 0 || u < 0)
			return;
		matrix[u][v] = matrix[v][u] = 0;
	}

	public boolean edge(int u, int v) {
		if(u >= matrix.length || v >= matrix.length || v < 0 || u < 0)
			return false;
		return matrix[u][v] == 1;
	}

	public void rdfs(int u, boolean[] visited) {
		if(u >= matrix.length || u < 0)
			return;
		visited[u] = true;
		System.out.print(u + " -> ");
		for(int i = 0; i < matrix.length; i++) {
			if(!visited[i] && matrix[u][i] == 1) rdfs(i, visited);
		}
	}

	public void sdfs(int u) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[matrix.length];
		stack.push(u);

		while(!stack.empty()) {

			int v = stack.pop();
			visited[v] = true;
			System.out.print(v + " -> ");

			for(int i = 0; i < matrix.length; i++) {
				if(!visited[i] && matrix[v][i] == 1)
					stack.push(i);
			}
		}
	}

	public void bfs(int u) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[matrix.length];

		queue.add(u);

		while(!queue.isEmpty()) {

			int v = queue.remove();
			visited[v] = true;
			System.out.print(v + " -> ");

			for(int i = 0; i < matrix.length; i++) {
				if(!visited[i] && matrix[v][i] == 1) 
					queue.add(i);
			}
		}
	}

	public boolean hasPath(int u, int v, boolean[] visited) {
		if(u >= matrix.length || v >= matrix.length || v < 0 || u < 0)
			if(edge(u, v)) return true;
		visited[u] = true;
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[u][i] == 1 && !visited[i])
				if(hasPath(i, v, visited)) return true;
		}
		return false;
	}

	public boolean isConnected(int u) {
		if(u >= matrix.length) return false;
		boolean[] visited = isConnectedHelper(u, new boolean[matrix.length]);
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == false) return false;
		}
		return true;
	}

	private boolean[] isConnectedHelper(int u, boolean[] visited) {
		visited[u] = true;
		for(int i = 0; i < matrix.length; i++) {
			if(!visited[i] && matrix[u][i] == 1)
				isConnectedHelper(i, visited);
		}
		return visited;
	}
}

