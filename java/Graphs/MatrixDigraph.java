package Graphs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MatrixDigraph {

  int[][] matrix;

  public MatrixDigraph(int n) {
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
    if(u >= matrix.length || v >= matrix.length || u < 0 || v < 0)
      return;
    matrix[u][v] = 1;
  }

  public void removeEdge(int u, int v) {
    if(u >= matrix.length || v >= matrix.length || u < 0 || v < 0)
      return;
    matrix[u][v] = 0;
  }

  public boolean edge(int u, int v) {
    if(u >= matrix.length || v >= matrix.length || u < 0 || v < 0)
      return false;
    return matrix[u][v] == 1;
  }

  public void rdfs(int u, boolean[] visited) {
    visited[u] = true;
    System.out.print(u + " -> ");

    for(int i = 0; i < matrix.length; i++) {
      if(!visited[i] && matrix[u][i] == 1)
        rdfs(i, visited);
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

  public boolean isCycle(int u) {

    Stack<Integer> stack = new Stack<Integer>();
    boolean[] visited = new boolean[matrix.length];
    int flag = 0;

    stack.push(u);

    while(!stack.empty()) {
      int v = stack.pop();
      
      visited[v] = true;

      if(flag == 0) {
        visited[u] = false;
        ++flag;
      }

      if(visited[u]) return true;

      for(int i = 0; i < matrix.length; i++) {
        if(!visited[i] && matrix[v][i] == 1)
          stack.push(i);
      }
    }
    return false;
  }
  
  public static void main(String[] argx) {
    MatrixDigraph d = new MatrixDigraph(5);
    d.addEdge(0, 1);
    d.addEdge(1, 2);
    d.addEdge(2, 0);
    System.out.println(d.isCycle(0));
  }
}
