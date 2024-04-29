import java.util.Arrays;
import java.util.Scanner;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class GetPageNums {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getPageNums(new Scanner(System.in).nextInt())));
    }


    public static int[] getPageNums(int page) {
        int[] count = new int[10];
        for (int i = 1; i <= page; i++) {
            int tPage = i;
            while (tPage != 0) {
                count[tPage % 10]++;
                tPage /= 10;
            }
        }
        return count;
    }

    public static int[] getPageNums2(int pageNumber) {
        return null;
    }
}
