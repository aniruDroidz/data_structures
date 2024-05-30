package org.anirudroids;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class _2_Problems {

    public static void main(String[] args) {

    }

    /**
     * Given a complete binary tree with N nodes, find the number of leaf nodes.
     */
    private static void first(ArrayList<Integer> arr) {
        // Building a min heap
        for(int i = (arr.size()-1)/2; i >= 0; i--) {
            _1_Introduction.downHeapify(arr, i);
        }
    }

    /**
     * Given an integer array of size N. Sort the array using heap in-place (S.C. = O(N)).
     */
    private static void second(ArrayList<Integer> arr) {
        // 1. Build heap
        // 2.
        int j = arr.size()-1;
        while(j > 0) {
            Collections.swap(arr, 0, j);
            j--;
            // _1_Introduction.downHeapify(arr, 0, sizeOfArr = j+1);
        }
    }

    /**
     * Given an integer array of size N. Find the kth largest element.
     */
    private static void third(ArrayList<Integer> arr) {
        // Approach 1
        // Sort
        // Re

        // Approach 2
        // 1. Build a max heap
        // 2. Delete maximum k times
        // T.C. = O(N + K * log(N))

        // Approach 3
        // Get first K elements and for every element after that compare with kth largest element (min heap)
        // T.C. = O(N*log(K))
        // S.C. = O(K)
    }

    /**
     * Given an integer array of size N. Find the kth largest element,
     * for the elements from index 0 to i for all i in [0, N-1]
     */
    private void forth(ArrayList<Integer> arr, int k) {
        // Approach 1 - Max heap - not optimal
        // Approach 2 - Min heap

        ArrayList<Integer> minHeap = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            minHeap.add(arr.get(i));
            _1_Introduction.insert(minHeap, arr.get(i));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = k; i< arr.size(); i++) {
            if(arr.get(i) > minHeap.get(0)) {
                _1_Introduction.deleteMin(minHeap);
                _1_Introduction.insert(minHeap, arr.get(i));
            }
            ans.add(minHeap.get(0));
        }
    }

    /**
     * Given an infinite stream of integers. Find the median of current set of integers.
     */
    private void fifth(ArrayList<Integer> arr, int k) {
        // Always maintain a sorted dataset - (insertion)

    }
}
