package circularqueue;

public class CircularQueue {
    int[] arr; int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity; arr = new int[capacity]; front = 0; size = 0; rear = capacity - 1;
    }

    boolean isFull() { return size == capacity; }
    boolean isEmpty() { return size == 0; }

    public void enqueue(int item) {
        if (isFull()) {
            capacity *= 2;
            int[] newArr = new int[capacity];
            for (int i = 0; i < size; i++) newArr[i] = arr[(front + i) % size];
            arr = newArr; front = 0; rear = size - 1;
        }
        rear = (rear + 1) % capacity; arr[rear] = item; size++;
        System.out.println(item + " enqueued");
    }

    public int dequeue() {
        if (isEmpty()) { System.out.println("Queue is empty"); return -1; }
        int item = arr[front]; front = (front + 1) % capacity; size--; return item;
    }

    public void display() {
        if (isEmpty()) { System.out.println("Queue is empty"); return; }
        for (int i = 0; i < size; i++) System.out.print(arr[(front + i) % capacity] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);
        cq.enqueue(10); cq.enqueue(20); cq.enqueue(30); cq.display();
        cq.enqueue(40); cq.display();
        System.out.println("Dequeued: " + cq.dequeue()); cq.display();
    }
}
