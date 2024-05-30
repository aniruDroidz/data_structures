package org.anirudroids.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    class Q1_Free_Cars {
        /**
         * Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.
         *
         * B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
         *
         * Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.
         *
         * NOTE:
         *
         * You can start buying from time = 0.
         * Return your answer modulo 109 + 7.
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
         *  At time 0, buy car with profit 5.
         *  At time 1, buy car with profit 6.
         *  At time 2, buy car with profit 9.
         *  At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
         *  So, total profit that one can earn is 20.
         * Explanation 2:
         *
         *  At time 0, buy car with profit 3.
         *  At time 1, buy car with profit 1.
         *  At time 2, buy car with profit 7.
         *  At time 3, buy car with profit 19.
         *  We are able to buy all cars within their deadline. So, total profit that one can earn is 30.
         */
        class Item {
            int expiry;
            int profit;
            Item(int expiry, int profit) {
                this.expiry = expiry;
                this.profit = profit;
            }
        }

        public int solve(int[] A, int[] B) {
            Item[] items = new Item[A.length];
            for(int i = 0; i < A.length; i++) {
                items[i] = new Item(A[i], B[i]);
            }

            Arrays.sort(items, Comparator.comparingInt(item -> item.expiry));

            PriorityQueue<Integer> queue = new PriorityQueue<>();

            int T = 0;
            for(int index = 0; index < A.length; index++) {
                if(T < items[index].expiry) {
                    queue.add(items[index].profit);
                    T++;
                } else {
                    if(queue.peek() != null && items[index].profit > queue.peek()) {
                        queue.remove();
                        queue.add(items[index].profit);
                    }
                }
            }
            long sum = 0;
            while(!queue.isEmpty()) {
                sum += queue.poll();
            }

            return (int)(sum%1000000007);
        }
    }

    class Q2_Finish_Maximum_Jobs {
        /**
         * There are N jobs to be done, but you can do only one job at a time.
         *
         * Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
         *
         * Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
         *
         * Return the maximum number of jobs you can finish.
         *
         * Example Input
         * Input 1:
         *
         *  A = [1, 5, 7, 1]
         *  B = [7, 8, 8, 8]
         * Input 2:
         *
         *  A = [3, 2, 6]
         *  B = [9, 8, 9]
         *
         *
         * Example Output
         * Output 1:
         *
         *  2
         * Output 2:
         *
         *  1
         *
         *
         * Example Explanation
         * Explanation 1:
         *
         *  We can finish the job in the period of time: (1, 7) and (7, 8).
         * Explanation 2:
         *
         *  Since all three jobs collide with each other. We can do only 1 job.
         */
        class Item {
            int startTime;
            int endTime;

            Item(int startTime, int endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }
        }

        public int solve(int[] A, int[] B) {
            Item[] items = new Item[A.length];
            for(int i = 0; i < A.length; i++) {
                items[i] = new Item(A[i], B[i]);
            }

            Arrays.sort(items, Comparator.comparingInt(item -> item.endTime));

            int maxJobs = 1;
            int lastEndTime = items[0].endTime;
            for(int i = 1; i < A.length; i++) {
                if(items[i].startTime >= lastEndTime) {
                    maxJobs++;
                    lastEndTime = items[i].endTime;
                }
            }

            return maxJobs;
        }
    }

    class Q3_Distribute_Candy {
        /**
         * N children are standing in a line. Each child is assigned a rating value.
         *
         * You are giving candies to these children subjected to the following requirements:
         *
         * Each child must have at least one candy.
         * Children with a higher rating get more candies than their neighbors.
         * What is the minimum number of candies you must give?
         *
         * Example Input
         * Input 1:
         *
         *  A = [1, 2]
         * Input 2:
         *
         *  A = [1, 5, 2, 1]
         *
         *
         * Example Output
         * Output 1:
         *
         *  3
         * Output 2:
         *
         *  7
         *
         *
         * Example Explanation
         * Explanation 1:
         *
         *  The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
         *  So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
         * Explanation 2:
         *
         *  Candies given = [1, 3, 2, 1]
         */
        public int candy(int[] A) {
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
                    candiesRight[i] = candiesRight[i+1] + 1;
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
    }
}
