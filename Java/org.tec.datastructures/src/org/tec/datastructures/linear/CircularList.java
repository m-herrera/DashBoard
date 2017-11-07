package org.tec.datastructures.linear;

import org.tec.datastructures.nodes.SimpleNode;

public class CircularList<T extends Comparable<T>>{
	
	private SimpleNode<T> head;
	
	public CircularList() {
		this(null,null);
	}
	
	public CircularList(SimpleNode<T> Head, SimpleNode<T> Next) {
		head = Head;
		if (head != null) {
			head.setNext(Next);
		}
		
	}
	
	public SimpleNode<T> getHead(){
		return this.head;
	}
	
	
	public void append (T value) {
		if (head == null){
			head = new SimpleNode<T>(value);
			head.setNext(head);
			return;
		}
		T headCopy = head.getValue();
		SimpleNode<T> headNextCopy = head.getNext();
		
		head.setValue(value);
		
		SimpleNode<T> insert = new SimpleNode<T>(headCopy);
		
		head.setNext(insert);
		insert.setNext(headNextCopy);
		
		head = insert;
	}
	
	
	public SimpleNode<T> search(T value) {
		SimpleNode<T> temp = head;
		
		if (head == null) {
			return null;
		} 
		
		do {
			if(temp.getValue().equals(value)){
				return temp;
			}
			temp = temp.getNext();
			
		}while(temp != head);
		
		return null;
	}

	public void delete(T value) {
		SimpleNode<T> temp = head;
		
		if (head == null) {
			return;
		}
		
		do {
			if(temp.getValue().equals(value)) {
				if (temp == head) {
					if (length() == 1) {
						head = null;
					}
				}
				temp.setValue(temp.getNext().getValue());
				if (temp.getNext() == head) {
					head = temp;
				}
				temp.setNext(temp.getNext().getNext());
				break;
			}
			temp = temp.getNext();
			
		}while(temp != head);
		
	}		
	
	
	public boolean isEmpty(){
		return this.head == null;
	}
	
	
	public int length() {
		SimpleNode<T> temp = head;
		if (temp == null) {
			return 0;
		}
		int result = 0;
		do {
			result++;
			temp = temp.getNext();
		}while (temp != head);
		return result;
	}

	public void clear() {
		this.head = null;
	}
	
}
