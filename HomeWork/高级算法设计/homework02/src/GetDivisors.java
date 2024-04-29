import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class GetDivisors {
    public static void main(String[] args) {
        List<Integer> divisors = getDivisors(10);
        System.out.println(divisors);
        int[] divisorMultiple = getDivisorMultiple(3, 9);
        System.out.println(Arrays.toString(divisorMultiple));
    }


    public static List<Integer> getDivisors(int num) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0 && !ret.contains(i)) {
                ret.add(i);
                if (i != num / i) {
                    ret.add(num / i);
                }
            }
        }
        return ret;
    }

    public static int[] getDivisorMultiple(int num1, int num2) {
        int[] ret = new int[2];
        if (num1 > num2) {
            num1 = num1 ^ num2;
            num2 = num1 ^ num2;
            num1 = num1 ^ num2;
        }
        for (int i = 1; i <= num1; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                ret[0] = i;
            }
        }
        for (int i = num2; i <= num1 * num2; i++) {
            if (i % num1 == 0 && i % num2 == 0) {
                ret[1] = i;
                break;
            }
        }
        return ret;
    }

    public static int[] getDivisorMultiple1(int num1, int num2) {
        int[] ret = new int[2];
        ret[0] = gcd(num1, num2);
        ret[1] = lcm(num1, num2);
        return ret;
    }

    private static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }

    private static int lcm(int num1, int num2) {
        return num1 * num2 / gcd(num1, num2);
    }

}
