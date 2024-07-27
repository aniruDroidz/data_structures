package org.anirudroids._47_sorting_and_detecting_loop.problems.additional;

public class Q3_Reorder_List {
    /**
     * Problem Description
     * Given a singly linked list A
     *
     *  A: A0 → A1 → … → An-1 → An
     * reorder it to:
     *
     *  A0 → An → A1 → An-1 → A2 → An-2 → …
     * You must do this in-place without altering the nodes' values.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 106
     *
     *
     *
     * Input Format
     * The first and the only argument of input contains a pointer to the head of the linked list A.
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
     *  A = [1, 2, 3, 4, 5]
     * Input 2:
     *
     *  A = [1, 2, 3, 4]
     *
     *
     * Example Output
     * Output 1:
     *
     *  [1, 5, 2, 4, 3]
     * Output 2:
     *
     *  [1, 4, 2, 3]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The array will be arranged to [A0, An, A1, An-1, A2].
     * Explanation 2:
     *
     *  The array will be arranged to [A0, An, A1, An-1, A2].
     */

      class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode middleNode = A;
        ListNode fast = A;

        while (fast.next != null && fast.next.next != null) {
            middleNode = middleNode.next;
            fast = fast.next.next;
        }

        ListNode first = A;
        ListNode second = middleNode.next;
        middleNode.next = null;

        ListNode prev = null;
        ListNode current = second;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second = prev;
        int i = 1;
        current = A;

        while (first != null && second != null) {
            if (i % 2 == 1) {
                first = first.next;
                current.next = second;
            } else {
                second = second.next;
                current.next = first;
            }

            current = current.next;
            i++;
        }

        return A;
    }
}
