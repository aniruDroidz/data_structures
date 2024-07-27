package org.anirudroids._1_arrays._20_arrays_3_interview_problems.problems.mandatory;

import org.anirudroids._1_arrays._20_arrays_3_interview_problems.Interval;

import java.util.ArrayList;

public class Q1_Merge_Intervals {
    /**
     * Problem Description
     * You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).
     *
     * You may assume that the intervals were initially sorted according to their start times.
     *
     *
     *
     * Problem Constraints
     * 0 <= |intervals| <= 105
     *
     *
     *
     * Input Format
     * First argument is the vector of intervals
     *
     * second argument is the new interval to be merged
     *
     *
     *
     * Output Format
     * Return the vector of intervals after merging
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
     * Input 2:
     *
     * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
     *
     *
     * Example Output
     * Output 1:
     *
     *  [ [1, 5], [6, 9] ]
     * Output 2:
     *
     *  [ [1, 9] ]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * (2,5) does not completely merge the given intervals
     * Explanation 2:
     *
     * (2,6) completely merges the given intervals
     */

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }

        if(newInterval.end < intervals.get(0).start) {
            result.add(newInterval);
        }

        for(int index = 0; index < intervals.size(); index++) {
            int l = intervals.get(index).start;
            int r = intervals.get(index).end;

            if(newInterval.start > r) {
                result.add(new Interval(l, r));
            } else if(l > newInterval.end) {
                result.add(new Interval(newInterval.start, newInterval.end));

                for(int j = index; j < intervals.size(); j++) {
                    result.add(new Interval(intervals.get(j).start, intervals.get(j).end));
                }
                return result;
            } else {
                newInterval.start = Math.min(l, newInterval.start);
                newInterval.end = Math.max(r, newInterval.end);
            }
        }

        result.add(new Interval(newInterval.start, newInterval.end));

        return result;
    }
}
