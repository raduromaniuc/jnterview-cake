import org.junit.Assert;
import org.junit.Test;

public class TestProductOfAllOtherNumbers {

    @Test
    public void testRandomIntArrays() {
        for(int i = 0; i < 10; i++) {
            int[] arr = getRandomIntArray();
            Assert.assertArrayEquals(
                    getExpectedProducts(arr),
                    ProductOfAllOtherNumbers.getProductsOfAllIntsExceptAtIndex(arr)
            );
        }
    }

    @Test
    public void testNegative() {
        int[] arr = {1, 2, -3, 4};

        Assert.assertArrayEquals(
                getExpectedProducts(arr),
                ProductOfAllOtherNumbers.getProductsOfAllIntsExceptAtIndex(arr)
        );
    }

    @Test
    public void testZero() {
        int[] arr = {1, 2, 3, 0, 4};

        Assert.assertArrayEquals(
                getExpectedProducts(arr),
                ProductOfAllOtherNumbers.getProductsOfAllIntsExceptAtIndex(arr)
        );
    }


    /**
     * Brute-forces the solution for testing
     * purposes, in O(n^2).
     * */
    public int[] getExpectedProducts(int[] arr) {
        int[] res = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            res[i] = 1;

            for(int j = 0; j < arr.length; j++) {
                if(i != j) {
                    res[i] *= arr[j];
                }
            }
        }

        return res;
    }

    public int[] getRandomIntArray() {
        int length = (int) (Math.random() * 100);
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        return arr;
    }
}
