import java.util.*;

public class stack {
    int[] arr;
    int tos;

    public stack() {
        arr = new int[10];
        tos = -1;
    }

    public stack(int n) {
        arr = new int[n];
        tos = -1;
    }

    public int size(){
        return tos+1;
    }

    public void display() {
        for (int i = tos; i >= 0; i--) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void push(int val) {
        if (tos == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        tos++;
        arr[tos] = val;
    }

    public int pop() {
        if (tos == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = arr[tos];
        tos--;
        return val;
    }

    public int peek() {
        if (tos == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[tos];
    }

    public boolean IsEmpty(){
        return tos==-1?true:false;
    }

    public int capacity(){
        return arr.length;
    }
}