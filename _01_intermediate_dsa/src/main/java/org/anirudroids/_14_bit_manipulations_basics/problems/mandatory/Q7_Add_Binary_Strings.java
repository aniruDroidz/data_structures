package org.anirudroids._14_bit_manipulations_basics.problems.mandatory;

public class Q7_Add_Binary_Strings {
    /**
     * Problem Description
     * Given two binary strings A and B. Return their sum (also a binary string).
     *
     *
     * Problem Constraints
     * 1 <= length of A <= 105
     *
     * 1 <= length of B <= 105
     *
     * A and B are binary strings
     *
     *
     *
     * Input Format
     * The two argument A and B are binary strings.
     *
     *
     *
     * Output Format
     * Return a binary string denoting the sum of A and B
     *
     *
     *
     * Example Input
     * Input 1:
     * A = "100"
     * B = "11"
     * Input 2:
     * A = "110"
     * B = "10"
     *
     *
     * Example Output
     * Output 1:
     * "111"
     * Output 2:
     * "1000"
     *
     *
     * Example Explanation
     * For Input 1:
     * The sum of 100 and 11 is 111.
     * For Input 2:
     *
     * The sum of 110 and 10 is 1000.
     */

    public String addBinary(String A, String B) {
        int gap = Math.abs(A.length() - B.length());

        if(A.length() < B.length()) {
            char[] aChars = new char[gap+A.length()];
            for(int index = 0; index < gap; index++) {
                aChars[index] = '0';
            }

            for(int index = gap; index < aChars.length; index++) {
                aChars[index] = A.charAt(index - gap);
            }

            A = new String(aChars);
        } else if(A.length() > B.length()) {
            char[] bChars = new char[gap+B.length()];
            for(int index = 0; index < gap; index++) {
                bChars[index] = '0';
            }

            for(int index = gap; index < bChars.length; index++) {
                bChars[index] = B.charAt(index - gap);
            }

            B = new String(bChars);
        }

        char[] sum = new char[B.length()];

        int carry = 0;
        int reminder;
        for(int index = A.length() - 1; index >= 0; index--) {
            int aInt = Character.getNumericValue(A.charAt(index));
            int bInt = Character.getNumericValue(B.charAt(index));

            int addition = carry + aInt + bInt;

            carry = addition/2;
            reminder = addition%2;
            sum[index] = (char)(reminder + '0');
        }

        char[] answer;
        if(carry == 1) {
            answer = new char[sum.length + 1];
            answer[0] = (char)(carry + '0');
            System.arraycopy(sum, 0, answer, 1, sum.length);
        } else {
            answer = sum;
        }
        return new String(answer);
    }
}
