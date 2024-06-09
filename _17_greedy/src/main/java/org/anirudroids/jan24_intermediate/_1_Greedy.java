package org.anirudroids.jan24_intermediate;

import java.util.*;

public class _1_Greedy {
    public static void main(String[] args) {

    }

    class Pair implements Comparable<Pair> {
        private int expirationTime;
        private int profitMargin;

        public Pair(int expirationTime, int profitMargin) {
            this.expirationTime = expirationTime;
            this.profitMargin = profitMargin;
        }


        @Override
        public int compareTo(Pair o) {
            return Integer.compare(expirationTime, o.expirationTime);
        }
    }

    /**
     * Flipkart Grocery Services.
     * A -> Expiration time of the each item
     * B -> Profit gained by each item
     */
    public void maximizeTheProfit(int[] a, int[] b) {
        // 1. Sort with respect to time
        // 2. t = 0
        Queue<Integer> q;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int t = 0;
        for(int index = 0; index < a.length; index++) {
            if(a[index] > t) {
                pq.offer(b[index]);
                t++;
            } else {
                if(!pq.isEmpty() && b[index] > pq.peek()) {
                    pq.poll();
                    pq.offer(b[index]);
                }
            }
        }
        
        //remove all elements from heap and return their sum

        //T.C. = O(nlogn)
        //S.c. = O(n)
    }

    /**
     * Candy Distribution
     * There are N children with marks. Teacher has to give candies to them based on below conditions,
     * 1. Every child must have at least 1 candy
     * 2. Children with higher marks than its neighbours must have more candies than its neighbours
     * Find min no. of candies to do this.
     */
    public void candyDistribution(int[] a) {
        // 1. For all children no. of candies >= 1
        // 2. if(A[i] > A[i-1]) {
        //      c[i] = c[i-1] + 1;
        //    }
        // 3. if(A[i] > A[i+1]) {
        //      c[i] = max(c[i], c[i+1] + 1);
        // }

        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 1);

        for(int index = 1; index < a.length; index++) {
            if(a[index] > a[index-1]) {
                arr.set(index, arr.get(index-1) + 1);
            }
        }
        int ans = a[a.length-1];
        for(int index = a.length-2; index >= 0; index++) {
            if(a[index] > a[index+1]) {
                arr.set(index, arr.get(index+1) + 1);
            }
            ans += arr.get(index);
        }

        // return ans
        // T.C. = O(n)
        // S.C. = O(n)
    }

    /**
     * Maximum jobs
     * Given n jobs with start and end times
     * Find maximum jobs that can be completed if only one job can be done at a time.
     */
    public int maximumJobs(int[] starts, int[] ends) {
        // 1. Sort on the basis of end time
        // 2.
        int ans = 1;
        int lastEndTime = ends[0];

        for(int i = 1; i < ends.length; i++) {
            if(starts[i] >= lastEndTime) {
                ans++;
                lastEndTime = ends[i];
            }
        }

        return ans;
    }
}
