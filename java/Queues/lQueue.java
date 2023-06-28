package Queues;
import LinkedList.Node;
import BinarySearchTree.BTNode;

/*
 *  Queue implemented with Linked Lists. Could keep a tracker
 *  of head and tail for better efficiency.
 */

public class lQueue {

  Node head;

  public lQueue() {
    head = null;
  }

  public void enqueue(int i) {
    Node n = new Node(i);
    if(head == null) head = n;
    Node temp = head;
    while(temp.getNext() != null) {
      temp = temp.getNext();
    }
    temp.setNext(n);
  }

  public int dequeue() {
    if(head == null) return -1;
    Node temp = head;
    head = head.getNext();
    return temp.getInfo();
  }

  public int peek() {
    if(head == null) return -1;
    return head.getInfo();
  }

  public boolean empty() {
    return (head == null);
  }
}
