package com.ioannes.LinkedLists;

public class LinkedList {

	public Node head;
	public int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public void add(int i) {
		if(head == null) head = new Node(i);
		else {
			Node cur = head;
			while(cur.getNext() != null) {
				cur = cur.getNext();
			}
			cur.setNext(new Node(i));
		}
		size++;
	}

	public void insert(int idx, int value) {
		if(idx > size) return;
		Node insert = new Node(value);
		Node temp = head;
		if(idx == 0) {
			insert.setNext(head);
			head = insert;
			return;
		}
		int count = 0;
		while(count < idx - 1) {
			temp = temp.getNext();
			count++;
		}
		insert.setNext(temp.getNext()); 
		temp.setNext(insert);
		size++;
	}

	public Node delete(int idx) {
		if(idx > size - 1) return null;
		if(idx == 0) {
			Node returnee = head;
			head = head.next;
			size--;
			return returnee;
		}
		else {
			int count = 0;
			Node temp = head;
			while(count < idx - 1) {
				temp = temp.getNext();
				count++;
			}
			Node returnee = temp.getNext();
			temp.setNext(temp.getNext().getNext());
			size--;
			return returnee;
		}
	}

	public void remove(int value) {
		if(head == null) return;

		if(head.getInfo() == value) {
			head = head.getNext();
			return;
		}

		Node current = head;
		while(current.getNext() != null) {
			if(current.getNext().getInfo() == value) {
				current.setNext(current.getNext().getNext());
				return;
			}
			current = current.getNext();
		}
	}

	public void swapTwo(int i, int j) {
		Node u = delete(i);
		Node v = delete(j-1);
		if(i == 0) {
			insert(0, v.getInfo());
			insert(j, u.getInfo());
		}
		else {
			insert(i, v.getInfo());
			insert(j, u.getInfo());
		}
	}

	public void printList() {
		if(head == null) System.out.println("null");
		else {
			Node cur = head;
			while(cur != null) {
				System.out.print(cur.getInfo() + " -> ");
				cur = cur.getNext();
			}
			System.out.println("null");
		}
	}

	public static void main(String[] x) {
		LinkedList l = new LinkedList();
		l.add(1);
		l.add(2);
		l.add(3);
		l.swapTwo(1, 2);
		l.printList();
	}
}

