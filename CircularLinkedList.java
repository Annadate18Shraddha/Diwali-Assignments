package CircularLinkedListDemo;

public class CircularLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; next = null; }
    }

    Node head = null;

    public void insert(int data, int position) {
        Node newNode = new Node(data);
        if (head == null) { head = newNode; head.next = head; return; }
        if (position == 1) {
            Node temp = head;
            while (temp.next != head) temp = temp.next;
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void delete(int data) {
        if (head == null) return;
        Node temp = head, prev = null;
        if (head.data == data) {
            while (temp.next != head) temp = temp.next;
            if (head == head.next) { head = null; return; }
            temp.next = head.next;
            head = head.next;
            return;
        }
        temp = head;
        do {
            prev = temp;
            temp = temp.next;
            if (temp.data == data) { prev.next = temp.next; return; }
        } while (temp != head);
    }

    public void modify(int oldData, int newData) {
        if (head == null) return;
        Node temp = head;
        do {
            if (temp.data == oldData) { temp.data = newData; return; }
            temp = temp.next;
        } while (temp != head);
    }

    public void display() {
        if (head == null) { System.out.println("List is empty"); return; }
        Node temp = head;
        do { System.out.print(temp.data + " -> "); temp = temp.next; } while (temp != head);
        System.out.println("(head)");
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(10, 1); cll.insert(20, 2); cll.insert(15, 2);
        System.out.print("Linked List: "); cll.display();
        cll.modify(15, 17); System.out.print("After modify: "); cll.display();
        cll.delete(20); System.out.print("After delete: "); cll.display();
    }
}
