package org.anirudroids.problems;

import java.util.Arrays;
import java.util.HashMap;

public class AdditionalProblems {

    /**
     * Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
     * For the elements not present in B, append them at last in sorted order.
     *
     * Return the array A after sorting from the above method.
     *
     * NOTE: Elements of B are unique.
     *
     * Example Input
     * Input 1:
     *
     * A = [1, 2, 3, 4, 5, 4]
     * B = [5, 4, 2]
     * Input 2:
     *
     * A = [5, 17, 100, 11]
     * B = [1, 100]
     *
     *
     * Example Output
     * Output 1:
     *
     * [5, 4, 4, 2, 1, 3]
     * Output 2:
     *
     * [100, 5, 11, 17]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Since 2, 4, 5, 4 of A are present in the array B.  So Maintaining the relative order of B.
     * Thus, [5, 4, 4, 2] and appending the remaining element (1, 3) in sorted order.
     *
     * The Final array is [5, 4, 4, 2, 1, 3]
     * Explanation 2:
     *
     * Since 100 of A are present in the array B.  So Maintaining the relative order of B.
     * Thus, [100] and appending the remaining element (5, 11, 17) in sorted order.
     *
     * The Final array is [100, 5, 11, 17]
     */
    class Q1_Sort_Array_in_given_Order {
        public int[] solve(int[] A, int[] B) {
            HashMap<Integer, Integer> frequencyMap = new HashMap<>();

            for(int i = 0; i < B.length; i++) {
                frequencyMap.put(B[i], 0);
            }

            for(int i = 0; i < A.length; i++) {
                if(frequencyMap.containsKey(A[i])) {
                    frequencyMap.put(A[i], frequencyMap.get(A[i])+1);
                }
            }

            int[] result = new int[A.length];
            int index = 0;
            for(int i = 0; i < B.length; i++) {
                for(int j = 0; j < frequencyMap.get(B[i]); j++) {
                    result[index++] = B[i];
                }
            }

            Arrays.sort(A);
            for(int i = 0; i < A.length; i++) {
                if(!frequencyMap.containsKey(A[i])) {
                    result[index++] = A[i];
                }
            }

            return result;
        }
    }

    /**
     * N Mice and N holes are placed in a straight line. Each hole can accommodate only one mouse.
     *
     * The positions of Mice are denoted by array A, and the position of holes is denoted by array B.
     *
     * A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consume 1 minute.
     *
     * Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
     *
     * Example Input
     * Input 1:
     *
     *  A = [-4, 2, 3]
     *  B = [0, -2, 4]
     * Input 2:
     *
     *  A = [-2]
     *  B = [-6]
     *
     *
     * Example Output
     * Output 1:
     *
     *  2
     * Output 2:
     *
     *  4
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  Assign the mouse at position (-4 to -2), (2 to 0) and (3 to 4).
     *  The number of moves required will be 2, 2 and 1 respectively.
     *  So, the time taken will be 2.
     * Explanation 2:
     *
     *  Assign the mouse at position -2 to -6.
     *  The number of moves required will be 4.
     *  So, the time taken will be 4.
     */
    public class Q3_Assign_Mice_to_Holes {

        class Item {
            int micePosition;
            int holePosition;
            public Item(int micePosition, int holePosition) {
                this.micePosition = micePosition;
                this.holePosition = holePosition;
            }
        }

        public int mice(int[] A, int[] B) {
            Arrays.sort(A);
            Arrays.sort(B);

            Item[] items = new Item[A.length];
            for(int i = 0; i < items.length; i++) {
                items[i] = new Item(A[i], B[i]);
            }

            int result = 0;
            for (Item item : items) {
                int difference = Math.abs(Math.max(item.micePosition, item.holePosition) - Math.min(item.micePosition, item.holePosition));
                result = Math.max(result, difference);
            }

            return result;
        }
    }

}
