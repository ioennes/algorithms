package Queues;

public class aQueue {

  Object[] queue;
  int head;
  int tail;

  public aQueue() {
    queue = new Object[10];
    head = tail = 0;
  }

  public void ensureCapacity() {
    Object[] new_queue = new Object[queue.length * 2];
    for(int i = 0; i < queue.length; i++) {
      new_queue[i] = queue[(head + i) % queue.length];
    }
    head = 0;
    tail = queue.length;
    queue = new_queue;
  }

  public void enqueue(Object i) {
    if((tail + 1) % queue.length == head)
      ensureCapacity();
    queue[tail] = i;
    tail = (tail + 1) % queue.length;
  }

  public Object dequeue() {
    Object temp = queue[head];
    queue[head] = null;
    head = (head + 1) % queue.length;
    return temp;
  }

  public boolean empty() {
    return (head == tail);
  }
}

