package org.anirudroids._1_arrays._17_arrays_1_one_diamentional.problems.additional;

import java.util.Arrays;
import java.util.Collections;

public class Q1_Add_One_To_Number {
    /**
     * Problem Description
     * Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
     *
     * The digits are stored such that the most significant digit is at the head of the list.
     *
     * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
     *
     * Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
     * A: For the purpose of this question, YES
     * Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
     * A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
     *
     *
     * Problem Constraints
     * 1 <= size of the array <= 1000000
     *
     *
     *
     * Input Format
     * First argument is an array of digits.
     *
     *
     *
     * Output Format
     * Return the array of digits after adding one.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * [1, 2, 3]
     *
     *
     * Example Output
     * Output 1:
     *
     * [1, 2, 4]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Given vector is [1, 2, 3].
     * The returned vector should be [1, 2, 4] as 123 + 1 = 124.
     */

    public int[] plusOne(int[] A) {
        Integer[] arr = new Integer[A.length + 1];
        arr[0] = 0;

        for(int index = 1; index <= A.length; index++) {
            arr[index] = A[index-1];
        }

        Collections.reverse(Arrays.asList(arr));

        int carry = 1;
        int index = 0;
        while(carry != 0) {
            int d = arr[index] + carry;
            arr[index] = d;
            if(d >= 10) {
                arr[index] = d%10;
            }
            carry = d/10;
            index++;
        }

        int trailingZerosCount = 0;
        for(int i = arr.length - 1; i >=0; i--)  {
            if(arr[i] == 0) {
                trailingZerosCount++;
            } else {
                break;
            }
        }
        int[] result = new int[arr.length - trailingZerosCount];
        for(int i = arr.length - 1 - trailingZerosCount; i >=0; i--)  {
            result[i] = arr[arr.length - 1 - trailingZerosCount - i];
        }

        return result;
    }
}
