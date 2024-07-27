package org.anirudroids._48_problems_doubly_linked_list.problems.mandatory;

import java.util.HashMap;
import java.util.Map;

public class Q1_Copy_List {
    /**
     * Problem Description
     * You are given a linked list A
     * Each node in the linked list contains two pointers: a next pointer and a random pointer
     * The next pointer points to the next node in the list
     * The random pointer can point to any node in the list, or it can be NULL
     * Your task is to create a deep copy of the linked list A
     * The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
     * You should create a new linked list B, where each node in B has the same value as the corresponding node in A
     * The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)
     *
     *
     * Problem Constraints
     * 0 <= |A| <= 106
     *
     *
     *
     * Input Format
     * The first argument of input contains a pointer to the head of linked list A.
     *
     *
     *
     * Output Format
     * Return a pointer to the head of the required linked list.
     *
     *
     *
     * Example Input
     * Given list
     *    1 -> 2 -> 3
     * with random pointers going from
     *   1 -> 3
     *   2 -> 1
     *   3 -> 1
     *
     *
     *
     * Example Output
     *    1 -> 2 -> 3
     * with random pointers going from
     *   1 -> 3
     *   2 -> 1
     *   3 -> 1
     *
     *
     *
     * Example Explanation
     * You should return a deep copy of the list. The returned answer should not contain the same node as the original list,
     * but a copy of them. The pointers in the returned list should not link to any node in the original input list.
     */

      class RandomListNode {
      int label;
     RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode resultHead = new RandomListNode(head.label);

        RandomListNode current = head;
        RandomListNode resultCurrent = resultHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(current != null) {
            if(current.next != null) {
                resultCurrent.next = new RandomListNode(current.next.label);
            }
            map.put(current, resultCurrent);
            resultCurrent = resultCurrent.next;
            current = current.next;
        }

        current = head;
        resultCurrent = resultHead;

        while(current != null) {
            resultCurrent.random = map.get(current.random);
            resultCurrent = resultCurrent.next;
            current = current.next;
        }

        return resultHead;
    }
}
