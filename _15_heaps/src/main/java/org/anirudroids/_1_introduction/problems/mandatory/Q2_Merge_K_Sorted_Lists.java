package org.anirudroids._1_introduction.problems.mandatory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2_Merge_K_Sorted_Lists {
    /**
     * Problem Description
     * Given a list containing head pointers of N sorted linked lists.
     * Merge these given sorted linked lists and return them as one sorted list.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= total number of elements in given linked lists <= 100000
     * <p>
     * <p>
     * <p>
     * Input Format
     * The first and only argument is a list containing N head pointers.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return a pointer to the head of the sorted linked list after merging all the given linked lists.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * 1 -> 10 -> 20
     * 4 -> 11 -> 13
     * 3 -> 8 -> 9
     * Input 2:
     * <p>
     * 10 -> 12
     * 13
     * 5 -> 6
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
     * Output 2:
     * <p>
     * 5 -> 6 -> 10 -> 12 ->13
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
     * Explanation 2:
     * <p>
     * The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
     */

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(h -> h.val));

        queue.addAll(a);

        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while (!queue.isEmpty()) {
            ListNode minimum = queue.poll();
            temp.next = minimum;
            temp = temp.next;
            if (minimum.next != null) {
                queue.add(minimum.next);
            }
        }

        return result.next;
    }
}
