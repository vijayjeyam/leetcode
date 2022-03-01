package com.vj.leetcode.scala.searchInsPos

object SearchInsertPosition extends App{
println(Solution.searchInsert(Array(1,2,4),6))
}
object Solution {
  def searchInsert(nums: Array[Int], target: Int): Int = {
      getIndex(nums.toList,target)
  }
  def getIndex(nums:List[Int], target:Int, position:Int = 0) : Int = nums match {
    case number :: list if (number >= target) => position
    case number :: list  => getIndex(list,target,position+1)
    case _ => position
  }
}