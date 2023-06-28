package BinarySearchTree;

public class ArrayBST {

  int[] tree;

  public ArrayBST() {
    tree = new int[100];
  }

  public void add(int root, int i) {
    if(root >= tree.length) return;
    if(tree[root] == 0) tree[root] = i;
    else if(i > tree[root]) add((root * 2) + 1, i);
    else if(i < tree[root]) add((root * 2), i);
  }

  public void delete(int root, int i) {
    if(root >= tree.length || tree[root] == 0) return;
    else if(tree[root] == i) {
      tree[root] = 0;
      return;
    }
    else if(i > tree[root]) delete((root * 2) + 1, i);
    else if(i < tree[root]) delete((root * 2), i);
  }
}
