package com.ioannes.DoublyLinkedList;

public class DNode {

	int info;
	DNode prev, next;

	public DNode(int i) {
		info = i;
		prev = next = null;
	}

	public int getInfo() {
		return info;
	}
	public DNode getNext() {
		return next;
	}
	public DNode getPrev() {
		return prev;
	}

	public void setInfo(int i) {
		info = i;
	}
	public void setPrev(DNode p) {
		prev = p;
	}
	public void setNext(DNode n) {
		next = n;
	}
}
