package org.anirudroids._48_problems_doubly_linked_list.problems.mandatory;

import java.util.HashMap;
import java.util.Map;

public class Q2_LRU_Cache {
    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
     * The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
     *
     * Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
     *
     * NOTE: If you are using any global variables, make sure to clear them in the constructor.
     *
     * Example :
     *
     * Input :
     *          capacity = 2
     *          set(1, 10)
     *          set(5, 12)
     *          get(5)        returns 12
     *          get(1)        returns 10
     *          get(10)       returns -1
     *          set(6, 14)    this pushes out key = 5 as LRU is full.
     *          get(5)        returns -1
     */

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public Q2_LRU_Cache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);

            insert(temp);

            return temp.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);
        }

        if(map.size() == capacity) {
            remove(head.next);
        }

        Node newNode = new Node(key, value);
        insert(newNode);
    }

    private void remove(Node node) {
        map.remove(node.key);

        Node tempPrevious = node.prev;
        Node tempNext = node.next;

        tempPrevious.next = tempNext;
        tempNext.prev = tempPrevious;

        node.next = null;
        node.prev = null;
    }

    private void insert(Node node) {
        map.put(node.key, node);

        Node temp = tail.prev;

        node.prev = temp;
        node.next = tail;

        temp.next = node;
        tail.prev = node;
    }
}
