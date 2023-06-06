#include <iostream>

template<typename T> class DNode {
private:
  DNode<T>* prev, next;
  T info;

public:
  DNode(T info): prev(nullptr), next(nullptr), info(info) {};

  DNode<T>* getPrev() const {
    return prev;
  }
  DNode<T>* getNext() const {
    return next;
  }
  T getInfo() const {
    return info;
  }

  void setPrev(DNode<T>* prev_node) {
    prev = prev_node;
  }
  void setNext(DNode<T>* next_node) {
    next = next_node;
  }
  void setInfo(T i) {
    info = i;
  }
};
