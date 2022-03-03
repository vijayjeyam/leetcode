package com.vj.leetcode.scala.arithmeticSubArray

import com.vj.leetcode.scala.TestMixin

object ArithmeticSubArray extends  TestMixin{
tPrint(List(true)){Solution.checkArithmeticSubarrays(Array(1,2,3),Array(0),Array(2))}
}
object Solution {
  def checkArithmeticSubarrays(nums: Array[Int], l: Array[Int], r: Array[Int]): List[Boolean] = {
    def difference(list:Seq[Int], lastEmem:Int, diff:Int):Boolean = list match {
      case Seq() => true
      case Seq(head) if(head-lastEmem == diff) =>
          difference(Seq(),head,diff)
      case Seq(head, tail@_*)
        if(head-lastEmem == diff) =>
          difference(tail,head,diff)
      case _ => false
    }
    def diff(list:Seq[Int]):Boolean = {
      if (list.length == 2) return true
      if(list.length < 3) return false;
      val sorted = list.sorted
      difference(sorted.tail,sorted.head,sorted.tail.head - sorted.head)
    }
    val res  = for(
      ind <- 0 to l.length-1;
      toFind = nums.slice(l(ind),r(ind)+1)

    )yield diff(toFind)
    res.toList
  }
}