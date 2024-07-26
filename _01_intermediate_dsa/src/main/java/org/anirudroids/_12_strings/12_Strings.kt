/**
 * H.W. - Find the difference b/w a character Array & a String in your language.
 *      - Why Strings are immutable in Java, C#, Python, JS, Go etc - https://www.scaler.com/topics/why-string-is-immutable-in-java/
 * ASCII.... A - 65, B - 66.... Z - 90.... a - 97, b - 98.... z - 122
 */

fun main() {
    // printLowercaseToUpperAndUppercaseToLower("Hello World".toCharArray())
    // checkIfSubstringIsPalindrome("anamadamspe".toCharArray(), 3, 7)
    print(findLengthOfLongestPalindromeSubstring("anamadamspe".toCharArray()))
}

fun findLengthOfLongestPalindromeSubstring(s: CharArray): Int {
    // Brute force
    var ans = 0
    for(i in 0 until s.size) {
        for(j in i until s.size) {
            if(checkIfSubstringIsPalindrome(s, i, j)) {
                val length = j - i + 1
                if(ans < length) {
                    ans = length
                }
            }
        }
    }

    //return ans

    // Optimised version
    // For odd elements
    var ans1 = 0

    for(i in s.indices) {
        var start = i - 1
        var end = i + 1
        var length = 1
        while (start >= 0 && end < s.size) {
            if(s[start] == s[end]) {
                length += 2
            } else break
            start--
            end++
        }
        if(ans1 < length) {
            ans1 = length
        }
    }

    // For even elements
    var i = 0
    for(j in 1 until s.size) {
        var start = i
        var end = j
        var length = 0
        while (start >= 0 && end < s.size) {
            if(s[start] == s[end]) {
                length += 2
            } else break
            start--
            end++
        }
        if(ans1 < length) {
            ans1 = length
        }
        i++
    }

    return ans1
}

fun checkIfSubstringIsPalindrome(string: CharArray, l: Int, r: Int): Boolean {
    var start = l
    var end = r
    while(start < end) {
        if(string[start] != string[end]) {
            return false
        }
        start++;
        end--;
    }
    return true
}

fun printLowercaseToUpperAndUppercaseToLower(arr: CharArray) {
    for(ch in arr) {
        if(ch > 91.toChar()) print((ch - 32))
        else print(ch + 32)
    }
}