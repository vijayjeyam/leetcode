package com.vj.leetcode.scala.dp.minCostClimbingStairs

object MinCostClimbingStairs extends App{
  println(Solution.minCostClimbingStairs(Array(10,15,20)));
  println(Solution.minCostClimbingStairs(Array(1,100,1,1,1,100,1,1,100,1)));

}
object Solution {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    if(cost.length ==1) return cost(0)
    val costArr = Array.fill(cost.length)(0)
    costArr(0) = 0
    costArr(1) = Math.min(cost(0),cost(1))
    for(i <- 2 to cost.length-1){
      costArr(i) = Math.min(costArr(i-1)+cost(i), costArr(i-2)+cost(i-1))
    }
    costArr.last
  }
}