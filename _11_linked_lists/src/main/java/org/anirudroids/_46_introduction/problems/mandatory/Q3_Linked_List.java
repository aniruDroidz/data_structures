package org.anirudroids._46_introduction.problems.mandatory;

public class Q3_Linked_List {
    /**
     * Problem Description
     * Design and implement a Linked List data structure.
     * A node in a linked list should have the following attributes - an integer value and a pointer to the next node.
     *
     * It should support the following operations:
     *
     * insert_node(position, value) - To insert the input value at the given position in the linked list.
     * delete_node(position) - Delete the value at the given position from the linked list.
     * print_ll() - Print the entire linked list, such that each element is followed by a single space (no trailing spaces).
     * Note:
     *
     * If an input position does not satisfy the constraint, no action is required.
     * Each print query has to be executed in a new line.
     *
     *
     * Problem Constraints
     * 1 <= value <= 105
     * 1 <= position <= n where, n is the size of the linked-list.
     *
     *
     *
     * Input Format
     * First line contains an integer denoting number of cases, let's say t. Next t line denotes the cases.
     *
     *
     * Output Format
     * When there is a case of print_ll(), Print the entire linked list, such that each element is followed by a single space.
     *
     * There should not be any trailing space.
     *
     * NOTE: You don't need to return anything.
     *
     *
     * Example Input
     * Input 1:
     * 5
     * i 1 23
     * i 2 24
     * p
     * d 1
     * p
     * Input 2:
     * 3
     * i 1 54
     * d 10
     * p
     *
     *
     * Example Output
     * Output 1:
     * 23 24
     * 24
     * Output 2:
     * 54
     *
     *
     * Example Explanation
     * Explanation 1:
     * After first two cases linked list contains two elements 23 and 24.
     * At third case print: 23 24.
     * At fourth case delete value at first position, only one element left 24.
     * At fifth case print: 24.
     * Explanation 2:
     * After the first case,  linked list contains: 54
     *
     * At second case delete value at 10th position,
     * Since the position is higher than the length of the linkedlist.
     * It does not satisfy the constraint, So no action is required.
     *
     * At third case print: 54.
     */

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    static ListNode head;
    static int length;

    public static void insert_node(int position, int value) {
        ListNode newNode = new ListNode(value);
        if(position == 1) {
            newNode.next = head;
            head = newNode;
            length++;
        } else if(position <= length+1) {
            ListNode currentNode = head;

            for(int i = 0; i< position-2; i++) {
                currentNode = currentNode.next;
            }

            newNode.next = currentNode.next;
            currentNode.next = newNode;
            length++;
        }
    }

    public static void delete_node(int position) {
        if(head == null) {
            return;
        }

        if(position == 1) {
            head = head.next;
            length--;
        } else if(position <= length) {
            ListNode currentNode = head;

            for (int i = 0; i < position-2; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            length--;
        }
    }

    public static void print_ll() {
        ListNode temp = head;

        while(temp != null) {
            if(temp==head){
                System.out.print(temp.value);
            } else {
                System.out.print(" " + temp.value);
            }
            temp = temp.next;
        }
    }


}
