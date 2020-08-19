public class dynamicstack extends stack {

    public dynamicstack() {
        super();
    }

    public dynamicstack(int n) {
        super(n);
    }

    @Override
    public void push(int val) {
        if (super.tos == arr.length - 1) {
            int[] newarr = new int[2 * super.arr.length];
            for (int i = 0; i < super.arr.length; i++) {
                newarr[i] = super.arr[i];
            }
            super.arr = newarr;
        }
        super.push(val);
    }

}