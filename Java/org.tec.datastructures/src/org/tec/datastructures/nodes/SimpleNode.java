package org.tec.datastructures.nodes;

public class SimpleNode <T extends Comparable<T>>{
	
	private T value;
	private SimpleNode <T> next;
	

	public SimpleNode(T value){
		setValue(value);
		setNext(null);
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public SimpleNode<T> getNext() {
		return next;
	}

	public void setNext(SimpleNode<T> next) {
		this.next = next;
	}

	public boolean hasNext(){
		return this.next != null;
	}
}
