import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

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