package org.tec.datastructures.structures;

import org.tec.datastructures.nodes.SimpleNode;

public class Stack<T extends Comparable<T>>{
	
	private SimpleNode<T> head;
	
	public Stack() {
		this(null);
	}
	
	public Stack(SimpleNode<T> Head) {
		head = Head;
	}
	
	public SimpleNode<T> peak(){
		return this.head;
	}
	
	
	public void push (T value) {
		if (head == null){
			head = new SimpleNode<T>(value);
			return;
		}
		SimpleNode<T> appended = new SimpleNode<T>(value);
		appended.setNext(head);
		head = appended;
	}

	
	public SimpleNode<T> pop() {
		if (head == null) {
			return null;
		}
		SimpleNode<T> popped = head;
		head = head.getNext();
		return popped;
	}

	public int size() {
		SimpleNode<T> current = head;
		int result = 0;
		while (current != null){
			result++;
			current = current.getNext();
		}
		return result;
	}

	public void clear() {
		this.head = null;
	}
	
}
