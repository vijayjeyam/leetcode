package com.vj.leetcode.scala.dp.houserobber

object HouseRobber extends App{
println(Solution.rob(Array(114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240)))
}
object SolutionTop {
  def rob(nums: Array[Int]): Int = {
    val cache = Array.fill(nums.length)(-1)
    def rob(door:Int) : Int = door match {
      case 0 => nums(0)
      case 1 => Math.max(nums(0),nums(1))
      case others => {
        cache(others) match {
          case -1 => cache( others) = Math.max(rob(others-1),rob(others-2)+nums(others));cache( others)
          case robVal => robVal
        }

      }
    }
    rob(nums.length-1)
  }

}

object Solution {
  def rob(nums: Array[Int]): Int = {
    if(nums.length ==1) return nums(0)
    val cache = Array.fill(nums.length)(-1)
    cache(0) = nums(0)
    cache(1) = Math.max(nums(0),nums(1))
    for(index <- 2 to nums.length-1){
      cache(index) = Math.max( cache(index-1), cache(index-2)+nums(index))
    }
    cache(nums.length-1)
    }
}