package com.vj.leetcode.scala.contWithMostWater

object ContMostWater extends App {
  println(Solution.maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)));
}
object Solution {
  def maxArea(height: Array[Int]): Int = {
    def maxArea(left:Int=0,right:Int=height.length-1): Int =
      (left < right ,height(left) > height(right)) match{
      case (false,_) => 0
      case (_,true) =>  Math.max((right- left)*height(right),maxArea(left,right-1))
      case (_,false) => Math.max(height(left)*(right- left),maxArea(left+1,right))
    }
    maxArea()
  }
}
object SolutionB {
  def maxArea(height: Array[Int]): Int = {
    var arr:Array[(Int,List[Int])] = Array.fill(height.max)((0,Nil))
    height.zipWithIndex.foreach{
      case(num,index) =>
        (0 to num-1).foreach( hInd=>
        arr(hInd) = (hInd , index :: arr(hInd)._2))
    }
    arr.map(a => (a._1+1) * (a._2.head-a._2.last)).max
  }
}