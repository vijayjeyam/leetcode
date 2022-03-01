package com.vj.leetcode.scala.dp.longestCommonSubsequence

import com.vj.leetcode.scala.TestMixin

object LongestCommonSubsequence extends App with TestMixin{
  tPrint(1){
    Solution.longestCommonSubsequence("bl","yby")
  }

  tPrint(3){
    Solution.longestCommonSubsequence("abcde","ace")
  }
  tPrint(3){
    Solution.longestCommonSubsequence("abc","abc")
  }

  tPrint(0){
    Solution.longestCommonSubsequence("abc","def")
  }
  tPrint(6){
    Solution.longestCommonSubsequence("vijayjeyam","vijyjm")
  }

}
object Solution {
  def longestCommonSubsequence(text1: String, text2: String): Int = {
    val memo = Array.ofDim[Int](text1.length,text2.length)
    val fLen = text1.length
    val sLen = text2.length
    def dp(fStrInd:Int, sStrIndex:Int): Int ={
      if(fStrInd == -1 || sStrIndex == -1){
        return 0
      }
      val res = memo(fStrInd)(sStrIndex)
      if(res == 0){
        if(text1.charAt(fStrInd) == text2.charAt(sStrIndex)){
          memo(fStrInd)(sStrIndex) = 1 + dp(fStrInd-1,sStrIndex-1)
        } else {
          memo(fStrInd)(sStrIndex) = Math.max(
            dp(fStrInd-1,sStrIndex),
            dp(fStrInd,sStrIndex-1)
          )
        }
      }
      memo(fStrInd)(sStrIndex)
    }
    dp(fLen-1,sLen-1)
  }
}