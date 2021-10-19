package models;

/**
 * Clase encargada de administar elementos almacenados en la clase Node
 *
 * @author Diego Fernando Alba Novoa
 * @date 6 Sep 2021
 * @version 1.0
 * @param <T>
 */
public class DoublyLinkedList<T> {
	private NodeDoublyLinkedList<T> head;

	private NodeDoublyLinkedList<T> tail;
	private int size = 0;

	/**
	 * <h1>M�todo insertAtHead</h1><br>
	 * M�todo encargado de inserta un elemento en una lista vinculada en la posici�n
	 * principal. Esto no requiere recorrer la lista completa.
	 *
	 * <br>
	 * Complejidad: Dado que no hay ning�n cruce involucrado aqu�, y la inserci�n
	 * siempre ocurre en la cabeza, esto se puede hacer en constante tiempo. Por
	 * tanto, la complejidad resulta ser O (1) </br>
	 * 
	 * @param value Valor
	 */
	public void insertAtHead(T value) {
		NodeDoublyLinkedList<T> newNode = new NodeDoublyLinkedList<T>(value);
		if (null == head) {
			newNode.next = null;
			newNode.prev = null;
			head = newNode;
			tail = newNode;
			size++;
		} else {
			newNode.next = head;
			newNode.prev = null;
			head.prev = newNode;
			head = newNode;
			size++;
		}
	}

	/**
	 * <h1>M�todo insertAtTail</h1><br>
	 * M�todo encargado de inserta un elemento en una lista vinculada en la posici�n
	 * final. Esto no necesita recorrido a trav�s de la lista completa antes de que
	 * ocurra la inserci�n.
	 *
	 * <br>
	 * Complejidad: dado que el recorrido a trav�s de toda la lista NO est�
	 * involucrado aqu� antes se inserta un nuevo nodo, y supongamos que la lista
	 * tiene n elementos, por lo que la inserci�n en la cola tomar� O (1) tiempo
	 * </br>
	 *
	 * @param value
	 */
	public void insertAtTail(T value) {
		NodeDoublyLinkedList<T> newNode = new NodeDoublyLinkedList<T>(value);
		if (null == tail) {
			newNode.next = null;
			newNode.prev = null;
			head = newNode;
			tail = newNode;
			size++;
		} else {
			tail.next = newNode;
			newNode.next = null;
			newNode.prev = tail;
			tail = newNode;
			size++;
		}
	}

	/**
	 * <h1>M�todo insertAtPosition</h1><br>
	 * M�todo encargado de inserta un elemento en una lista vinculada en una
	 * posici�n determinada. Esto necesita recorrido a trav�s de la lista enlazada
	 * hasta la posici�n dada.
	 *
	 * <br>
	 * Complejidad: esta inserci�n puede ocurrir posiblemente en el �ltimo nodo,
	 * significa que tener complejidad como O (1) como se explic� anteriormente. es
	 * posible que tengamos que atravesar todo lista enlazada. En un caso promedio
	 * con una lista enlazada que tiene n elementos, esto toma n / 2 de tiempo y
	 * despu�s de ignorar el t�rmino constante, la complejidad sale a ser O (n)
	 * </br>
	 *
	 * @param value
	 * @param position
	 */
	public void insertAtPosition(T value, int position) {
		if (position < 0 || position > size) {
			throw new IllegalArgumentException("Position is Invalid");
		}
		if (position == 0) {
			insertAtHead(value);
		} else if (position == size - 1) {
			insertAtTail(value);
		} else {
			NodeDoublyLinkedList<T> currentNode = head;
			for (int i = 0; i < position; i++) {
				currentNode = currentNode.next;
			}
			NodeDoublyLinkedList<T> previousNode = currentNode.prev;
			NodeDoublyLinkedList<T> newNode = new NodeDoublyLinkedList<T>(value);
			newNode.next = currentNode;
			newNode.prev = previousNode;
			previousNode.next = newNode;
			currentNode.prev = newNode;
			size++;
		}
	}

	/**
	 * <h1>M�todo traverseForward</h1><br>
	 * M�todo encargado de recorra la lista vinculada hacia adelante e imprima los elementos
	 */
	public void traverseForward() {
		NodeDoublyLinkedList<T> temp = head;
		while (temp != null) {
			System.out.println(temp.item);
			temp = temp.next;
		}
	}

