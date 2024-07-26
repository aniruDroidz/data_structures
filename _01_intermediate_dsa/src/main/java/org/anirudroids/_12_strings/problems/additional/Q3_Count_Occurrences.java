package org.anirudroids._12_strings.problems.additional;

public class Q3_Count_Occurrences {
    /**
     * Problem Description
     * Find the number of occurrences of bob in string A consisting of lowercase English alphabets.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 1000
     *
     *
     * Input Format
     * The first and only argument contains the string A, consisting of lowercase English alphabets.
     *
     *
     * Output Format
     * Return an integer containing the answer.
     *
     *
     * Example Input
     * Input 1:
     *
     *   "abobc"
     * Input 2:
     *
     *   "bobob"
     *
     *
     * Example Output
     * Output 1:
     *
     *   1
     * Output 2:
     *
     *   2
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *   The only occurrence is at second position.
     * Explanation 2:
     *
     *   Bob occures at first and third position.
     */

    public int solve(String A) {
        int count = 0;
        for(int index = 0; index + 2 < A.length(); index++) {
            String substring = A.substring(index, index + 3);
            if(substring.equals("bob")) {
                count++;
            }
        }
        return count;
    }
}
