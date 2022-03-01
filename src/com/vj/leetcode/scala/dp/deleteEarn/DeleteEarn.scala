package com.vj.leetcode.scala.dp.deleteEarn

object  DeleteEarn  extends App{
println(Solution.deleteAndEarn(Array(2,2,3,3,3,4)))

  println(Solution.deleteAndEarn(Array(2,3,4)))
  //2 3 6
}
object Solution {
  def deleteAndEarn(nums: Array[Int]): Int = {
    val numbers = nums.groupBy[Int](a => a).map(a => (a._1,a._2.length)).toList.sorted
    if(numbers.length == 1) return numbers(0)._1 * numbers(0)._2
    val dp = Array.fill(numbers.length)(0)
    dp(0) = numbers(0)._1 * numbers(0)._2
    dp(1) = if(numbers(1)._1 - numbers(0)._1==1)
      Math.max(dp(0), numbers(1)._1 * numbers(1)._2) else
      dp(0) + numbers(1)._1 * numbers(1)._2
    for (i <- 2 to numbers.length-1){
        dp(i) = if(numbers(i)._1 - numbers(i-1)._1==1)
          Math.max(dp(i-2) + numbers(i)._1 * numbers(i)._2, dp(i-1)) else
          dp(i-1) + numbers(i)._1 * numbers(i)._2
    }
    dp.last
  }
}