package org.anirudroids._46_introduction.problems.additional;

public class Q4_Remove_Nth_Node_from_List_End {
    /**
     * Problem Description
     * Given a linked list A, remove the B-th node from the end of the list and return its head.
     * For example, given linked list: 1->2->3->4->5, and B = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     *
     * NOTE: If B is greater than the size of the list, remove the first node of the list.
     *
     * Try doing it using constant additional space.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 106
     *
     *
     * Input Format
     * The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.
     *
     *
     * Output Format
     * Return the head of the linked list after deleting the B-th element from the end.
     *
     *
     * Example Input
     * Input 1:
     * A = 1->2->3->4->5
     * B = 2
     * Input 2:
     * A = 1
     * B = 1
     *
     *
     * Example Output
     * Output 1:
     * 1->2->3->5
     * Output 2:
     *
     */

      class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        if(A == null) {
            return A;
        }
        ListNode first = A;
        ListNode second = A;

        int i = 0;
        while(first != null) {
            if(i>B) {
                second = second.next;
            }
            i++;
            first = first.next;
        }

        if(second == A) {
            return second.next;
        }
        if(second.next != null) {
            second.next = second.next.next;
        }
        return A;
    }
}
