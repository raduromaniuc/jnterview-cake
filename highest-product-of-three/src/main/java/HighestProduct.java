import java.util.Arrays;
import java.util.PriorityQueue;

import static java.lang.Math.*;

public class HighestProduct {

    public static void main(String[] args) {

        int[] v = {5, 2, 3, 9, 10};

        System.out.println(highestProductOf3(v));
    }

    /**
     * O(n) time and O(1) space.
     *
     * a is the highest positive number of arr
     * b is the second -||-
     * c is the third -||-
     *
     * x is the lowest (probably negative) number of arr
     * y is the second -||-
     *
     * The official solution uses a very similar approach,
     * and its reading complexity stays quite the same.
     * */
    public static int highestProductOf3(int[] arr) {
        int a = max(arr[0], max(arr[1], arr[2]));
        int c = min(arr[0], min(arr[1], arr[2]));
        int b = arr[0] + arr[1] + arr[2] - a - c;

        int x = c;
        int y = b;

        for(int i = 3; i < arr.length; i++) {
            if(arr[i] < x) {
                y = x;
                x = arr[i];
            } else if(arr[i] < y) {
                y = arr[i];
            }

            if(arr[i] > a) {
                c = b;
                b = a;
                a = arr[i];
            } else if(arr[i] > b) {
                c = b;
                b = arr[i];
            } else if(arr[i] > c) {
                c = arr[i];
            }
        }

        return max(a * b * c, a * x * y);
    }
}
