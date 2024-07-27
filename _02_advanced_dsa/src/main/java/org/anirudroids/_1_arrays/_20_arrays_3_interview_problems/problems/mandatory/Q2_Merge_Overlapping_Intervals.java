package org.anirudroids._1_arrays._20_arrays_3_interview_problems.problems.mandatory;

import java.util.ArrayList;
import java.util.Comparator;

public class Q2_Merge_Overlapping_Intervals {
    /**
     * Problem Description
     * Given a collection of intervals, merge all overlapping intervals.
     *
     *
     *
     * Problem Constraints
     * 1 <= Total number of intervals <= 100000.
     *
     *
     *
     * Input Format
     * First argument is a list of intervals.
     *
     *
     *
     * Output Format
     * Return the sorted list of intervals after merging all the overlapping intervals.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * [1,3],[2,6],[8,10],[15,18]
     *
     *
     * Example Output
     * Output 1:
     *
     * [1,6],[8,10],[15,18]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Merge intervals [1,3] and [2,6] -> [1,6].
     * so, the required answer after merging is [1,6],[8,10],[15,18].
     * No more overlapping intervals present.
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

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        ArrayList<Interval> result = new ArrayList<>();

        int currentStart = intervals.get(0).start;
        int currentEnd = intervals.get(0).end;

        for(int index = 1; index < intervals.size(); index++) {
            if(intervals.get(index).start <= currentEnd) {
                currentStart = Math.min(currentStart, intervals.get(index).start);
                currentEnd = Math.max(currentEnd, intervals.get(index).end);
            } else {
                Interval interval = new Interval(currentStart, currentEnd);
                result.add(interval);

                currentStart = intervals.get(index).start;
                currentEnd = intervals.get(index).end;
            }
        }

        Interval interval = new Interval(currentStart, currentEnd);

        result.add(interval);

        return result;
    }
}
