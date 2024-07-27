package org.anirudroids._1_arrays._20_arrays_3_interview_problems.problems.mandatory;

import java.util.ArrayList;
import java.util.Objects;

public class Q3_First_Missing_Integer {
    /**
     * Problem Description
     * Given an unsorted integer array, A of size N. Find the first missing positive integer.
     *
     * Note: Your algorithm should run in O(n) time and use constant space.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 1000000
     *
     * -109 <= A[i] <= 109
     *
     *
     *
     * Input Format
     * First argument is an integer array A.
     *
     *
     *
     * Output Format
     * Return an integer denoting the first missing positive integer.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * [1, 2, 0]
     * Input 2:
     *
     * [3, 4, -1, 1]
     * Input 3:
     *
     * [-8, -7, -6]
     *
     *
     * Example Output
     * Output 1:
     *
     * 3
     * Output 2:
     *
     * 2
     * Output 3:
     *
     * 1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * A = [1, 2, 0]
     * First positive integer missing from the array is 3.
     * Explanation 2:
     *
     * A = [3, 4, -1, 1]
     * First positive integer missing from the array is 2.
     * Explanation 3:
     *
     * A = [-8, -7, -6]
     * First positive integer missing from the array is 1.
     */

    public int firstMissingPositive(ArrayList<Integer> A) {

        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) <= A.size() && A.get(i) > 0 && A.get(i) - 1 != i) {
                while(A.get(i) > 0 && A.get(i) <= A.size() && A.get(i) - 1 != i && !Objects.equals(A.get(i), A.get(A.get(i) - 1))) {
                    int temp = A.get(A.get(i) - 1);
                    A.set(A.get(i) - 1, A.get(i));
                    A.set(i, temp);
                }
            }
        }

        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) != i + 1) {
                return i + 1;
            }
        }

        return A.size() + 1;
    }
}
