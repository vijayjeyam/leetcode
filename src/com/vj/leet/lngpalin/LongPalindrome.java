package com.vj.leet.lngpalin;

public class LongPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(
                "aacabdkacaa"));
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int strLen = s.length();
        if(strLen > 1000) throw new RuntimeException("Not supported");
        char[] tocheck = s.toCharArray();
        String palin = "";
        for (int i = 0; i < tocheck.length ; i++) {
            if(palin.length() != 0 && palin.length() >= tocheck.length-i) break;
            int index = findLastIndex(tocheck, i,tocheck.length-1,tocheck[i]);
            while(index >= 0 && index > i){
                if(checkPalondrome(tocheck, i , index)){
                    break;
                }
                index = findLastIndex(tocheck, i,index - 1,tocheck[i]);
            }
            if(index >= 0 && (index - i +1) > palin.length()){
                 palin = s.substring(i,index+1);
            }
        }
        return palin;
    }
    private int findLastIndex(char[] toCheck, int startIndex, int endIndex, char toFind){
        for (int i = endIndex ; i >= startIndex; i--) {
            if(toCheck[i] == toFind) return i;
        }
        return -1;
    }

    private boolean checkPalondrome(char[] toCheck, int startIndex, int endIndex){
        if(startIndex > endIndex) return true;
        return toCheck[startIndex] == toCheck[endIndex] ? checkPalondrome(toCheck,startIndex+1,endIndex-1) : false;
    }
}