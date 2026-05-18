/*
 * Singly Linked List (Lista Simplu Inlantuita)
 * --------------------------------------------
 * node1(info, next) ---> node2(info, next) ---> node3(info, next) ---> ... ---> nodeN(info, NULL)
 *  /\
 *  ||
 * HEAD
 *
 * Operatii:
 *  - adaugare la inceputul listei
 *  - afisare
 *  - adaugare dupa un nod
 *  - adaugare inainte de un nod
 *  - stergere nod
 *  - reverse
 */

public class SinglyLinkedList {

    // -------------------------------------------------------
    // Nodul listei — echivalentul struct Node din C++
    // -------------------------------------------------------
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // HEAD-ul listei (echivalentul variabilei globale Node *head = NULL)
    Node head = null;

    // -------------------------------------------------------
    // Adaugare la inceputul listei
    // Echivalent: addToLinkedList()
    // In Java nu mai este nevoie de malloc/free — new Node()
    // aloca automat in heap, iar Garbage Collector elibereaza.
    // -------------------------------------------------------
    void addToLinkedList(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head; // pointeaza catre HEAD curent
            head = newNode;      // noul HEAD devine noul nod
        }
    }

    // -------------------------------------------------------
    // Afisare lista
    // Echivalent: displaySinglyLinkedList()
    // -------------------------------------------------------
    void display() {
        Node c = head; // pastram adresa capului listei
        while (c != null) {
            System.out.print(c.data + " ");
            c = c.next; // deplasare la nodul urmator
        }
        System.out.println();
    }

    // -------------------------------------------------------
    // Adaugare dupa un nod cu valoarea afterNode
    // Echivalent: addAfterNode()
    // -------------------------------------------------------
    void addAfterNode(int afterNode, int val) {
        Node c = head;
        // ne pozitionam pe nodul dupa care vrem sa inseram
        while (c != null && c.data != afterNode) {
            c = c.next;
        }
        if (c == null) {
            System.out.println("Nodul cu valoarea " + afterNode + " nu a fost gasit!");
            return;
        }
        Node newNode = new Node(val);
        newNode.next = c.next; // noul nod pointeaza catre succesorul lui c
        c.next = newNode;      // c pointeaza catre noul nod
    }

    // -------------------------------------------------------
    // Adaugare inainte de un nod cu valoarea beforeNode
    // Echivalent: addBeforeNode()
    // -------------------------------------------------------
    void addBeforeNode(int beforeNode, int val) {
        Node newNode = new Node(val);

        // Cazul 1: nodul cautat este HEAD
        if (head != null && head.data == beforeNode) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Cazul 2: nodul cautat este in interiorul listei
        Node c = head;
        while (c != null && c.next != null && c.next.data != beforeNode) {
            c = c.next;
        }
        if (c == null || c.next == null) {
            System.out.println("Nodul cu valoarea " + beforeNode + " nu a fost gasit!");
            return;
        }
        // c = nodul precedent celui dupa care inseram
        newNode.next = c.next;
        c.next = newNode;
    }

    // -------------------------------------------------------
    // Stergere nod cu valoarea delNode
    // Echivalent: removeNode()
    // In Java nu exista free() — GC se ocupa automat de
    // eliberarea memoriei dupa ce nu mai exista referinte.
    // -------------------------------------------------------
    void removeNode(int delNode) {
        if (head == null) {
            System.out.println("Lista este goala!");
            return;
        }

        // Cazul 1: nodul de sters este HEAD
        if (head.data == delNode) {
            head = head.next; // GC elibereaza vechiul HEAD
            return;
        }

        // Cazul 2: nodul de sters este in interiorul listei
        // ne pozitionam pe nodul dinaintea celui de sters
        Node c = head;
        while (c.next != null && c.next.data != delNode) {
            c = c.next;
        }
        if (c.next == null) {
            System.out.println("Nodul cu valoarea " + delNode + " nu a fost gasit!");
            return;
        }
        c.next = c.next.next; // sarim peste nodul de sters; GC il elibereaza
    }

    // -------------------------------------------------------
    // Inversare lista (iterativ, three-pointer)
    // Echivalent: reverse()
    // -------------------------------------------------------
    Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;  // salvam succesorul
            curr.next = prev;  // inversam legatura
            prev = curr;       // avansam prev
            curr = next;       // avansam curr
        }
        return prev; // prev devine noul HEAD
    }

    // -------------------------------------------------------
    // MAIN
    // -------------------------------------------------------
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        int[] arr = {1, 22, 3, 4, 53, 6, 71, 8, 91, 10, 11, 12};

        for (int val : arr) {
            list.addToLinkedList(val);
        }

        System.out.println("----------------");
        System.out.print("Lista initiala:  ");
        list.display();
        System.out.println("----------------");

        System.out.println("Adaugare valoarea 41 dupa nodul cu valoarea 8:");
        list.addAfterNode(8, 41);
        list.display();
        System.out.println("----------------");

        System.out.println("Adaugare valoarea 88 inainte de nodul cu valoarea 12:");
        list.addBeforeNode(12, 88);
        list.display();
        System.out.println("----------------");

        System.out.println("Stergere nod cu valoarea 53:");
        list.removeNode(53);
        list.display();
        System.out.println("----------------");

        System.out.println("Lista inversata:");
        list.head = list.reverse(list.head);
        list.display();
        System.out.println("----------------");
    }
}
