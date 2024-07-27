package org.anirudroids._46_introduction.problems.mandatory;

public class Q1_Palindrome_List {
    /**
     * Problem Description
     * Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 105
     *
     *
     *
     * Input Format
     * The first and the only argument of input contains a pointer to the head of the given linked list.
     *
     *
     *
     * Output Format
     * Return 0, if the linked list is not a palindrome.
     *
     * Return 1, if the linked list is a palindrome.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = [1, 2, 2, 1]
     * Input 2:
     *
     * A = [1, 3, 2]
     *
     *
     * Example Output
     * Output 1:
     *
     *  1
     * Output 2:
     *
     *  0
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
     * Explanation 2:
     *
     *  The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].
     */




     class ListNode {
         public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }
      }

    public int lPalin(ListNode A) {
        int length = 1;
        ListNode current = A;
        while(current.next != null) {
            length++;
            current = current.next;
        }

        current = A;
        ListNode previousNode = null;
        for(int i = 0; i < length/2; i++) {
            ListNode temp = current.next;
            current.next = previousNode;
            previousNode = current;
            current = temp;
        }
        if(length % 2 != 0) {
            current = current.next;
        }
        while(previousNode != null) {
            if(current.val != previousNode.val) {
                return 0;
            }
            current = current.next;
            previousNode = previousNode.next;
        }

        return 1;
    }
}
