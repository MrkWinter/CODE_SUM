package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class ArrayStack {
}

class Stack {
    private int maxSize;
    private int[] stack;
    private int top = -1;
    //初始化为-1容易判断栈是否为空

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
    public void  push() {

    }
    public int pop() {
        return 1;
        //运行时异常不用捕获 较方便
    }
    public void list() {

    }

}