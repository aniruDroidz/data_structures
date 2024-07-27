package org.anirudroids._60_internal_implementation_problems;

public class _60_Internal_Implementation_Problems {

    public static void main(String[] args) {

    }
    /**
     * Given an integer array and some queries,
     * for every query you need to check if the element exists or not
     */
    private boolean[] first(int[] arr, int[] queries) {
        // Approach 1 - brute force - iterate over array, check if it is present
        // T.C. O(n*q) S.C. O(1)

        // Approach 2 - create a frequency array OR DAT - Direct Access Table - boolean[]
        // dat[i] = true = if ith element exists in A
        // dat[i] = false = if ith element doesn't exist

        // If memory limit of M is given
        // Pigeon hole principle
        // If there are N pigeons & (N-1) holes, then there will be at least one hole with more than one pigeon
        // Collision handling/resolution technique -
        // Open hashing/Chaining ---- Closed hashing-linear probing,Quadratic probing,

        //
        return new boolean[1];
    }
}
