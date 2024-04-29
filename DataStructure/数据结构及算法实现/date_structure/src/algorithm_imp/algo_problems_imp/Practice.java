package algorithm_imp.algo_problems_imp;


import sun.misc.Queue;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Practice {
    public static void main(String[] args) throws InterruptedException {
        Practice practice = new Practice();
        //1
        int[] children = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        int[] joseph = practice.joseph(children, k);
    }

    //1. 约瑟夫环问题
    //队列解决问题
    public int[] joseph(int[] children, int k) throws InterruptedException {
        Queue<Integer> integerQueue = new Queue<>();
        for (int i = 0; i < children.length; i++) {
            integerQueue.enqueue(children[i]);
        }
        int[] ret = new int[children.length];
        int index = 0;
        int count = 0;
        while (!integerQueue.isEmpty()) {
            Integer dequeue = integerQueue.dequeue();
            count++;
            if (count % 3 == 0) {
                ret[index++] = dequeue;
            } else {
                integerQueue.enqueue(dequeue);
            }
        }
        return ret;
    }
    //2 中缀表达式计算问题 (以理解)

}
