package Stacks;
import LinkedList.Node;

public class lStack {

  Node top;

  public lStack() {
    top = null;
  }

  public void push(int i) {
    Node n = new Node(i);
    if(top == null) top = n;
    else {
      n.setNext(top);
      top = n;
    }
  }

  public int pop() {
    if(top == null) return -1;
    int temp = top.getInfo();
    top = top.getNext();
    return temp;
  }

  public int peek() {
    return top == null ? -1 : top.getInfo();
  }

  public boolean empty() {
    return (top == null);
  }
}
