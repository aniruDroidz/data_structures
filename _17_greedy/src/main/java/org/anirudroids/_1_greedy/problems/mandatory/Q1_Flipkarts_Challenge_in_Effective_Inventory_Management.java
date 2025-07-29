package org.anirudroids._1_greedy.problems.mandatory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q1_Flipkarts_Challenge_in_Effective_Inventory_Management {
    /**
     * Problem Description
     * In the recent expansion into grocery delivery, Flipkart faces a crucial challenge in effective inventory management.
     * Each grocery item on the platform carries its own expiration date and profit margin, represented by two arrays, A and B of size N.
     * A[i] denotes the time left before expiration date for the ith item, and B[i] denotes profit margin for the ith item.
     * To mitigate potential losses due to expiring items, Flipkart is seeking a strategic solution.
     *
     * The objective is to identify a method to strategically buy certain items, ensuring they are sold before their expiration date,
     * thereby maximizing overall profit. Can you assist Flipkart in developing an innovative approach to optimize their grocery inventory and
     * enhance profitability?
     *
     * Your task is to find the maximum profit one can earn by buying groceries considering that you can only buy one grocery item at a time.
     *
     * NOTE:
     *
     * You can assume that it takes 1 minute to buy a grocery item, so you can only buy the ith grocery item when the current time <= A[i] - 1.
     * You can start buying from day = 0.
     * Return your answer modulo 109 + 7.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * 1 <= A[i] <= 109
     * 0 <= B[i] <= 109
     *
     *
     *
     * Input Format
     * The first argument is an integer array A represents the deadline for buying the grocery items.
     * The second argument is an integer array B represents the profit obtained after buying the grocery items.
     *
     *
     *
     * Output Format
     * Return an integer denoting the maximum profit you can earn.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = [1, 3, 2, 3, 3]
     *  B = [5, 6, 1, 3, 9]
     * Input 2:
     *
     *  A = [3, 8, 7, 5]
     *  B = [3, 1, 7, 19]
     *
     *
     * Example Output
     * Output 1:
     *
     *  20
     * Output 2:
     *
     *  30
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  At time 0, buy item with profit 5.
     *  At time 1, buy item with profit 6.
     *  At time 2, buy item with profit 9.
     *  At time = 3 or after , you can't buy any item, as there is no item with deadline >= 4.
     *  So, total profit that one can earn is 20.
     * Explanation 2:
     *
     *  At time 0, buy item with profit 3.
     *  At time 1, buy item with profit 1.
     *  At time 2, buy item with profit 7.
     *  At time 3, buy item with profit 19.
     *  We are able to buy all items within their deadline. So, total profit that one can earn is 30.
     */

    class Pair implements Comparable<Pair> {
        private int expirationTime;
        private int profitMargin;

        public Pair(int expirationTime, int profitMargin) {
            this.expirationTime = expirationTime;
            this.profitMargin = profitMargin;
        }

        @Override
        public int compareTo(Pair p) {
            return Integer.compare(expirationTime, p.expirationTime);
        }
    }

    public int solve(int[] A, int[] B) {
        ArrayList<Pair> arrayList = new ArrayList<>();

        for(int index = 0; index < A.length; index++) {
            arrayList.add(new Pair(A[index], B[index]));
        }

        Collections.sort(arrayList);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int t = 0;
        for (Pair element : arrayList) {
            if (element.expirationTime > t) {
                pq.offer(element.profitMargin);
                t++;
            } else {
                if (!pq.isEmpty() && element.profitMargin > pq.peek()) {
                    pq.poll();
                    pq.offer(element.profitMargin);
                }
            }
        }

        long sum = 0;
        while(!pq.isEmpty()) {
            sum = (sum + pq.poll())%1000000007;
        }

        return (int) sum;
    }
}
