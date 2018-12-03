import java.util.Arrays;

public class MissingNumber {
    /** The basic idea is to use XOR operation.
    We all know that a^b^b =a, which means two xor operations with the same number
    will eliminate the number and reveal the original number.
    In this solution, I apply XOR operation to both the index and value of the array.
    In a complete array with no missing numbers, the index and value should be perfectly
    corresponding( nums[index] = index), so in a missing array, what left finally is the missing number. **/

    public static int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    public static void main(String[] main) {
        int[] input = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(input));

    }
}
