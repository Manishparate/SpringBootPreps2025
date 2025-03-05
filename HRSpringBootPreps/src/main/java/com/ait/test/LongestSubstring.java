package com.ait.test;
import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        String name = "satishparwateoxztb";
        System.out.println(longestSubstringWithoutRepeating(name));
    }

    public static String longestSubstringWithoutRepeating(String str) {
        Set<Character> set = new HashSet<>();
        int start = 0, maxLength = 0, maxStart = 0;
        
        for (int end = 0; end < str.length(); end++) {
            while (set.contains(str.charAt(end))) {
                set.remove(str.charAt(start++));
            }
            set.add(str.charAt(end));

            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxStart = start;
            }
        }
        
        return str.substring(maxStart, maxStart + maxLength);
    }
}
