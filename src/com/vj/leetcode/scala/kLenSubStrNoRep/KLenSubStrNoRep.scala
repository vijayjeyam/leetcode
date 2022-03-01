package com.vj.leetcode.scala.kLenSubStrNoRep

import com.vj.leetcode.scala.TestMixin

object KLenSubStrNoRep extends TestMixin{
  tPrint(3){Solution.numKLenSubstrNoRepeats("abab",2)}
  tPrint(6){Solution.numKLenSubstrNoRepeats("havefunonleetcode",5)}
  tPrint(1){Solution.numKLenSubstrNoRepeats("hello",3)}
  tPrint(0){Solution.numKLenSubstrNoRepeats("home",5)}




}

object Solution {
  def numKLenSubstrNoRepeats(s: String, k: Int): Int = {
    def numKLenSubStr(matches:Int, stInd:Int,endInt:Int, winSize: Int): Int = {

      if( endInt >= s.length ) return {
         if(endInt-stInd == k ) matches+1
         else matches
      }
      if(endInt - stInd == k) {
         numKLenSubStr(matches+1, stInd + 1,endInt, winSize-1)
      } else
      if(s.substring(stInd,endInt).contains(s.charAt(endInt))){
         val matchesAt = s.substring(stInd,endInt).indexOf(s.charAt(endInt))
         numKLenSubStr(matches, stInd + matchesAt +1 ,endInt+1, winSize-matchesAt-1)
      } else {
        numKLenSubStr(matches,stInd,endInt+1, winSize+1)
      }
    }
    numKLenSubStr(0,0,0,0)
  }

}

