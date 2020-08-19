
public class dynamicqueue {
    int[] arr;
    int front;
    int size;

    dynamicqueue() {
        arr = new int[5];
        front = 0;
        size = 0;

    }

    dynamicqueue(int n) {
        arr = new int[n];
        front = 0;
        size = 0;

    }

    public int size() {
        return size;
    }

    void add(int val) {
        if (size == arr.length) {
            int[] narr = new int[2 * arr.length];
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % arr.length;
                narr[idx] = arr[idx];
            }

            arr = narr;
            front = 0;
            arr[size] = val;
            size++;
        } else {
            int idx = (front + size) % arr.length;
            arr[idx] = val;
            size++;
        }
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