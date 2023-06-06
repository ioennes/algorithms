#include <iostream>
#include "DNode.h"

template<typename T> class DoublyLinkedList {
private:
  DNode<T>* head;

public:
  DoublyLinkedList(): head(nullptr) {};

  ~DoublyLinkedList() {
    DNode<T>* temp = head;
    while(temp != nullptr) {
      DNode<T>* next = temp->getNext();
      delete temp;
      temp = next;
    }
  }

  void add(T i) {
    DNode<T>* temp = new DNode<T>(i);
    temp->setNext(head);
    if(head != nullptr) head->setPrev(temp);
    head = temp;
  }

  void remove(T i) {
    if(head == nullptr) return; 

    DNode<T>* temp = head;

    if (head->getInfo() == i) {
      head = temp->getNext();
      if (head != nullptr) head->setPrev(nullptr);
      delete temp;
      return;
    }

    while (temp != nullptr && temp->getInfo() != i) {
      temp = temp->getNext();
    }

    if(temp == nullptr) return;

    if(temp->getNext() != nullptr) {
      temp->getNext()->setPrev(temp->getPrev());
    }
    if(temp->getPrev() != nullptr) {
      temp->getPrev()->setNext(temp->getNext());
    }

    delete temp;
  }

  void print() {
    DNode<T>* temp = head;
    while(temp != nullptr) {
      std::cout << temp->getInfo() << " <-> ";
      temp = temp->getNext();
    }
    std::cout << "null\n";
  }
};
