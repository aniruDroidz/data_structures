package org.anirudroids._47_sorting_and_detecting_loop.problems.mandatory;

public class Q3_Sort_List {
    /**
     * Problem Description
     * Sort a linked list, A in O(n log n) time.
     *
     *
     *
     * Problem Constraints
     * 0 <= |A| = 105
     *
     *
     *
     * Input Format
     * The first and the only arugment of input contains a pointer to the head of the linked list, A.
     *
     *
     *
     * Output Format
     * Return a pointer to the head of the sorted linked list.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [3, 4, 2, 8]
     * Input 2:
     *
     * A = [1]
     *
     *
     * Example Output
     * Output 1:
     *
     * [2, 3, 4, 8]
     * Output 2:
     *
     * [1]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
     * Explanation 2:
     *
     *  The sorted form of [1] is [1].
     */

      class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

    public ListNode sortList(ListNode A) {
        if(A == null || A.next == null) {
            return A;
        }

        ListNode slow = A;
        ListNode fast = A;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode next = mid.next;
        mid.next = null;

        ListNode h1 = sortList(A);
        ListNode h2 = sortList(next);

        return merge(h1, h2);
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode head;
        if(h1.val <= h2. val) {
            head = h1;
            h1 = h1.next;
        } else {
            head = h2;
            h2 = h2.next;
        }

        ListNode temp = head;
        while(h1 != null && h2 != null) {
            if(h1.val <= h2. val) {
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }

        if(h1 == null) {
            temp.next = h2;
        } else {
            temp.next = h1;
        }

        return head;
    }
}
