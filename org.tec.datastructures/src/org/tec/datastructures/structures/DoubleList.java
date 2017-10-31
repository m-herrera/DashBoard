package org.tec.datastructures.structures;

import org.tec.datastructures.nodes.DoubleNode;

public class DoubleList<T extends Comparable<T>>{
	
	DoubleNode<T> head;
	
	public DoubleList(DoubleNode<T> Head) {
		head = Head;
	}
	public DoubleList() {
		this(null);
	}
	
	public DoubleNode<T> getHead(){
		return this.head;
	}
	
	
	public void append(T value) {
		if (this.head == null){
			this.head = new DoubleNode<T>(value);
			return;
		}
		DoubleNode<T> temp = this.head;
		while (temp.hasNext()){
			temp = temp.getNext();
		}
		DoubleNode<T> temp2 = new DoubleNode<T>(value); 
		temp.setNext(temp2);
		temp2.setPrevious(temp);
	}
	
	
	public DoubleNode<T> search(T value) {
		DoubleNode<T> temp = this.head;
		while(temp != null){
			if(temp.getValue().equals(value)){
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}

	
	public void delete(T value) {
		DoubleNode<T> temp = this.head;
		while(temp != null){
			if(temp.getValue().equals(value)){
				if (temp == this.head){
					this.head = temp.getNext();
				}
				else{
					temp.getPrevious().setNext(temp.getNext());
				}
				break;
				
			}
			temp = temp.getNext();
		}
	
	}
	
	public boolean isEmpty(){
		return this.head == null;
	}

	
	public int length() {
		DoubleNode<T> current = head;
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
