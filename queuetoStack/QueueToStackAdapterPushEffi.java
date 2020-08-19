import java.io.*;       //PUSH EFFICIENT************************************************8
import java.util.*;
import java.util.Queue;

public class QueueToStackAdapterPushEffi {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapterPushEffi() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }

    int size() {
        // write your code here
        return mainQ.size();
    }

    void push(int val) {
        helperQ.add(val);

        while (mainQ.size() != 0) {
            helperQ.add(mainQ.remove());
        }

        mainQ = helperQ;
        helperQ = new ArrayDeque<>();
    }

    int pop() {
        // write your code here
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        return mainQ.remove();
    }

    int top() {
        // write your code here
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        return mainQ.peek();
    }
}