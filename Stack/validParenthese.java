// https://leetcode.com/problems/valid-parentheses/
package Stack;

import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currBracket = s.charAt(i);
            if (currBracket == '(' || currBracket == '[' || currBracket == '{') {
                stack.add(currBracket);
            } else {
                if (stack.isEmpty())
                    return false;
                char lastBracket = stack.peek();
                switch (lastBracket) {
                    case '(':
                        if (currBracket == ')') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case '[':
                        if (currBracket == ']') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case '{':
                        if (currBracket == '}') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                }
            }
        }

        return stack.isEmpty();

    }
}
