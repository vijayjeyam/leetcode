package com.vj.educative.longestSubstringKDistinct;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class NoRepeatSubstring {
    public static int findLength(String str) {
        Map<Character,Integer> map = new HashMap<>();
        int maxLength = -1;
        for(int startIndex =0, endIndex=0; endIndex < str.length(); endIndex++){
            startIndex = Optional.ofNullable(map.put(str.charAt(endIndex),endIndex)).map( oldKey ->   oldKey+1 ).orElse(startIndex);
            maxLength = maxLength < endIndex - startIndex + 1 ? endIndex - startIndex + 1 : maxLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength("abccde"));
    }
}
