package org.tec.datastructures.linear;

import org.tec.datastructures.nodes.SimpleNode;

public class SimpleList<T extends Comparable<T>>{
	
	private SimpleNode<T> head;
	
	public SimpleList() {
		this(null);
	}
	
	public SimpleList(SimpleNode<T> Head) {
		head = Head;
	}
	
	public SimpleNode<T> getHead(){
		return this.head;
	}
	
	
	public void append (T value) {
		if (this.head == null){
			this.head = new SimpleNode<T>(value);
			return;
		}
		SimpleNode<T> temp = this.head;
		while (temp.hasNext()){
			temp = temp.getNext();
		}
		temp.setNext(new SimpleNode<T>(value));
	}

	
	public SimpleNode<T> search(T value) {
		SimpleNode<T> temp = this.head;
		while(temp != null){
			if(temp.getValue().equals(value)){
				break;
			}
			temp = temp.getNext();
		}
		return temp;
	}

	public void delete(T value) {
		SimpleNode<T> temp = this.head;
		SimpleNode<T> prev = null;
		while(temp != null){
			if(temp.getValue().equals(value)){
				if (temp == this.head){
					this.head = temp.getNext();
				}
				else{
					prev.setNext(temp.getNext());
				}
				break;
			}
			prev = temp;
			temp = temp.getNext();
		}
		
	}		
	
	
	public boolean isEmpty(){
		return this.head == null;
	}
	
	
	public int length() {
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
