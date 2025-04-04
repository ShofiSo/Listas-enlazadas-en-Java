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

- Clase Listas.java
Esta es la clase principal que maneja la entrada del usuario y la ejecución del programa.

Solicita al usuario su DNI mediante Scanner.

Determina el grupo basado en el último dígito del DNI:

Si el último dígito es 1, 3, 5, 7 o 9, pertenece al Grupo 2 y ejecuta una secuencia de operaciones en la lista enlazada.

Realiza las operaciones en la lista enlazada:

Agregar, eliminar, verificar valores y revertir la lista.

Imprime los resultados en la consola.

*************************************
System.out.print("\nIngrese su DNI por favor: ");
long dni = scanner.nextLong(); 

int lastDigit = (int) (dni % 10);
if (lastDigit == 1 || lastDigit == 3 || lastDigit == 5 || lastDigit == 7 || lastDigit == 9) {
    System.out.println("Perteneces al Grupo 2. Ejecutando instrucciones...");
    // Ejecución de operaciones en la lista enlazada
}
*************************************
