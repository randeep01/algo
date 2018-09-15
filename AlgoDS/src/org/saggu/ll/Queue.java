package org.saggu.ll;

public class Queue<T> {
	LinkedList<T> ll = new LinkedList<>();
	
	public void enque(T data) {
		ll.addLast(data);
	}
	public T deque() {
		return ll.removeFront();
	}
}
