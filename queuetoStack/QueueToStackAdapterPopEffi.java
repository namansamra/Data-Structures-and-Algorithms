import java.io.*;
import java.util.*;

public class QueueToStackAdapterPopEffi {


    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapterPopEffi() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }

    int size() {
        // write your code here
        return mainQ.size();
    }

    void push(int val) {
        // write your code here
        mainQ.add(val);
    }

    int pop() {
        if (size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        while (mainQ.size() != 1) {
            helperQ.add(mainQ.remove());
        }
        int val = mainQ.remove();
        while (helperQ.size() != 0)                     // mainQ= helperQ;
                                                      // helperQueue=new ArrayDeque<>();
            mainQ.add(helperQ.remove());
        return val;
    }

    int top() {
        if (size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        while (mainQ.size() != 1) {
            helperQ.add(mainQ.remove());
        }
        int val = mainQ.remove();
        helperQ.add(val);
        while (helperQ.size() != 0)            
            mainQ.add(helperQ.remove());

        return val;
    }
}