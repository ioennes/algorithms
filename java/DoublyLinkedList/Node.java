package DoublyLinkedList;

public class Node {

  int info;
  Node prev, next;

  public Node(int i) {
    info = i;
    prev = next = null;
  }

  public int getInfo() {
    return info;
  }
  public Node getNext() {
    return next;
  }
  public Node getPrev() {
    return prev;
  }

  public void setInfo(int i) {
    info = i;
  }
  public void setPrev(Node p) {
    prev = p;
  }
  public void setNext(Node n) {
    next = n;
  }
}