	/**
	 * <h1>M�todo traverseBackward</h1><br>
	 * M�todo encargado de recorra la lista vinculada hacia atr�s e imprima los elementos
	 */
	public void traverseBackward() {
		NodeDoublyLinkedList<T> temp = tail;
		while (temp != null) {
			System.out.println(temp.item);
			temp = temp.prev;
		}
	}

	/**
	 * <h1>M�todo traverseBackward</h1><br>
	 * M�todo encargado de devuelve el tama�o de la lista vinculada
	 * 
	 * @return el tama�o de la lista
	 */
	public int size() {
		return size;
	}

	/**
	 * <h1>M�todo isEmpty</h1><br>
	 * M�todo encargado de devuelve verdadero, si la lista vinculada est� vac�a
	 * 
	 * @return <code>True</code> si la lista esta vacia, <code>False</code> si la
	 *         lista tiene al menos un elemento
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * <h1>M�todo searchByIndex</h1><br>
	 * M�todo encargado de devuelve el elemento de datos que contiene el nodo despu�s de buscar un
	 * �ndice determinado. Si Se pasa un �ndice no v�lido, se lanza la excepci�n
	 * adecuada.
	 * 
	 * @param index posicion
	 * @return Nodo en la posici�n que le pasamos por par�metro
	 */
	public NodeDoublyLinkedList<T> searchByIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index passed while searching for a value");
		}
		NodeDoublyLinkedList<T> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * <h1>M�todo searchByValue</h1><br>
	 * M�todo encargado de devuelve el nodo que contiene el elemento de datos despu�s de buscar un valor
	 * dado. Si Hay varios valores iguales en la lista vinculada, se devolver� el
	 * primero.
	 * 
	 * @param value Valor
	 * @return Nodo en igual al valor que se e paso por par�metro
	 */
	public NodeDoublyLinkedList<T> searchByValue(T value) {
		NodeDoublyLinkedList<T> temp = head;
		while (null != temp.next && temp.item != value) {
			temp = temp.next;
		}
		if (temp.item == value) {
			return temp;
		}
		return null;
	}

	/**
	 * <h1>M�todo deleteFromHead</h1><br>
	 * M�todo encargado de eliminar el elemento presente en el nodo principal
	 */
	public void deleteFromHead() {
		if (null == head) {
			return;
		}
		NodeDoublyLinkedList<T> temp = head;
		head = temp.next;
		head.prev = null;
		size--;
	}

	/**
	 * <h1>M�todo deleteFromTail</h1><br>
	 * M�todo encargado de eliminar el elemento presente en el nodo de cola
	 */
	public void deleteFromTail() {
		if (null == tail) {
			return;
		}
		NodeDoublyLinkedList<T> temp = tail;
		tail = temp.prev;
		tail.next = null;
		size--;
	}

	/**
	 * <h1>M�todo deleteFromPosition</h1><br>
	 * M�todo encargado de eliminar el elemento presente en una posici�n determinada
	 * 
	 * @param position Posicion
	 */
	public void deleteFromPosition(int position) {
		if (position < 0 || position >= size) {
			throw new IllegalArgumentException("Position is Invalid");
		}
		NodeDoublyLinkedList<T> nodeToBeDeleted = head;
		for (int i = 0; i < position; i++) {
			nodeToBeDeleted = nodeToBeDeleted.next;
		}
		NodeDoublyLinkedList<T> previousNode = nodeToBeDeleted.prev;
		NodeDoublyLinkedList<T> nextNode = nodeToBeDeleted.next;
		previousNode.next = nextNode;
		nextNode.prev = previousNode;
		size--;
	}

	/**
	 * <h1>M�todo toArray</h1><br>
	 * M�todo encargado de devuelve una matriz que contiene cada elemento de la lista de principio a
	 * fin.
	 * 
	 * @return lista de objetos 
	 */
	public Object[] toArray() {
		Object[] result = new Object[size];
		int i = 0;
		for (NodeDoublyLinkedList<T> x = head; x != null; x = x.next) {
			result[i++] = x.item;
		}
		return result;
	}
}
