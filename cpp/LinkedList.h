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
      temp = nullptr;
      temp = next;
    }
  }
  
  void add(int info) {
    Node<T>* next = new Node<T>(info);
    if(head == nullptr) {
      head = next;
      return;
    }
    Node<T>* temp = head;
    while(temp->getNext() != nullptr) {
      temp = temp->getNext();
    }
    temp->setNext(next);
  }
  
  bool remove(int info) {
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
