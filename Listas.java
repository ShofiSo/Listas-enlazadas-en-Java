class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SimpleList {
    private Node head;

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addMiddle(int data, int position) {
        if (position <= 0) {
            addFirst(data);
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) return;
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
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
        Node prev = null, current = head, next;
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
            if (current.data == value) return true;
            current = current.next;
        }
        return false;
    }

    public static void Listas(String[] args) {
        SimpleList list = new SimpleList();
        list.addFirst(1);
        list.add(3);
        list.addMiddle(5, 1);
        list.printList();
        list.remove(3);
        list.printList();
        list.add(7);
        System.out.println("Contains 5: " + list.contains(5));
        System.out.println("Contains 9: " + list.contains(9));
        list.reverse();
        list.printList();
        list.addFirst(9);
        list.printList();
    }
}
