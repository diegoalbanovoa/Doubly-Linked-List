package test;

import models.DoublyLinkedList;

/**
 * Clase encargada de Test de la clase DoublyLinkedList
 *
 * @author Diego Fernando Alba Novoa
 * @date 6 Sep 2021
 * @version 1.0
 */
public class TestDoublyLinkedList {
	public static void main(String[] args) {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		System.out.println(
				"-----------------------> Caso de prueba para verificar la inserción en el encabezado de la lista vinculada <----------------------\n");
		System.out.println("Lista Vacia: " + doublyList.isEmpty());
		System.out.println("Tamaño de la lista: " + (doublyList.size() == 0));
		doublyList.insertAtHead("Tom");
		System.out.println("Lista Vacia: " + doublyList.isEmpty());
		System.out.println("Tamaño de la lista: " + (doublyList.size() == 1));
		System.out.println("Objeto en posicion 0 valor: " + doublyList.searchByIndex(0).getItem());

		System.out.println(
				"------------------------> Caso de prueba para verificar la inserción al final de la lista vinculada <-----------------------------\n");
		System.out.println("Lista Vacia: " + doublyList.isEmpty());
		System.out.println("Tamaño de la lista: " + (doublyList.size() == 1));
		doublyList.insertAtHead("lolo");
		System.out.println("Lista Vacia: " + doublyList.isEmpty());
		doublyList.insertAtTail("Alex");
		System.out.println("Tamaño de la lista: " + (doublyList.size() == 3));
		System.out.println("Objeto en posicion 0 valor: " + doublyList.searchByIndex(0).getItem());
		System.out.println("Objeto en posicion 1 valor: " + doublyList.searchByIndex(1).getItem());

		System.out.println(
				"---------------------> Caso de prueba para verificar la inserción en una posición determinada de la lista vinculada <-------------\n");
		System.out.println("Insertar en la posicion 2");
		doublyList.insertAtPosition("Steve", 2);
		System.out.println("Tamaño de la lista: " + (doublyList.size() == 4));
		System.out.println("Elementos de las posciones 0,1,2,3");
		System.out.println("1. " + doublyList.searchByIndex(0).getItem());
		System.out.println("2. " + doublyList.searchByIndex(1).getItem());
		System.out.println("3. " + doublyList.searchByIndex(2).getItem());
		System.out.println("4. " + doublyList.searchByIndex(3).getItem());
	}
}
