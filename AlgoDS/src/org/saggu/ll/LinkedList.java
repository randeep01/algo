package org.saggu.ll;

public class LinkedList<T> implements ListIterator<T> {

	Node<T> start;
	Node<T> ptr;

	public void addFront(T data) {
		Node<T> node = new Node<>(data);
		if (start == null) {
			start = node;
			return;
		}
		node.next = start;
		start = node;
	}

	public void addLast(T data) {
		Node<T> node = new Node<>(data);
		if (start == null) {
			start = node;
			return;
		}
		Node<T> last = start;
		while (last.next != null) {
			last = last.next;
		}
		last.next = node;

	}

	public T removeFront() {
		if (start == null) {
			return null;
		}

		Node<T> temp = start;

		start = start.next;

		return temp.data;
	}

	public void removeNode(T data) {
		if (start == null) {
			return;
		}
		Node<T> temp = start, prev = null;
		if (temp != null && temp.data == data) {
			start = start.next;
			return;
		}
		while (temp != null && temp.data != data) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null)
			return;
		prev.next = temp.next;
	}

	public static void main(String args[]) {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.addFront(1);
		ll.addFront(2);
		ll.addFront(3);
		ll.addFront(4);

		ListIterator<Integer> iter = ll;
		iter.init();
		while (iter.hasNext() == true) {
			System.out.println(iter.next().data);

		}
		System.out.println("---");
		//System.out.println("---" + ll.removeFront());
		//System.out.println("---" + ll.removeFront());
ll.removeNode(2);
		iter.init();
		while (iter.hasNext() == true) {
			System.out.println(iter.next().data);

		}
	}

	@Override
	public Node<T> next() {
		// TODO Auto-generated method stub
		Node<T> temp = ptr;
		ptr = ptr.next;
		return temp;
	}

	@Override
	public void init() {
		ptr = start;

	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (ptr == null) {
			return false;
		} else {
			return true;
		}

	}
}
