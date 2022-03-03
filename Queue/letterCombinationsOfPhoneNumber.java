package Queue;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();

        String[] phone = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        if (digits.isBlank()) {
            return result;
        }

        result.add("");
        for (int l = 0; l < digits.length(); l++) {
            int x = Character.getNumericValue(digits.charAt(l));
            char[] chList = phone[x].toCharArray();
            while (l == result.peek().length()) {
                String frontString = result.poll();
                for (int i = 0; i < chList.length; i++) {
                    result.add(frontString + chList[i]);
                }
            }
        }
        return result;
    }
}