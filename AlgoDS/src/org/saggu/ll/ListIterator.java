package org.saggu.ll;

public interface ListIterator<T> {
	public Node<T> next();
	public boolean hasNext();
	public void init();

}
