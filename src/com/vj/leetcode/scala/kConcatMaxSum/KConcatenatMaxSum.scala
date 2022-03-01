package com.vj.leetcode.scala.kConcatMaxSum

import com.vj.leetcode.scala.TestMixin

object KConcatenatMaxSum extends TestMixin{
  tPrint(5){
    Solution.kConcatenationMaxSum(Array(-5,4,-4,-3,5,-3),3)
  }

  tPrint(2){
    Solution.kConcatenationMaxSum(Array(1,-2,1),5)
  }
}

object Solution {
  def kConcatenationMaxSum(arr: Array[Int], k: Int): Int = {
    val adjust = arr.sorted.head match {
      case num if num < 0 =>  num
      case num => 0
    }

    (arr.reduce(_+_) * k) -adjust   match {
      case num if num >= 0 => num
      case others => 0
    }

  }
}