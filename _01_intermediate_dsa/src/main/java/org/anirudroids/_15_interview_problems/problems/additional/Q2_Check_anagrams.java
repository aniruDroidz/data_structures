package org.anirudroids._15_interview_problems.problems.additional;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Q2_Check_anagrams {
    /**
     * Problem Description
     * You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.
     *
     * Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.
     *
     *
     * Problem Constraints
     * 1 <= N <= 105
     * A and B are lowercase strings
     *
     *
     * Input Format
     * Both arguments A and B are a string.
     *
     *
     * Output Format
     * Return 1 if they are anagrams and 0 if not
     *
     *
     * Example Input
     * Input 1:
     * A = "cat"
     * B = "bat"
     * Input 2:
     * A = "secure"
     * B = "rescue"
     *
     *
     * Example Output
     * Output 1:
     * 0
     * Output 2:
     * 1
     *
     *
     * Example Explanation
     * For Input 1:
     * The words cannot be rearranged to form the same word. So, they are not anagrams.
     * For Input 2:
     * They are an anagram.
     */

    public int solve(String A, String B) {
        char[] charArrayA = A.toCharArray();
        char[] charArrayB = B.toCharArray();

        if(charArrayA.length != charArrayB.length) {
            return 0;
        }
        HashMap<Character, Long> frequencyMapA = new HashMap<>();
        HashMap<Character, Long> frequencyMapB = new HashMap<>();

        for (char ch : charArrayA) {
            if (frequencyMapA.containsKey(ch)) {
                frequencyMapA.put(ch, frequencyMapA.get(ch) + 1L);
            } else {
                frequencyMapA.put(ch, 1L);
            }
        }

        for (char ch : charArrayB) {
            if (frequencyMapB.containsKey(ch)) {
                frequencyMapB.put(ch, frequencyMapB.get(ch) + 1L);
            } else {
                frequencyMapB.put(ch, 1L);
            }
        }

        for(Map.Entry<Character, Long> entry: frequencyMapA.entrySet()) {
            if(!Objects.equals(entry.getValue(), frequencyMapB.get(entry.getKey()))) {
                return 0;
            }
        }


        for(Map.Entry<Character, Long> entry: frequencyMapB.entrySet()) {
            if(!Objects.equals(entry.getValue(), frequencyMapA.get(entry.getKey()))) {
                return 0;
            }
        }

        return 1;
    }
}
