#include <iostream>
#include "Node.h"

template<typename T> class Stack {
private:
  Node<T>* top;

public:
  Stack(): top(nullptr) {};

  ~Stack() {
    Node<T>* temp = top;
    while(temp != nullptr) {
      Node<T>* next = temp->getNext();
      temp = nullptr;
      temp = next;
    }
  }

  void push(T info) {
    Node<T>* temp = new Node<T>(info);
    temp->setNext(top);
    top = temp;
  }

  T pop() {
    if(empty()) throw std::out_of_range("Stack is empty");
    Node<T>* temp = top;
    top = top->getInfo();
    T info = temp->getNext();
    delete temp;
    return info;
  }

  T peek() {
    return top->getInfo();
  }

  bool empty() {
    return top == nullptr;
  }
};
