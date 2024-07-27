package org.anirudroids._1_introduction;

import java.util.ArrayList;

public class _1_Introduction {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /**
     * Given an integer array represents the length of N ropes
     * In one operation you can connect two ropes.
     * Cost of connecting 2 ropes = Sum of length of both ropes
     * Find the min cost to connect all ropes
     */
    private static void first(ArrayList<Integer> arr) {

    }

    public static void insert(ArrayList<Integer> heap, int value) {
        heap.add(value);
        upHeapify(heap, value);
    }

    static void upHeapify(ArrayList<Integer> A, int index) {
        int parent = (index -1)/2;
        while(index != 0 && A.get(parent) > A.get(index)) {
            int temp = A.get(parent);
            A.set(parent, A.get(index));
            A.set(index, temp);

            index = parent;
            parent = (index - 1)/2;
        }
    }

    public static void deleteMin(ArrayList<Integer> heap) {
        int temp = heap.get(heap.size() - 1);
        heap.set(heap.size() - 1, heap.get(0));
        heap.set(0, temp);

        heap.remove(heap.size() - 1);
        downHeapify(heap, 0);
    }

    public static void downHeapify(ArrayList<Integer> heap, int index) {
        int n = heap.size();

        int leftChildIndex = 2*index+1;
        int rightChildIndex = 2*index+2;

        while(leftChildIndex < n) {
            if(rightChildIndex == n) {
                if(heap.get(index) > heap.get(leftChildIndex)) {
                    int temp = heap.get(index);
                    heap.set(index, heap.get(leftChildIndex));
                    heap.set(leftChildIndex, temp);
                }
                break;
            }

            if(heap.get(leftChildIndex) < heap.get(index) && heap.get(leftChildIndex) <= heap.get(rightChildIndex)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(leftChildIndex));
                heap.set(leftChildIndex, temp);

                index = leftChildIndex;
                leftChildIndex = 2*index + 1;
                rightChildIndex = 2*index + 2;
            } else if(heap.get(rightChildIndex) < heap.get(index) && heap.get(rightChildIndex) < heap.get(leftChildIndex)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(rightChildIndex));
                heap.set(rightChildIndex, temp);

                index = rightChildIndex;
                leftChildIndex = 2*index + 1;
                rightChildIndex = 2*index + 2;
            } else {
                break;
            }
        }
    }
}