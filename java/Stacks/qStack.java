package Stacks;
import Queues.lQueue;

public class qStack {

  lQueue primary, secondary;

  public qStack() {
    primary = new lQueue();
    secondary = new lQueue();
  }

  public void push(int i) {
    while(!primary.empty()) {
      secondary.enqueue(primary.dequeue());
    }
    primary.enqueue(i);
    while(!secondary.empty()) {
      primary.enqueue(secondary.dequeue());
    }
  }

  public int pop() {
    return primary.empty() ? -1 : primary.dequeue();
  }
}
