import java.util.Stack;

// public class minStack { //mycode
//     Stack<Integer> st;
//     Stack<Integer> minst; // this stack only contains dreasing or equal value from bottom to top thus
//                           // minimum is always at peek();
//     int min = Integer.MAX_VALUE;

//     public minStack() {
//         st = new Stack<>();
//         minst = new Stack<>();
//     }

//     public int size() {
//         return st.size();
//     }

//     public void push(int val) {
//         st.push(val);
//         if (val <= min) {
//             minst.push(val);
//             min = val;
//         }
//     }

//     public int pop() {
//         if (size() == 0) {
//             System.out.println("Stack underflow");
//             return -1;
//         }

//         int val = st.pop();
//         if (val == minst.peek()) {
//             minst.pop();
//             min = minst.size() != 0 ? minst.peek() : Integer.MAX_VALUE;
//         }
//         return val;
//     }

//     public int min() {
//         if (size() == 0) {
//             System.out.println("Stack underflow");
//             return -1;
//         }

//         return min;
//     }

//     public int peek() {
//         if (size() == 0) {
//             System.out.println("Stack underflow");
//             return -1;
//         }
//         return st.peek();
//     }

//     public boolean IsEmpty() {
//         if (st.size() == 0) {
//             return true;
//         }

//         return false;
//     }

// }

public class minStack { // SUMEET sir's code without min and thus no need to maintain min just minst.peek();
    Stack<Integer> st;
    Stack<Integer> minst; // this stack only contains dreasing or equal value from bottom to top thus
                          // minimum is always at peek();

    public minStack() {
        st = new Stack<>();
        minst = new Stack<>();
    }

    public int size() {
        return st.size();
    }

    public void push(int val) {
        st.push(val);
        if (minst.size() == 0 || val <= minst.peek()) {
            minst.push(val);
        }
    }

    public int pop() {
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }

        int val = st.pop();
        if (val == minst.peek()) {
            minst.pop();
        }
        return val;
    }

    public int min() {
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }

        return minst.peek();
    }

    public int peek() {
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        return st.peek();
    }

    public boolean IsEmpty() {
        if (st.size() == 0) {
            return true;
        }

        return false;
    }


    public static class minStack2 {//WITH CONSTANT SPACE AND TIME WE USE ENCRIPTION DECRIPTION
        Stack<Integer> st;
        int min;

        public minStack2() {
            st = new Stack<>();
        }

        int size() {
            return st.size();

        }

        void push(int val) {
            // write your code here
            if (st.size() == 0) {
                st.push(val);
                min = val;
            } else if (val >= min) {
                st.push(val);
            } else {
                st.push(val + val - min);
                min = val;
            }
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {

                if (st.peek() >= min) {
                    return st.pop();

                } else {
                    int val = min;
                    min = 2 * min - st.pop();
                    return val;
                }
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                if (st.peek() >= min) {
                    return st.peek();
                } else {
                    return min; //as we have changed min to val when we have push encrypted value;
                }
            }
        }

        int min() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return min;
        }
    }

}