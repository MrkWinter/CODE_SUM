package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */

/**
 * 2.队列
 */
public class ArrayQueue {
    public static void main(String[] args) {
        ArrayQue arrayQue = new ArrayQue(12);
        arrayQue.addQueue(1);
        System.out.println(arrayQue.isEmpty());
        System.out.println(arrayQue.isFull());
        System.out.println(arrayQue.getNumber());
        System.out.println(arrayQue.getQueue());
        arrayQue.addQueue(1);
        System.out.println(arrayQue.peek());

    }
}

//数组实现队列
class ArrayQue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        if ((rear + 1) % maxSize == front) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        int result = arr[front];
        front = (front + 1) % maxSize;
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return arr[front];
    }

    public int getNumber() {
        return (rear - front + maxSize) % maxSize;
    }
}

