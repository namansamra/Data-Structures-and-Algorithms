import java.util.Stack;;

public class queue {
    int[] arr;
    int front;
    int size;

    queue() {
        arr = new int[5];
        front = 0;
        size = 0;

    }

    queue(int n) {
        arr = new int[n];
        front = 0;
        size = 0;

    }

    public int size() {
        return size;
    }

    public void add(int val) {
        if (size() == arr.length) {
            System.out.println("Queue overflow");
            return;
        }
        int rear = (front + size) % arr.length;
        arr[rear] = val;
        size++;
    }

    public int remove() {
        if (size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }

        int val = arr[front];
        front = (front + 1) % arr.length; // just for front ++
        size--;
        return val;

    }

    public int peek() {
        if (size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        return arr[front];
    }

    public void display() {
        for (int i = 0; i < size(); i++) {
            int idx = (front + i) % arr.length;
            System.out.print(arr[idx] + " ");
        }

        System.out.println();
    }

}