

public class client {

    public static void main(String[] args) {
        stack st = new stack();
        dynamicstack dst=new dynamicstack();
        for (int i = 0; i < 5; i++) {
            st.push((i + 1) * 10);
        }

        st.display();
        System.out.println(st.pop());
        System.out.println(st.pop());
        st.display();

        System.out.println(st.peek());
        System.out.println(st.size());
        System.out.println(st.IsEmpty());

        for(int i=0;i<10;i++)
        {
            dst.push((i+1)*10);
        }

        dst.display();
        dst.push(198);
        dst.display();
        System.out.println(dst.size());
        System.out.println(dst.capacity());


    }
}