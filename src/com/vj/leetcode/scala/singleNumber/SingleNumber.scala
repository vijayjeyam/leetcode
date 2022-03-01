package com.vj.leetcode.scala.singleNumber

object SingleNumber extends App{
  println(Solution.singleNumber(Array(1,2,1)))
  println(Solution3.singleNumber(Array(1,2,1,1)))
  println(Solution4.singleNumber(Array(1,2,1,3,3,2,3,1)).mkString(","))
}
object Solution4 {
  def singleNumber(nums: Array[Int]): Array[Int] = {
    var some = nums.sortWith(_ < _)
    def getSingle(numbers:Seq[Int],ans:List[Int] = Nil): List[Int] = numbers match {
      case Seq() => ans
      case Seq(one) => getSingle(Seq(),one :: ans)
      case Seq(one,two,a@_*) if(one != two) => getSingle(two +: a,one :: ans)
      case Seq(one,two,a@_*)  => getSingle(a,ans)
    }
    getSingle(some).toArray
  }
}

object Solution3 {
  def singleNumber(nums: Array[Int]): Int = {
    var some = nums.sortWith(_ < _)
    def getSingle(numbers:Seq[Int]):Int = numbers match {
      case Seq(one,two,three,a@_*) if(one != two) => one
      case Seq(one,two,three,a@_*)  => getSingle(a)
      case Seq(one) => one

    }
    getSingle(some)
  }
}

object Solution {
  def singleNumber(nums: Array[Int]): Int = {
    var some = nums.sortWith(_ < _)
    def getSingle(numbers:Seq[Int]):Int = numbers match {
      case Seq() => 0
      case Seq(one) => one
      case Seq(one,two,a@_*) if(one != two) => one
      case Seq(one,two,a@_*)  => getSingle(a)
    }
    getSingle(some)
  }
}
object Solution1_1 {
  def singleNumber(nums: Array[Int]): Int = nums.foldLeft(0)(_^_)
}