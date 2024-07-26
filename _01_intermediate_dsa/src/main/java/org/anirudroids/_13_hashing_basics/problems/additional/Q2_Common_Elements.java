package org.anirudroids._13_hashing_basics.problems.additional;

import java.util.HashMap;
import java.util.Map;

public class Q2_Common_Elements {
    /**
     * Problem Description
     * Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
     *
     * NOTE:
     *
     * Each element in the result should appear as many times as it appears in both arrays.
     * The result can be in any order.
     *
     *
     * Problem Constraints
     * 1 <= N, M <= 105
     *
     * 1 <= A[i] <= 109
     *
     *
     *
     * Input Format
     * First argument is an integer array A of size N.
     *
     * Second argument is an integer array B of size M.
     *
     *
     *
     * Output Format
     * Return an integer array denoting the common elements.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 2, 1]
     *  B = [2, 3, 1, 2]
     * Input 2:
     *
     *  A = [2, 1, 4, 10]
     *  B = [3, 6, 2, 10, 10]
     *
     *
     * Example Output
     * Output 1:
     *
     *  [1, 2, 2]
     * Output 2:
     *
     *  [2, 10]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
     * Explantion 2:
     *
     *  Elements (2, 10) appears in both the array.
     */

    public int[] solve(int[] A, int[] B) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        HashMap<Integer, Integer> frequencyMapA = new HashMap<>();
        HashMap<Integer, Integer> frequencyMapB = new HashMap<>();

        for (int k : A) {
            if (frequencyMapA.containsKey(k)) {
                frequencyMapA.put(k, frequencyMapA.get(k) + 1);
            } else {
                frequencyMapA.put(k, 1);
            }
        }

        int size = 0;
        for (int j : B) {
            if (frequencyMapA.containsKey(j)) {
                int valueInA = frequencyMapA.get(j);
                if (frequencyMapB.containsKey(j) && valueInA >= frequencyMapB.get(j) + 1) {
                    size++;
                    frequencyMapB.put(j, frequencyMapB.get(j) + 1);
                } else if (!frequencyMapB.containsKey(j)) {
                    size++;
                    frequencyMapB.put(j, 1);
                }
            }
        }

        int index = 0;
        int[] result = new int[size];
        for(Map.Entry<Integer, Integer> entry: frequencyMapB.entrySet()) {
            int count = entry.getValue();
            for(int i = 0; i < count; i++) {
                result[index++] = entry.getKey();
            }
        }

        return result;
    }
}
