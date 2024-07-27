package org.anirudroids._29_combinatorics_basics.problems.additional;

public class Q2_Sorted_Permutation_Rank_with_Repeats {
    /**
     * Problem Description
     * Given a string A, find the rank of the string amongst its permutations sorted lexicographically.
     *
     * Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations.
     *
     * Look at the example for more details.
     *
     * NOTE:
     *
     * The answer might not fit in an integer, so return your answer % 1000003 where 1000003 is a prime number.
     * String A can consist of both lowercase and uppercase letters. Characters with lesser ASCII values are considered smaller, i.e., 'a' > 'Z'.
     *
     *
     * Problem Constraints
     * 1 <= len(A) <= 1000000
     *
     *
     *
     * Input Format
     * First argument is a string A.
     *
     *
     *
     * Output Format
     * Return an integer denoting the rank.
     *
     *
     *
     * Example Input
     * Input 1:
     *
     *  A = "aba"
     * Input 2:
     *
     *  A = "bca"
     *
     *
     * Example Output
     * Output 1:
     *
     *  2
     * Output 2:
     *
     *  4
     *
     *
     * Example Explanation
     * Explanation 1:
     *
     *  The order permutations with letters 'a', 'a', and 'b' :
     *     aab
     *     aba
     *     baa
     *  So, the rank is 2.
     * Explanation 2:
     *
     *  The order permutations with letters 'a', 'b', and 'c' :
     *     abc
     *     acb
     *     bac
     *     bca
     *     cab
     *     cba
     *  So, the rank is 4.
     */

    private int mod = 1000003;
    static long fac(long n)
    {
        if (n == 0 || n == 1)
            return 1;
        return n * fac(n - 1);
    }

    public int findRank(String A) {
        long n = A.length();

        long t_count = 1;

        for (int i = 0; i < n; i++)
        {
            long less_than = 0;
            for (int j = i + 1; j < n; j++)
            {
                if (A.charAt(i)
                        > A.charAt(j))
                {
                    less_than += 1;
                }
            }

            long[] d_count = new long[52];

            for (int j = i; j < n; j++)
            {
                if ((A.charAt(j) >= 'A')
                        && A.charAt(j) <= 'Z')
                    d_count[A.charAt(j) - 'A'] += 1;
                else
                    d_count[A.charAt(j) - 'a' + 26] += 1;
            }

            long d_fac = 1;
            for (long ele : d_count)
                d_fac *= fac(ele);

            t_count += (fac(n - i - 1)
                    * less_than) / d_fac;
        }
        return (int)t_count%mod;
    }
}
