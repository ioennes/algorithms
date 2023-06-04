#include <iostream>
#include "Node.h"

template<typename T> class Queue {
private:
  Node<T>* head;
  Node<T>* tail;

public:
  Queue(): head(nullptr), tail(nullptr) {};

  ~Queue() {
    Node<T>* temp = head;
    while(temp != nullptr) {
      Node<T>* next = temp->getNext();
      delete temp;
      temp = next;
    }
  }

  void enqueue(T info) {
    Node<T>* temp = new Node<T>(info);
    if(tail == nullptr) {
      tail = head = temp;
      return;
    }
    tail->setNext(temp);
    tail = tail->getNext();
  }

  T dequeue() {
    if(empty()) throw std::out_of_range("Queue is empty");
    Node<T>* temp = head;
    T info = temp->getInfo();
    head = head->getNext();
    delete temp;
    if(head == nullptr) tail = nullptr;
    return info;
  }

  T peek() {
    if(empty()) throw std::out_of_range("Queue is empty");
    return head->getInfo();
  }

  bool empty() {
    return head == nullptr;
  }
};
