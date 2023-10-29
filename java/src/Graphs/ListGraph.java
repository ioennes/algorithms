package Graphs;
import LinkedLists.*;
import Stacks.lStack;
import Queues.lQueue;

public class ListGraph {

  LinkedList[] graph;

  public ListGraph(int n) {
    graph = new LinkedList[n];
    for(int i = 0; i < n; i++) {
      graph[i] = new LinkedList();
      graph[i].head = new Node(i);
    }
  }

  public void addEdge(int u, int v) {
    int l = graph.length;
    if(u < 0 || v < 0 || u >= l || v >= l)
      return;
    Node temp = graph[u].head;
    while(temp != null) {
      if(temp.getInfo() == v) return;
      temp = temp.getNext();
    }
    graph[u].add(v);
  }

  public void deleteEdge(int u, int v) {
    int l = graph.length;
    if(u < 0 || v < 0 || u >= l || v >= l)
      return;

    graph[u].remove(v);
  }

  public boolean edge(int u, int v) {
    Node temp = graph[u].head;
    while(temp != null) {
      if(temp.getInfo() == v) return true;
      temp = temp.getNext();
    }
    return false;
  }

  public void rdfs(int u, boolean[] visited) {
    visited[u] = true;
    System.out.println(u + " -> ");
    Node temp = graph[u].head.getNext();
    while(temp != null) {
      if(!visited[temp.getInfo()]) rdfs(temp.getInfo(), visited);
      temp = temp.getNext();
    }
  }

  public void sdfs(int u) {
    lStack stack = new lStack();
    boolean[] visited = new boolean[graph.length];
    stack.push(u);
    while(!stack.empty()) {
      int v = stack.pop();
      visited[v] = true;

      Node temp = graph[v].head.getNext();
      while(temp != null) {
        if(!visited[temp.getInfo()]) stack.push(temp.getInfo());
        temp = temp.getNext();
      }
    }
  }

  public void bfs(int u) {
    lQueue queue = new lQueue();
    boolean[] visited = new boolean[graph.length];

    queue.enqueue(u);

    while(!queue.empty()) {
      int v = queue.dequeue();
      visited[v] = true;
      Node temp = graph[v].head.getNext();
      while(temp != null) {
        if(!visited[temp.getInfo()]) queue.enqueue(temp.getInfo());
        temp = temp.getNext();
      }
    }
  }
}
