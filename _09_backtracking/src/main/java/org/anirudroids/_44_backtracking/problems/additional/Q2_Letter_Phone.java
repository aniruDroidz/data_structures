package org.anirudroids._44_backtracking.problems.additional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q2_Letter_Phone {
    /**
     * Problem Description
     * Given a digit string A, return all possible letter combinations that the number could represent.
     *
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     *
     *
     *
     * The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
     *
     * NOTE: Make sure the returned strings are lexicographically sorted.
     *
     *
     *
     * Problem Constraints
     * 1 <= |A| <= 10
     *
     *
     *
     * Input Format
     * The only argument is a digit string A.
     *
     *
     *
     * Output Format
     * Return a string array denoting the possible letter combinations.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = "23"
     * Input 2:
     *
     *  A = "012"
     *
     *
     * Example Output
     * Output 1:
     *
     *  ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
     * Output 2:
     *
     *  ["01a", "01b", "01c"]
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  There are 9 possible letter combinations.
     * Explanation 2:
     *
     *  Only 3 possible letter combinations.
     */

    ArrayList<String> result = new ArrayList<>();

    Map<Character, String> map = new HashMap<>();

    public ArrayList<String> letterCombinations(String A) {
        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        combinations(A.toCharArray(), 0, new StringBuilder());

        return result;
    }

    private void combinations(char[] A, int index, StringBuilder builder) {
        if(builder.length() == A.length) {
            result.add(builder.toString());
            return;
        }
        char ch = A[index];

        String mapping = map.get(ch);

        for(int j = 0; j < mapping.length(); j++) {
            char ch1 = mapping.charAt(j);
            builder.append(ch1);
            combinations(A, index + 1, builder);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
