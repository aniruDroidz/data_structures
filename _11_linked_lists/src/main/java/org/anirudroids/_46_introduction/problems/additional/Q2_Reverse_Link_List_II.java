package org.anirudroids._46_introduction.problems.additional;

public class Q2_Reverse_Link_List_II {
    /**
     * Problem Description
     * Reverse a linked list A from position B to C.
     *
     * NOTE: Do it in-place and in one-pass.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 106
     *
     * 1 <= B <= C <= |A|
     *
     *
     *
     * Input Format
     * The first argument contains a pointer to the head of the given linked list, A.
     *
     * The second arugment contains an integer, B.
     *
     * The third argument contains an integer C.
     *
     *
     *
     * Output Format
     * Return a pointer to the head of the modified linked list.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = 1 -> 2 -> 3 -> 4 -> 5
     *  B = 2
     *  C = 4
     *
     * Input 2:
     *
     *  A = 1 -> 2 -> 3 -> 4 -> 5
     *  B = 1
     *  C = 5
     *
     *
     * Example Output
     * Output 1:
     *
     *  1 -> 4 -> 3 -> 2 -> 5
     * Output 2:
     *
     *  5 -> 4 -> 3 -> 2 -> 1
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
     *  Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
     * Explanation 2:
     *
     *  In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
     *  Thus, the output is 5 -> 4 -> 3 -> 2 -> 1
     */

      class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
      }

    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null || A.next == null) return A;

        ListNode dummy = new ListNode(0);
        dummy.next = A;

        ListNode prev = dummy;
        for (int i = 1; i < B; i++) {
            prev = prev.next;
        }
        ListNode current = prev.next;
        for (int i = 1; i <= C - B; i++) {
            ListNode temp = prev.next;
            prev.next = current.next;
            current.next = current.next.next;
            prev.next.next = temp;
        }
        return dummy.next;
    }
}
