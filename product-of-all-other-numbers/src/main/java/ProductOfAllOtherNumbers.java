import java.util.Arrays;

public class ProductOfAllOtherNumbers {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(arr)));
    }

    /**
     * O(n) execution time
     * O(n) memory consumption
     *
     * The idea is we can multiply the left side with the right side of
     * the current index. We gradually update the left side product, but
     * have to create and save the right side product vector.
     *
     * We iterate twice through the initial vector. The first iteration
     * gives us b[i], where b[i] = arr[n-1] * arr[n-2] * ... * arr[i].
     * */
    public static int[] getProductsOfAllIntsExceptAtIndex(final int[] arr) {
        int[] rightProduct = new int[arr.length];
        int n = arr.length;

        rightProduct[n - 1] = arr[n - 1];
        for(int i = n - 2; i > 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * arr[i];
        }

        int leftProduct = arr[0];
        for(int i = 1, aux; i < n - 1; i++) {
            aux = arr[i];
            arr[i] = leftProduct * rightProduct[i + 1];
            leftProduct *= aux;
        }
        arr[n - 1] = leftProduct;
        arr[0] = rightProduct[1];

        return arr;
    }
}