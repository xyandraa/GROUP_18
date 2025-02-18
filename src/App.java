import java.util.Scanner;

class LinkedList {
    Node head;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class ArrayList {
    int[] array = new int[10];
    int size = 0;

    public void insert(int value) {
        if (size == array.length) {
            expandArray();
        }
        array[size++] = value;
    }

    private void expandArray() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void display() {
        if (size == 0) {
            System.out.println("null");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + (i < size - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        while (true) {
            System.out.println("Enter a value: ");
            int value = sc.nextInt();

            System.out.println("Operations: ");
            System.out.println("1. Insert " + value + " to the array");
            System.out.println("2. Insert " + value + " to the linked list");
            System.out.print("Enter a choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                arrayList.insert(value);
                System.out.println("Array after insertion: ");
                arrayList.display();
            } else if (choice == 2) {
                System.out.println("1. beginning");
                System.out.println("2. end");
                System.out.println("Enter a choice:");
                int position = sc.nextInt();
                if (position == 1) {
                    linkedList.insertAtBeginning(value);
                } else if (position == 2) {
                    linkedList.insertAtEnd(value);
                }
                System.out.println("Linked list after insertion:");
                linkedList.display();
            }

            System.out.println("Options: ");
            System.out.println("1. Enter new value");
            System.out.println("2. End");
            System.out.print("Enter a choice: ");
            int continueChoice = sc.nextInt();

            if (continueChoice == 2) {
                break;
            }
        }
        sc.close();
    }
}

