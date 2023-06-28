#include <iostream>

template <typename T> class BTNode {

private:
  T info;
  BTNode<T>* left;
  BTNode<T>* right;

public:
  BTNode(T info): info(info), left(nullptr), right(nullptr) {}
  void setInfo(T info) {
    this->info = info;
  }
  void setLeft(BTNode<T>* new_node) {
    left = new_node;
  }
  void setRight(BTNode<T>* new_node) {
    right = new_node;
  }

  T getInfo() {
    return info;
  }
  BTNode<T>* getLeft() {
    return left;
  }
  BTNode<T>* getRight() {
    return right;
  }
};
