package BinarySearchTree;
import Queues.*;

public class BinarySearchTree {

	BTNode root;
	int size;

	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	public void add(int i) {
		size++;
		root = addHelper(root, i);
	}

	private BTNode addHelper(BTNode root, int i) {
		if(root == null) return new BTNode(i);
		else {
			if(i <= root.getInfo()) root.setLeft(addHelper(root.getLeft(), i));
			else if(i > root.getInfo()) root.setRight(addHelper(root.getRight(), i));
			return root;
		}
	}

	public BTNode mirrorTree(BTNode root) {
		if(root == null) return root;

		BTNode left = root.getLeft();
		BTNode right = root.getRight();

		root.setLeft(mirrorTree(right));
		root.setRight(mirrorTree(left));
		return root;
	}

	public void delete(int i) {
		root = deleteHelper(root, i);
	}

	private BTNode deleteHelper(BTNode root, int i) {
		if(root == null) return null;
		if(root.info == i) {
			if(root.getLeft() == null && root.getRight() == null) return null;
			if(root.getLeft() != null && root.getRight() == null) return root.getLeft();
			if(root.getLeft() == null && root.getRight() != null) return root.getRight();
			if(root.getLeft() != null && root.getRight() != null) {
				root.setInfo(root.getRight().getLeftmost());
				root.setRight(deleteHelper(root.getRight(), root.getRight().getLeftmost()));
			}
		}
		if(i < root.getInfo()) root.setLeft(deleteHelper(root.getLeft(), i));
		else root.setRight(deleteHelper(root.getRight(), i));
		return root;
	}

	private void printAncestorsHelper(BTNode root, int child_value) {
		if(root == null || root.getInfo() == child_value) return;
		System.out.print(root.getInfo() + " -> ");
		if(child_value < root.getInfo()) printAncestorsHelper(root.getLeft(), child_value);
		else printAncestorsHelper(root.getRight(), child_value);
	}

	public void printAncestors(int child_value) {
		printAncestorsHelper(root, child_value);
	}

	private int commonAncestorHelper(BTNode root, int i, int j) {
		if(root == null) return -1;
		if(i > root.getInfo() && j > root.getInfo()) return commonAncestorHelper(root.getRight(), i, j);
		if(i < root.getInfo() && j < root.getInfo()) return commonAncestorHelper(root.getLeft(), i, j);
		return root.getInfo();
	}

	public int commonAncestor(int i, int j) {
		return commonAncestorHelper(root, i, j);
	}

	public void printDecreasing() {
		decreasingOrderHelper(root);
	}

	public int getHeight(BTNode root) {
		if(root == null) return -1;
		int l = getHeight(root.getLeft());
		int r = getHeight(root.getRight());
		return l > r ? l + 1 : r + 1;
	}

	public int getDepth(BTNode root, int i, int depth) {
		if(root == null) return -1;
		if(root.getInfo() == i) return depth;

		int l = getDepth(root.getLeft(), i, depth + 1);
		int r = getDepth(root.getRight(), i, depth + 1);

		return l != -1 ? l : r;
	}

	public boolean isBalanced(BTNode root) {
		if(root == null) return true;
		int h = getHeight(root.getLeft()) - getHeight(root.getRight());
		if(Math.abs(h) > 1)
			return false;
		return isBalanced(root.getLeft()) && isBalanced(root.getRight());
	}

	public boolean isFull(BTNode root) {
		if(root == null) return true;
		if(root.getLeft() == null && root.getRight() == null) return true;
		if(root.getLeft() == null || root.getRight() == null) return false;

		return isFull(root.getLeft()) && isFull(root.getRight());
	}

	public boolean isComplete(BTNode root) {
		if(root == null) return true;
		aQueue queue = new aQueue();
		queue.enqueue(root);
		boolean flag = false;
		while(!queue.empty()) {
			BTNode v = (BTNode) queue.dequeue();
			if(v.getLeft() != null) {
				if(flag) return false;
				queue.enqueue(v.getLeft());
			}
			else flag = true;
			if(v.getRight() != null) {
				if(flag) return false;
				queue.enqueue(v.getRight());
			}
			else if(root.getLeft() == null || root.getRight() == null) flag = true;
		}
		return true;
	}

	public boolean isPerfect(BTNode root) {
		return isComplete(root) && isBalanced(root);
	}

	private void decreasingOrderHelper(BTNode root) {
		if(root == null) return;
		decreasingOrderHelper(root.getRight());
		System.out.print(root.getInfo() + " ");
		decreasingOrderHelper(root.getLeft());
	}

	public void printIncreasing() {
		increasingOrderHelper(root);
	}

	private void increasingOrderHelper(BTNode root) {
		if(root == null) return;
		increasingOrderHelper(root.getLeft());
		System.out.print(root.getInfo() + " ");
		increasingOrderHelper(root.getRight());
	}

	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();
		b.add(10);
		b.add(5);
		b.add(20);
		b.add(3);
		b.add(7);
		b.add(6);
		b.add(15);
		b.add(30);
		b.add(25);
		b.add(40);
		b.printIncreasing();
		System.out.println();
		b.delete(10);
		b.printIncreasing();
	}
}
