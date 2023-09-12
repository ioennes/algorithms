package com.ioannes.LinkedLists;

public class Node {
  
  Node next;    // Recursive Definition
  int info;

  public Node(int i) {
    info = i;
    next = null;
  }

  // Accessors
  
  public Node getNext() {
    return next;
  }
  public int getInfo() {
    return info;
  }

  // Mutators

  public void setNext(Node n) {
    next = n;
  }
  public void setNext(int n) {
    next = new Node(n);
  }
  public void setInfo(int i) {
    info = i;
  }
}
