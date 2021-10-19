package models;

/**
 * Clase encargada de administrar el Nodo
 *
 * @author Diego Fernando Alba Novoa
 * @date 6 Sep 2021
 * @version 1.0
 * @param <T>
 */
public class NodeDoublyLinkedList<T> {
	protected T item;

	protected NodeDoublyLinkedList<T> next;

	protected NodeDoublyLinkedList<T> prev;

	public NodeDoublyLinkedList(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public NodeDoublyLinkedList<T> getNext() {
		return next;
	}

	public void setNext(NodeDoublyLinkedList<T> next) {
		this.next = next;
	}

	public NodeDoublyLinkedList<T> getPrev() {
		return prev;
	}

	public void setPrev(NodeDoublyLinkedList<T> prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return String.valueOf(item);
	}

}
