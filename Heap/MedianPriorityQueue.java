import java.util.*;

public class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void add(int val) {
        if (right.size() != 0 && right.peek() <= val) {
            right.add(val);
        } else {
            left.add(val);
        }

        if (left.size() - right.size() > 1) {
            right.add(left.remove());
        } else if (right.size() - left.size() > 1) {
            left.add(right.remove());
        }
    }

    public int remove() {
        if (left.size() == 0 && right.size() == 0) {
            System.out.println("Underflow");
            return -1;
        }
        if (left.size() >= right.size()) {
            return left.remove();
        } else {
            return right.remove();
        }
    }

    public int peek() {
        // write your code here
        if (left.size() == 0 && right.size() == 0) {
            System.out.println("Underflow");
            return -1;
        }
        if (left.size() >= right.size()) {
            return left.peek();
        } else {
            return right.peek();
        }
    }

    public int size() {
        // write your code here
        return left.size() + right.size();
    }
}
