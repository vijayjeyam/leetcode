package com.vj.leetcode.peakNumber

object PeakNumber extends App{
  println(Solution.findPeakElement(Array(1,2,3,1)) == 2)
println(Solution.findPeakElement(Array(1,10,2)) == 1)
  println(Solution.findPeakElement(Array(1,1,10,2)) == 2)
  println(Solution.findPeakElement(Array(10)) == 0)
  println(Solution.findPeakElement(Array(1,2,3,4,3,2,1)) == 3)
}
object Solution {
  def findPeakElement(nums: List[(Int,Int)]): Int = {
    nums match {
      case a :: Nil => a._2
      case a:: b:: others   => if(a._1 > b._1)  a._2 else findPeakElement(  b :: others )
      case _ => throw new RuntimeException("Not able")
    }
  }

  def findPeakElement(nums: Array[Int]) :Int = {
    findPeakElement(nums.toList.zipWithIndex)
  }

}