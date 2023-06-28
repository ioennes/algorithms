package Queues;
import Stacks.lStack;

public class sQueue {

  lStack primary;
  lStack secondary;

  public sQueue() {
    primary = new lStack();
    secondary = new lStack();
  }

  public void enqueue(int i) {
    while(!primary.empty()) {
      secondary.push(primary.pop());
    }
    primary.push(i);
    while(!secondary.empty()) {
      primary.push(secondary.pop());
    }
  }

  public int dequeue() {
    return primary.empty() ? -1 : primary.pop();
  }
}
