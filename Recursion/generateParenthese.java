// https://leetcode.com/problems/generate-parentheses/submissions/
package Recursion;

import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        getBracketes(n, n, "");
        return result;
    }

    void getBracketes(int openBracket, int closeBracket, String s) {
        if (closeBracket == 0 && openBracket == 0) {
            result.add(s);
        }

        // open new bracket
        if (openBracket > 0) {
            getBracketes(openBracket - 1, closeBracket, s + '(');
        }

        // close bracket
        if (closeBracket > 0 && openBracket < closeBracket) {
            getBracketes(openBracket, closeBracket - 1, s + ')');
        }
    }
}
