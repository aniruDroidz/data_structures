package org.anirudroids._30_prime_numbers.problems.mandatory;

import java.util.ArrayList;

public class Q2_Count_of_divisors {
    /**
     * Problem Description
     * Given an array of integers A, find and return the count of divisors of each element of the array.
     *
     * NOTE: The order of the resultant array should be the same as the input array.
     *
     *
     *
     * Problem Constraints
     * 1 <= length of the array <= 100000
     * 1 <= A[i] <= 106
     *
     *
     *
     * Input Format
     * The only argument given is the integer array A.
     *
     *
     *
     * Output Format
     * Return the count of divisors of each element of the array in the form of an array.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [2, 3, 4, 5]
     * Input 2:
     *
     *  A = [8, 9, 10]
     *
     *
     * Example Output
     * Output 1:
     *
     *  [2, 2, 3, 2]
     * Output 1:
     *
     *  [4, 3, 4]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
     *  So the count will be [2, 2, 3, 2].
     * Explanation 2:
     *
     *  The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
     *  So the count will be [4, 3, 4].
     */

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int max = 0;
        for (int num : A) {
            max = Math.max(num, max);
        }
        int[] spf = spf(max);

        for(int index = 0; index < A.size(); index++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int num = A.get(index);
            int count = 1;
            int smallestPrimeFactor = -1;
            while(num >= 1) {
                if(num == 1) {
                    arr.add(count);
                    break;
                }
                if(smallestPrimeFactor != -1 && smallestPrimeFactor != spf[num]) {
                    arr.add(count);
                    count = 1;
                }

                smallestPrimeFactor = spf[num];
                num = num/smallestPrimeFactor;
                count++;
            }
            int multiplication = 1;
            for (Integer integer : arr) {
                multiplication = multiplication * integer;
            }
            A.set(index, multiplication);
        }

        return A;
    }

    private int[] spf(int N) {
        int[] spf = new int[N+1];

        for(int i = 2; i <= N; i++) {
            spf[i] = i;
        }

        for(int i = 2; i*i <= N; i++) {
            if(spf[i] == i) {
                for(int j = i*i; j <= N; j=j+i) {
                    if(spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        return spf;
    }
}
