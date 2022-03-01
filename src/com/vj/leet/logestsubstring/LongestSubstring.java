package com.vj.leet.logestsubstring;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("a"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring(s.toCharArray());
    }

    private int lengthOfLongestSubstring(char[] s) {
        int maxLength = 0;
        int startPoint = 0;
        for (int i = 0; i < s.length; i++) {
            int foundIndex = find(s, startPoint,i-1,s[i]);
            if(foundIndex != -1){
                startPoint = foundIndex+1;
            } else {
                maxLength = (i - startPoint   + 1 > maxLength) ? i - startPoint   + 1 : maxLength;
            }
        }
        return maxLength;
    }

    private int find(char[] s, int stIndex, int endIndex, char value){
        for (int index = stIndex; index <= endIndex; index++){
            if(s[index] == value){
                return index;
            }
        }
        return -1;
    }
}

class Holder<Character>{
    Set<Character> chars = new HashSet<>();

    Holder(){
        chars  = new HashSet<>();
    }

}