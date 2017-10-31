package org.tec.datastructures.nodes;

public class DoubleNode<T extends Comparable<T>>{
	
	private T value;
	private DoubleNode<T> next;
	private DoubleNode<T> previous;
	
	public DoubleNode(T value){
		this(value,null,null);
	}
	
	public DoubleNode(T value, DoubleNode<T> next, DoubleNode<T> previous) {
		this.value = value;
		this.next = next;
		this.previous = previous;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public DoubleNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}

	public DoubleNode<T> getPrevious() {
		return previous;
	}
	
	public void setPrevious(DoubleNode<T> previous) {
		this.previous = previous;
	}

	public boolean hasNext(){
		return this.next != null;
	}
}
