package com.vj.leetcode.scala.dp.maxScrPerfMulOpr

class MaxiScorePerfMulOperation {
  Solution.maximumScore(Array(1,2,3), multipliers = Array(3,2,1))
}
object Solution {
  def maximumScore(nums: Array[Int], multipliers: Array[Int]): Int = {
    val dp = Array.fill(multipliers.length)(0)
    dp(0) = nums(0)*multipliers(0)
    dp(1) = Math.max(nums(0)*multipliers(0)+nums(1)*multipliers(1),nums(1)*multipliers(0)+nums(0)*multipliers(1))
    0
  }
}