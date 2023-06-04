#include <iostream>

template<typename T> class Node {
private:
  T info;
  Node* next;

public:
  Node(T info): info(info), next(nullptr) {};

  Node* getNext() {
    return next;
  }
  T getInfo() {
    return info;
  }

  void setNext(Node* next_node) {
    next = next_node;
  }
};

