package com.ioannes.BinarySearchTree;

public class BTNode {

  int info;
  BTNode left, right;

  public BTNode(int i) {
    info = i;
    left = right = null;
  }

  public BTNode getLeft() {
    return left;
  }
  public BTNode getRight() {
    return right;
  }
  public int getInfo() {
    return info;
  }

  public void setLeft(BTNode l) {
    left = l;
  }
  public void setRight(BTNode r) {
    right = r;
  }
  public void setInfo(int i) {
    info = i;
  }

  public int getLeftmost() {
    if(getLeft() == null) return getInfo();
    return getLeft().getLeftmost();
  }
}
