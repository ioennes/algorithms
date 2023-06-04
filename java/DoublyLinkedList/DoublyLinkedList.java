package DoublyLinkedList;

public class DoublyLinkedList {
  
  Node head;
  int size;

  public DoublyLinkedList() {
    head = null;
    size = 0;
  }

  public void insert(int idx, int value) {
    if(idx > size) return;
    Node temp = head;
    Node insert = new Node(value);
    int count = 0;
    
    if(idx == 0) {
      insert.setNext(head);
      if(head != null) head.setPrev(insert);
      head = insert;
      ++size;
      return;
    }
    while(count < idx - 1) {
      count++;
      temp = temp.getNext();
    }
    insert.setNext(temp.getNext());
    if(temp.getNext() != null) temp.getNext().setPrev(insert);
    insert.setPrev(temp);
    temp.setNext(insert);
    size++;
  }

  public void delete(int idx) {
    if(idx > size) return;
    if(idx == 0) {
      head.getNext().setPrev(null);
      head = head.getNext();
      --size;
      return;
    }
    Node temp = head;
    int count = 0;
    while(count < idx - 1) {
      count++;
      temp = temp.getNext();
    }
    if(temp.getNext() != null) {
      if(temp.getNext().getNext() != null) {
        temp.getNext().getNext().setPrev(temp);
        temp.setNext(temp.getNext().getNext());
      } else {
        temp.setNext(null); // If there's no next next node, set next to null
      }
      size--;
    }
  }
}
