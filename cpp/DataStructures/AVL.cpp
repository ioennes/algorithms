#include <algorithm>
#include <iostream>
#include "AVLNode.h"

template <typename T> class AVL {

private:
  AVLNode<T>* root;

  int height(AVLNode<T>* root) {
    return root != nullptr ? root->getHeight() : 0;
  }

  int balance(AVLNode<T>* root) {
    return root != nullptr ? height(root->getLeft()) - height(root->getRight()) : 0;
  }

  void updateHeight(AVLNode<T>* root) {
    int maxHeight = (std::max(height(root->getLeft()), height(root->getRight())));
    root->setHeight(maxHeight + 1);
  }

  AVLNode<T>* rightRotate(AVLNode<T>* root) {
    AVLNode<T>* left = root->getLeft();
    root->setLeft(left->getRight());
    left->setRight(root);
    updateHeight(root);
    updateHeight(left);
    return left;
  }

  AVLNode<T>* leftRotate(AVLNode<T>* root) {
    AVLNode<T>* right = root->getRight();
    root->setRight(right->getLeft());
    right->setLeft(root);
    updateHeight(root);
    updateHeight(right);
    return right;
  }

  AVLNode<T>* addHelper(AVLNode<T>* root, T info) {
    if(root == nullptr) return new AVLNode<T>(info);
    if(info <= root->getInfo()) root->setLeft(addHelper(root->getLeft(), info));
    else root->setRight(addHelper(root->getRight(), info));
    updateHeight(root);
    return applyRotation(root);
  }

  AVLNode<T>* deleteHelper(AVLNode<T>* root, T info) {
    if(root == nullptr) return nullptr;
    if(root->getInfo() == info) {
      if(root->getLeft() == nullptr && root->getRight() == nullptr) return nullptr;
      if(root->getLeft() == nullptr && root->getRight() != nullptr) return root->getRight();
      if(root->getLeft() != nullptr && root->getRight() == nullptr) return root->getLeft();
      if(root->getLeft() != nullptr && root->getRight() != nullptr) {
        root->setInfo(root->getRight()->getLeftmost());
        root->setRight(deleteHelper(root->getRight(), root->getRight()->getLeftmost()));
      }
    }
    else if(info < root->getInfo()) root->setLeft(deleteHelper(root->getLeft(), info));
    else root->setRight(deleteHelper(root->getRight(), info));
    updateHeight(root);
    return applyRotation(root);
  }

  AVLNode<T>* applyRotation(AVLNode<T>* root) {
    int balance = balance(root);
    if(balance > 1) {
      if(balance(root->getLeft()) < 0) {
        root->setLeft(leftRotate(root->getLeft()));
      }
      return rightRotate(root);
    }
    if(balance < -1) {
      if(this->balance(root->getRight()) > 0) {
        root->setRight(rightRotate(root->getRight()));
      }
      return leftRotate(root);
    }
    return root;
  }

public:

  AVL(): root(nullptr) {}

  void add(T info) {
    root = addHelper(root, info);
  }

  void deleteNode(T info) {
    root = deleteHelper(root, info);
  }

};
