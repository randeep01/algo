package org.saggu.ll;

public class Stack<T> {

	LinkedList<T> ll;
	public Stack() {
		ll = new LinkedList<>();
	}
	public void push(T data) {
		ll.addFront(data);
	}
	public T pop() {
		return ll.removeFront();
	}
	
}
