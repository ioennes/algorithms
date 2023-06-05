#include <iostream>
#include "Node.h"

template<typename T> class LinkedList {
private:
  Node<T>* head;

public:
  LinkedList(): head(nullptr) {};

  ~LinkedList() {
    Node<T>* temp = head;
    while(temp != nullptr) {
      Node<T>* next = temp->getNext();
      delete temp;
      temp = next;
    }
  }
  
  void add(T info) {
    Node<T>* next = new Node<T>(info);
    next->setNext(head);
    head = next;
  }
  
  bool remove(T info) {
    if(head == nullptr) return false;
    if(head->getInfo() == info) {
      Node<T>* temp = head;
      head = head->getNext();
      delete temp;
      return true;
    }
    Node<T>* temp = head;
    while(temp->getNext() != nullptr && temp->getNext()->getInfo() != info) {
      temp = temp->getNext();
    }
    if(temp != nullptr) {
      Node<T>* temp2 = temp->getNext();
      temp->setNext(temp->getNext()->getNext());
      delete temp2;
      return true;
    }
    return false;
  }

  void print() {
    if(head == nullptr) return;
    Node<T>* temp = head;
    while (temp != nullptr) {
      std::cout << temp->getInfo() << " -> ";
      temp = temp->getNext();
    }
    std::cout << "null\n";
  }
};
