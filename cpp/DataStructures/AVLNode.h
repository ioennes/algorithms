#include <iostream>

template <typename T> class AVLNode {

private:
  T info;
  int height;
  AVLNode<T>* left;
  AVLNode<T>* right;

public:
  AVLNode(T info): info(info), height(1), left(nullptr), right(nullptr) {}
  void setInfo(T info) {
    this->info = info;
  }
  void setLeft(AVLNode<T>* new_node) {
    left = new_node;
  }
  void setRight(AVLNode<T>* new_node) {
    right = new_node;
  }
  void setHeight(int height) {
    this->height = height;
  }

  T getInfo() {
    return info;
  }
  AVLNode<T>* getLeft() {
    return left;
  }
  AVLNode<T>* getRight() {
    return right;
  }
  int getHeight() {
    return height;
  }
  T getLeftmost(AVLNode<T>* root) {
    if(getLeft() == nullptr) return root->getInfo();
    return getLeftmost(root->getLeft());
  }
};
