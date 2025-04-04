Lista Enlazada en Java

Este proyecto implementa una lista enlazada en Java. Una lista enlazada es una estructura de datos lineal en la que los elementos (nodos) están conectados mediante referencias.

Explicación del Código

Clase Node

La clase Node representa cada elemento de la lista enlazada. Un nodo contiene:

Un dato (data), que es el valor almacenado.

Un puntero (next), que referencia al siguiente nodo en la lista.

**********************************
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
**********************************
Clase LinkedList

Esta clase maneja la lista enlazada y proporciona métodos para manipularla.

Atributo:

head: Es el primer nodo de la lista.
Métodos:

addFirst(int data): Agrega un nodo al inicio de la lista.

add(int data): Agrega un nodo al final de la lista.

addMiddle(int data, int position): Agrega un nodo en una posición específica.

remove(int data): Elimina un nodo por su valor.

printList(): Imprime la lista enlazada.

reverse(): Invierte la lista enlazada.

contains(int value): Verifica si un valor está en la lista.

**********************************
class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
}
**********************************
Clase Listas (Main)

Es la clase principal que ejecuta el programa y permite al usuario interactuar con la lista enlazada.

Flujo del Programa:

Se crea una instancia de LinkedList.

Se agregan elementos a la lista.

Se eliminan y verifican valores.

Se invierte la lista.

Se solicita un DNI al usuario y se verifica si está en la lista.

**********************************
public class Listas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        list.addFirst(1);
        list.add(3);
        list.addMiddle(5, 1);
        list.printList();

        System.out.print("\nIngrese su DNI: ");
        int dni = scanner.nextInt();

        if (list.contains(dni)) {
            System.out.println("El DNI " + dni + " está en la lista");
        } else {
            System.out.println("El DNI " + dni + " NO está en la lista");
        }

        scanner.close();
    }
}
**********************************
