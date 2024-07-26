package org.anirudroids._12_strings.problems.mandatory;

public class Q4_Longest_Palindromic_Substring {
    /**
     * Problem Description
     * Given a string A of size N, find and return the longest palindromic substring in A.
     *
     * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
     *
     * Palindrome string:
     * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
     *
     * Incase of conflict, return the substring which occurs first ( with the least starting index).
     *
     *
     *
     * Problem Constraints
     * 1 <= N <= 6000
     *
     *
     *
     * Input Format
     * First and only argument is a string A.
     *
     *
     *
     * Output Format
     * Return a string denoting the longest palindromic substring of string A.
     *
     *
     *
     * Example Input
     * Input 1:
     * A = "aaaabaaa"
     * Input 2:
     * A = "abba
     *
     *
     * Example Output
     * Output 1:
     * "aaabaaa"
     * Output 2:
     * "abba"
     *
     *
     * Example Explanation
     * Explanation 1:
     * We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
     * Explanation 2:
     * We can see that longest palindromic substring is of length 4 and the string is "abba".
     */

    public String longestPalindrome(String A) {
        char[] charArray = A.toCharArray();
        int answerLength = 1;
        String answer = A.substring(0, 1);

        // for odd elements
        for(int index = 0; index < charArray.length; index++) {
            int start = index - 1;
            int end = index + 1;

            int length = 1;
            while(start >= 0 && end < charArray.length) {
                if(charArray[start] == charArray[end]) {
                    length += 2;
                } else {
                    break;
                }
                start--;
                end++;
            }
            if(answerLength < length) {
                answerLength = length;
                answer = A.substring(start+1, end);
            }
        }

        // for even elements
        int i = 0;
        for(int j = 1; j < charArray.length; j++) {
            int start = i;
            int end = j;

            int length = 0;
            while(start >= 0 && end < charArray.length) {
                if(charArray[start] == charArray[end]) {
                    length += 2;
                } else {
                    break;
                }
                start--;
                end++;
            }
            if(answerLength < length) {
                answerLength = length;
                answer = A.substring(start+1, end);
            }
            i++;
        }

        return answer;
    }
}
