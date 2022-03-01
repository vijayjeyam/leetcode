package com.vj.leetcode.scala.dp.countingbits

object CountingBits extends App {
  println(Solution.countBits(16).mkString(","))
}
object Solution {
  def countBits(n: Int): Array[Int] = {
    var dp = (0 to n ).toArray
    dp.zipWithIndex.map{
      case (a,ind) if ind < 2  =>
      case (a,index) => {
        dp(index) = dp(getIndex(index)) + 1
      }
    }
    dp
  }
  def getIndex(num:Int):Int = {
    if(num <2 ) return num;
    def getIndex(num:Int,acc:Int):Int = {
      if (acc * 2 > num) return num - acc;
      else getIndex(num, acc * 2)
    }
    getIndex(num,2)
  }
}