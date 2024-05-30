package org.anirudroids;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _1_Greedy {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    private static class Item {
        int expiry;
        int profit;

        Item(int expiry, int profit) {
            this.expiry = expiry;
            this.profit = profit;
        }
    }

    public static void first(ArrayList<Integer> A, ArrayList<Integer> B) {
        // A = [1,3,3,3,5,5,5,8]
        // B = [5,2,7,1,4,3,8,1]

        Item[] items = new Item[A.size()];

        for(int index = 0; index < A.size(); index++) {
            items[index] = new Item(A.get(index), B.get(index));
        }
        //Use comparator to sort on the basis of expiry time

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int maxExpiryTime = A.get(A.size()-1);
        int T = 0;
        for(int index = 0; index < maxExpiryTime; index++) {
            if(T < items[index].expiry) {
                queue.add(items[index].profit);
                T++;
            } else {
                if(items[index].profit > queue.peek()) {
                    queue.remove();
                    queue.add(items[index].profit);
                }
            }
        }

        // Iterate over heap & calculate sum of all items
    }

    /**
     *
     */
    public static int second(int[] A) {
        int[] candiesLeft = new int[A.length];

        candiesLeft[0] = 1;
        for(int i = 1; i < A.length; i++) {
            if(A[i] > A[i-1]) {
                candiesLeft[i] = candiesLeft[i-1] + 1;
            } else {
                candiesLeft[i] = 1;
            }
        }

        int[] candiesRight = new int[A.length];
        candiesRight[A.length-1] = 1;
        for(int i = A.length-2; i >=0; i--) {
            if(A[i] > A[i+1]) {
                candiesRight[i] = candiesRight[i-1] + 1;
            } else {
                candiesRight[i] = 1;
            }
        }

        // iterate from 0 to n, take max from candiesLeft & candiesRight for every index and take the sum
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += Math.max(candiesLeft[i], candiesRight[i]);
        }

        return sum;
    }

    /**
     * Give N jobs, with start and end time. Find the maximum no. of jobs that can be completed if only one
     * job can be done at a time.
     */
    public static int third(int[] startTimes, int[] endTimes) {
        int maxJobs = 1;

        // Solution
        // 1. Sort based on end time
        // 2. iterate and select jobs if start time of current job is greater than or equal to previous job

        int lastEndTime = endTimes[0];

        for(int i = 1; i < endTimes.length; i++) {
            if(startTimes[i] >= lastEndTime) {

            }
        }
        return maxJobs;
    }
}