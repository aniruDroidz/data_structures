package org.anirudroids._30_prime_numbers.problems.mandatory;

import java.util.ArrayList;
import java.util.Arrays;

public class Q1_Find_All_Primes {
    /**
     * Problem Description
     * Given an integer A. Find the list of all prime numbers in the range [1, A].
     *
     *
     * Problem Constraints
     * 1 <= A <= 106
     *
     *
     *
     * Input Format
     * Only argument A is an integer.
     *
     *
     *
     * Output Format
     * Return a sorted array of prime number in the range [1, A].
     *
     *
     *
     * Example Input
     * Input 1:
     * A = 7
     * Input 2:
     * A = 12
     *
     *
     * Example Output
     * Output 1:
     * [2, 3, 5, 7]
     * Output 2:
     * [2, 3, 5, 7, 11]
     *
     *
     * Example Explanation
     * For Input 1:
     * The prime numbers from 1 to 7 are 2, 3, 5 and 7.
     * For Input 2:
     * The prime numbers from 1 to 12 are 2, 3, 5, 7 and 11.
     */

    public ArrayList<Integer> solve(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] arr = new boolean[A+1];

        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for(int index = 2; index*index <= A; index++) {
            if(arr[index]) {
                for(int j = index*index; j <= A; j = j+index) {
                    arr[j] = false;
                }
            }
        }

        for(int index = 0; index < arr.length; index++) {
            if(arr[index]) {
                result.add(index);
            }
        }

        return result;
    }
}
