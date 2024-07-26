package org.anirudroids._12_strings.problems.additional;

public class Q1_Longest_Common_Prefix {
    /**
     * Problem Description
     * Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.
     *
     * The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
     *
     * Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
     *
     *
     *
     * Problem Constraints
     * 0 <= sum of length of all strings <= 1000000
     *
     *
     *
     * Input Format
     * The only argument given is an array of strings A.
     *
     *
     *
     * Output Format
     * Return the longest common prefix of all strings in A.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     * A = ["abcdefgh", "aefghijk", "abcefgh"]
     * Input 2:
     *
     * A = ["abab", "ab", "abcd"];
     *
     *
     * Example Output
     * Output 1:
     *
     * "a"
     * Output 2:
     *
     * "ab"
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     * Longest common prefix of all the strings is "a".
     * Explanation 2:
     *
     * Longest common prefix of all the strings is "ab".
     */

    public String longestCommonPrefix(String[] A) {
        String result = "";
        for(int j = 0; j < A[0].length(); j++) {
            String substring = A[0].substring(0, j + 1);
            boolean commonPrefix = true;
            for(int index = 1; index < A.length; index++) {
                String string = A[index];
                if(!string.startsWith(substring)) {
                    commonPrefix = false;
                }
            }
            if(commonPrefix) {
                result = substring;
            }
        }
        return result;
    }
}
