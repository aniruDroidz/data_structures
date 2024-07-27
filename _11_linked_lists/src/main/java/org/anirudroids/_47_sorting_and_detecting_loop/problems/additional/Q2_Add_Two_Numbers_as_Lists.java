package org.anirudroids._47_sorting_and_detecting_loop.problems.additional;

public class Q2_Add_Two_Numbers_as_Lists {
    /**
     * Problem Description
     * You are given two linked lists, A and B, representing two non-negative numbers.
     *
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     *
     * Add the two numbers and return it as a linked list.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A|, |B| <= 105
     *
     *
     *
     * Input Format
     * The first argument of input contains a pointer to the head of linked list A.
     *
     * The second argument of input contains a pointer to the head of linked list B.
     *
     *
     *
     * Output Format
     * Return a pointer to the head of the required linked list.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *
     *  A = [2, 4, 3]
     *  B = [5, 6, 4]
     * Input 2:
     *
     *
     *  A = [9, 9]
     *  B = [1]
     *
     *
     * Example Output
     * Output 1:
     *
     *
     *  [7, 0, 8]
     * Output 2:
     *
     *
     *  [0, 0, 1]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  A = 342 and B = 465. A + B = 807.
     * Explanation 2:
     *
     *  A = 99 and B = 1. A + B = 100.
     */

     class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        if(A == null) {
            return B;
        }
        if(B == null) {
            return A;
        }

        if((B.val == 0 && B.next == null)) {
            return A;
        }
        if((A.val == 0 && A.next == null)) {
            return B;
        }

        ListNode firstCurr = A;
        ListNode secondCurr = B;

        ListNode resultHead = null;
        ListNode resultCurr = null;

        int carry = 0;
        while(firstCurr != null && secondCurr != null) {
            int sum = firstCurr.val + secondCurr.val + carry;
            if(sum/10 > 0) {
                carry = sum/10;
                sum = sum%10;
            } else {
                carry = 0;
            }

            ListNode node = new ListNode(sum);
            if(resultHead == null) {
                resultHead = node;
                resultCurr = resultHead;
            } else {
                resultCurr.next = node;
                resultCurr = resultCurr.next;
            }
            firstCurr = firstCurr.next;
            secondCurr = secondCurr.next;
        }

        ListNode remaining;
        if(firstCurr != null) {
            remaining = firstCurr;
        } else {
            remaining = secondCurr;
        }

        while(remaining != null) {
            int sum = remaining.val + carry;
            if(sum/10 > 0) {
                carry = sum/10;
                sum = sum%10;
            } else {
                carry = 0;
            }

            resultCurr.next = new ListNode(sum);
            resultCurr = resultCurr.next;
            remaining = remaining.next;
        }

        if(carry > 0) {
            resultCurr.next = new ListNode(carry);
        }

        return resultHead;
    }
}
