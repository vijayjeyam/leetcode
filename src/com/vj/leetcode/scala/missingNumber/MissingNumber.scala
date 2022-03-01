package com.vj.leetcode.scala.missingNumber

import com.vj.leetcode.scala.TestMixin

object MissingNumber extends TestMixin{
tPrint(2){
  Solution.missingElement(Array(1,3),1)
}
  tPrint(2){
    Solution.missingElement(Array(1),1)
  }

  tPrint(5){
    Solution.missingElement(Array(4,7,9,10),1)
  }
  tPrint(8){
    Solution.missingElement(Array(4,7,9,10),3)
  }
  tPrint(6){
    Solution.missingElement(Array(1,2,4),3)
  }
}
object Solution {
  def missingElement(nums: Array[Int], k: Int): Int = {
    def missing(lastNum:Int,remaining:List[Int] ,missCount:Int ):Int = (missCount,remaining) match {
      case (a,head :: tail) if(a==k) => lastNum
      case (_,head :: tail) if(head - lastNum   == 1) => missing(head,tail,missCount)
      case (_,head :: tail) if(head - lastNum  > 1) => missing(lastNum+1,remaining,missCount+1)
      case (_,Nil) => lastNum+(k-missCount)
    }
    if(nums.length == 0) {
      k
    } else {
      missing(nums(0)-1,nums.toList,0)
    }
  }
}