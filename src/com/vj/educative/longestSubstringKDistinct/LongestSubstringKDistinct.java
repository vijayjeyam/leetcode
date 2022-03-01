package com.vj.educative.longestSubstringKDistinct;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        int maxlength = -1;
        Map<Character,Integer> map = new HashMap<>();
        for (int endIndex =0, startIndex =0; endIndex < str.length(); endIndex++){
            Integer count = map.getOrDefault(str.charAt(endIndex),0);
            map.put(str.charAt(endIndex),++count);
            System.out.println("Max Str: " + str.substring(startIndex,endIndex));
            while(map.size() > k){
                System.out.println(str.charAt(startIndex));
                Integer ct = map.get(str.charAt(startIndex));
                ct--;
                if( ct ==0 ){
                    map.remove(str.charAt(startIndex));
                } else {
                    map.put(str.charAt(startIndex),ct);
                }
                startIndex++;
            }
            maxlength = ((endIndex - startIndex+1) > maxlength) ? (endIndex - startIndex+1) : maxlength;

        }

        return maxlength;
    }
    public static void main(String[] args) {
        System.out.println("Answer "+findLength("araaci",1));
    }
}
