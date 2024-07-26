package org.anirudroids._15_interview_problems.problems.mandatory;

public class Q1_Length_of_longest_consecutive_ones {
    /**
     * Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
     *
     *
     * Input Format
     *
     * The only argument given is string A.
     * Output Format
     *
     * Return the length of the longest consecutive 1’s that can be achieved.
     * Constraints
     *
     * 1 <= length of string <= 1000000
     * A contains only characters 0 and 1.
     * For Example
     *
     * Input 1:
     *     A = "111000"
     * Output 1:
     *     3
     *
     * Input 2:
     *     A = "111011101"
     * Output 2:
     *     7
     */

    public int solve(String A) {
        char[] charArray = A.toCharArray();
        int totalOnes = 0;

        for(char ch: charArray) {
            if(ch == '1'){
                totalOnes++;
            }
        }

        if(totalOnes == charArray.length) {
            return totalOnes;
        }

        int answer = 0;
        for(int index = 0; index < charArray.length; index++) {
            if(charArray[index] == '0') {
                int l = 0;
                for(int j = index-1; j >= 0; j--) {
                    if(charArray[j] == '0') {
                        break;
                    }
                    l++;
                }

                int r = 0;
                for(int j = index+1; j < charArray.length; j++) {
                    if(charArray[j] == '0') {
                        break;
                    }
                    r++;
                }
                int count = 0;
                int sum = l + r;
                if(sum == totalOnes) {
                    count = l + r;
                } else if(l + r < totalOnes) {
                    count = l + r + 1;
                }

                if(answer < count) {
                    answer = count;
                }
            }
        }

        return answer;
    }
}
