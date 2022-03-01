package com.vj.leetcode.scala.findDuplicate

object FindDuplicate extends App{
println(Solution.findDuplicate(Array(3,1,3,4,2)))
}

object Solution {
  def findDuplicate(numbers: Array[Int]): Int = {
    def mark(index:Int):Int = numbers(index) match{
      case some if some < 0 => index
      case others =>
        numbers(index) = others * -1
        println(numbers.mkString(","))
        mark(others)
      }
    mark(0)
  }
}
object Solution2 {
  def findDuplicate(nums: Array[Int]): Int = {
    def findUntil(numbers:Seq[Int]):Int = numbers  match {
      case Seq(a,b,c@_*) if(a==b)=> a
      case Seq(a,c@_* ) => findUntil(c)
      case Seq(a) => -1
    }
    findUntil(nums.sorted)
  }
}