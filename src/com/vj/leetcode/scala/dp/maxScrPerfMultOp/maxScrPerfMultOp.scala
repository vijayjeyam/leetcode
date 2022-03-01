package com.vj.leetcode.scala.dp.maxScrPerfMultOp

import com.vj.leetcode.scala.TestMixin

//Maximum Score from Performing Multiplication Operations
object MaxScrPerfMultOp extends App with TestMixin{
tPrint(102){
  Solution.maximumScore(Array(-5,-3,-3,-2,7,1),Array(-10,-5,3,4,6))
}
  tPrint(14){
    Solution.maximumScore(Array(1,2,3),Array(3,2,1))
  }

}
object Solution {
  def maximumScore(nums: Array[Int], multipliers: Array[Int]): Int = {
    val acc:Array[Array[Int]]  = Array.ofDim[Int](nums.length,multipliers.length)
    def maxScr(currentCount:Int, left:Int): Int ={
      if(currentCount == multipliers.length) return 0;
      val right = acc.length-1 -(currentCount-left)
      val mul = multipliers(currentCount)
      if(acc(currentCount)(left) == 0){
        acc(currentCount)(left) = Math.max((mul * nums(left) + maxScr( currentCount+1, left+1)),
          (mul * nums(right)   + maxScr( currentCount+1, left))
        )
      }
      acc(currentCount)(left)
    }
    maxScr(0,0)
  }

}