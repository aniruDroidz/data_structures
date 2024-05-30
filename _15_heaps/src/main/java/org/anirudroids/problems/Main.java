package org.anirudroids.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
     * Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.
     *
     * Find and return the array C.
     *
     * NOTE:
     *
     * If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
     * If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 2, 5, 4, 3]
     * Input 2:
     *
     *  A = [5, 17, 100, 11]
     *
     *
     * Example Output
     * Output 1:
     *
     *  [1, 1, 2, 2, 3]
     * Output 2:
     *
     *  [5, 5, 17, 11]
     *
     *  Example Explanation
     * Explanation 1:
     *
     *  stream          median
     *  [1]             1
     *  [1, 2]          1
     *  [1, 2, 5]       2
     *  [1, 2, 5, 4]    2
     *  [1, 2, 5, 4, 3] 3
     * Explanation 2:
     *
     *  stream          median
     *  [5]              5
     *  [5, 17]          5
     *  [5, 17, 100]     17
     *  [5, 17, 100, 11] 11
     */
    class Q3_Running_Median
    {
        public ArrayList<Integer> solve(ArrayList<Integer> A) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(int i = 0; i < A.size(); i++) {
                minHeap.offer(A.get(i));

                if(minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                } else if(!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(minHeap.poll());
                }

                A.set(i, maxHeap.peek());
            }

            return A;
        }
    }

    class Q1_K_Places_Apart {
        /**
         * N people having different priorities are standing in a queue.
         *
         * The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
         *
         * Your task is to sort the queue in the increasing order of priorities.
         *
         * NOTE:
         *
         * No two persons can have the same priority.
         * Use the property of the queue to sort the queue with complexity O(NlogB).
         *
         * Example Input
         * Input 1:
         *
         *  A = [1, 40, 2, 3]
         *  B = 2
         * Input 2:
         *
         *  A = [2, 1, 17, 10, 21, 95]
         *  B = 1
         *
         *
         * Example Output
         * Output 1:
         *
         *  [1, 2, 3, 40]
         * Output 2:
         *
         *  [1, 2, 10, 17, 21, 95]
         *
         *
         * Example Explanation
         * Explanation 1:
         *
         *  Given array A = [1, 40, 2, 3]
         *  After sorting, A = [1, 2, 3, 40].
         *  We can see that difference between initial position of elements amd the final position <= 2.
         * Explanation 2:
         *
         *  After sorting, the array becomes [1, 2, 10, 17, 21, 95].
         */
        public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            ArrayList<Integer> result = new ArrayList<>();
            for (Integer integer : A) {
                priorityQueue.offer(integer);
            }

            while(!priorityQueue.isEmpty()){
                result.add(priorityQueue.poll());
            }

            return result;
        }
    }
}
