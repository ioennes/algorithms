#include <iostream>

template<typename T> class Node {
private:
  T info;
  Node<T>* next;

public:
  Node(T info): info(info), next(nullptr) {};

  Node<T>* getNext() const {
    return next;
  }
  T getInfo() const {
    return info;
  }

  void setNext(Node<T>* next_node) {
    next = next_node;
  }
  void setInfo(T i) {
    info = i;
  }
};

