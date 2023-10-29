package Stacks;

public class aStack {
  
  int[] stack;
  int top;

  public aStack() {
    stack = new int[10];
    top = 0;
  }

  public void ensureCapacity() {
    int[] new_stack = new int[stack.length * 2];
      System.arraycopy(stack, 0, new_stack, 0, stack.length);
    stack = new_stack;
  }

  public void push(int i) {
    stack[top++] = i;
    if(top == stack.length) ensureCapacity();
  }

  public int pop() {
    int temp = stack[top];
    if(top == 0) {
      stack[top] = 0;
      return stack[top];
    }
    stack[--top] = 0;
    return temp;
  }

  public int peek() {
    return stack[top];
  }

  public boolean empty() {
    return (top == 0 && stack[top] == 0);
  }
}
