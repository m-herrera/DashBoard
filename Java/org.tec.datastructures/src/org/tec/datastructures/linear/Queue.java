package org.tec.datastructures.linear;

import org.tec.datastructures.nodes.SimpleNode;

public class Queue<T extends Comparable<T>> {
	
	private SimpleNode<T> head;
	
	public Queue() {
		this(null);
	}
	
	public Queue(SimpleNode<T> Head) {
		head = Head;
	}
	
	public void enqueue(T value) {
		if (head == null) {
			head = new SimpleNode<T>(value);
			return;
		}
		
		SimpleNode<T> temp = new SimpleNode<T>(value);
		temp.setNext(head);
		head = temp;
	}
	
	public SimpleNode<T> dequeue() {
		if (head == null) {
			return null;
		}
		
		SimpleNode<T> temp = head;
		SimpleNode<T> prev = null;
		while(temp.hasNext()) {
			prev= temp;
			temp = temp.getNext();
		}
		if (prev == null) {
			clear();
			return temp;
			
		}
		prev.setNext(null);
		return temp;
	}
	
	public SimpleNode<T> peak() {
		if (head == null) {
			return null;
		}
		
		SimpleNode<T> temp = head;
		while(temp.hasNext()) {
			temp = temp.getNext();
		}
		return temp;
	}
	
	public int size() {
		SimpleNode<T> temp = head;
		int result = 0;
		while (temp != null){
			result++;
			temp = temp.getNext();
		}
		return result;
	}

	public void clear() {
		this.head = null;
	}
}
