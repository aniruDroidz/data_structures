package org.anirudroids._1_greedy.problems.mandatory;

import java.util.ArrayList;
import java.util.Collections;

public class Q2_Finish_Maximum_Jobs {
    /**
     * Problem Description
     * There are N jobs to be done, but you can do only one job at a time.
     *
     * Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
     *
     * Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
     *
     * Return the maximum number of jobs you can finish.
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     *
     * 1 <= A[i] < B[i] <= 109
     *
     *
     *
     * Input Format
     * The first argument is an integer array A of size N, denoting the start time of the jobs.
     * The second argument is an integer array B of size N, denoting the finish time of the jobs.
     *
     *
     *
     * Output Format
     * Return an integer denoting the maximum number of jobs you can finish.
     *
     *
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

    class Pair implements Comparable<Pair> {
        private int startTime;
        private int endTime;

        public Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }


        @Override
        public int compareTo(Pair o) {
            return Integer.compare(endTime, o.endTime);
        }
    }

    public int solve(int[] A, int[] B) {
        ArrayList<Pair> arrayList = new ArrayList<>();

        for(int index = 0; index < A.length; index++) {
            arrayList.add(new Pair(A[index], B[index]));
        }

        Collections.sort(arrayList);

        int maxJobs = 1;
        int lastEndTime = arrayList.get(0).endTime;
        for(int index = 1; index < arrayList.size(); index++) {
            Pair element = arrayList.get(index);
            if(element.startTime >= lastEndTime) {
                maxJobs++;
                lastEndTime = arrayList.get(index).endTime;
            }
        }

        return maxJobs;
    }
}
