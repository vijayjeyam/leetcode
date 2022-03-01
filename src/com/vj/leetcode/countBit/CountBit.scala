package com.vj.leetcode.countBit

import com.vj.leetcode.scala.TestMixin

object CountBit extends TestMixin{
  tPrint(31){Solution.hammingWeight(-3)}
  tPrint(32){Solution.hammingWeight(-1)}
tPrint(1){Solution.hammingWeight(1)}

}
object Solution {
  // you need treat n as an unsigned value
  def hammingWeight(n: Int): Int = {
    def hamWtP(n:Int,mask:Int=1,count:Int=0) : Int = n match {
      case any if (mask < 0) => count + (if(n<0) 1 else 0)
      case others if((n & mask) != 0) => hamWtP(n,mask << 1, count+1)
      case _ => hamWtP(n,mask << 1, count)
    }
    hamWtP(n)
  }
}
