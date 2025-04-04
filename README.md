Explicación del Código - Lista Enlazada en Java
1. Descripción General
Este programa implementa una lista enlazada simple en Java, permitiendo al usuario realizar varias operaciones como agregar elementos, eliminarlos, buscar valores y revertir la lista. Además, solicita un DNI al usuario y determina a qué grupo pertenece para ejecutar una secuencia de instrucciones específicas según el documento.
2. Estructura del Código
El código se compone de tres clases principales:
- Clase Node (Nodo de la Lista)
Define un nodo de la lista enlazada, el cual tiene:

Un atributo data para almacenar un valor entero.

Un atributo next que referencia al siguiente nodo en la lista.

Un constructor que inicializa el nodo con un valor y apunta a null en next.

*************************************
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
*************************************

- Clase LinkedList (Lista Enlazada)
Implementa la estructura de la lista enlazada y sus operaciones:

add(int data) → Agrega un nodo al final.

addFirst(int data) → Agrega un nodo al inicio.

addMiddle(int data, int position) → Agrega un nodo en una posición específica.

remove(int data) → Elimina un nodo que contenga el valor indicado.

printList() → Imprime todos los valores de la lista.

reverse() → Revierte el orden de la lista.

contains(int value) → Verifica si un número está en la lista

*************************************
class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
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

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addMiddle(int data, int position) {
        if (position <= 0 || head == null) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        int count = 0;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void remove(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
*************************************

- Clase Listas.java
Esta es la clase principal que maneja la entrada del usuario y la ejecución del programa.

Solicita al usuario su DNI mediante Scanner.

Determina el grupo basado en el último dígito del DNI:

Si el último dígito es 1, 3, 5, 7 o 9, pertenece al Grupo 2 y ejecuta una secuencia de operaciones en la lista enlazada.

Realiza las operaciones en la lista enlazada:

Agregar, eliminar, verificar valores y revertir la lista.

Imprime los resultados en la consola.

*************************************
public class Listas {  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        // Solicitar DNI al usuario en la consola
        System.out.print("Ingrese su DNI por favor: ");
        long dni = scanner.nextLong();

        // Validar si el usuario pertenece al Grupo 2
        if (dni % 10 == 1 || dni % 10 == 3 || dni % 10 == 5 || dni % 10 == 7 || dni % 10 == 9) {
            list.addFirst(1);
            list.add(3);
            list.addMiddle(5, 1);
            System.out.println("Lista actual:");
            list.printList();
            
            list.remove(3);
            System.out.println("Lista después de eliminar el 3:");
            list.printList();
            
            list.add(7);
            System.out.println("¿La lista contiene el 5? " + list.contains(5));
            System.out.println("¿La lista contiene el 9? " + list.contains(9));

            list.reverse();
            System.out.println("Lista después de revertir:");
            list.printList();

            list.addFirst(9);
            System.out.println("Lista final:");
            list.printList();
        } else {
            System.out.println("Su carnet no pertenece al Grupo 2.");
        }

        scanner.close();
    }
}
*************************************
