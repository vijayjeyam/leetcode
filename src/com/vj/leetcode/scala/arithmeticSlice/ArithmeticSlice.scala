package com.vj.leetcode.scala.arithmeticSlice

import com.vj.leetcode.scala.TestMixin

object ArithmeticSlice extends TestMixin{
tPrint(3){Solution.numberOfArithmeticSlices(Array(1,2,3,4))}
  tPrint(0){Solution.numberOfArithmeticSlices(Array(1))}

}

object Solution {
  def numberOfArithmeticSlices(nums: Array[Int]): Int = {
    if(nums.length < 3) return 0;
    def difference(list:Seq[Int],  lastEmem:Int,diff:Int, count:Int):(Int,Seq[Int]) = list match {
      case Seq() => (count+1,Seq[Int]())
      case Seq(head) =>
        if(head-lastEmem == diff)
          difference(Seq(),head,diff,count+1)
        else
          (count+1,list)
      case Seq(head, tail@_*) =>
        if(head-lastEmem == diff)
          difference(tail,head,diff,count+1)
        else
          (count+1,lastEmem +: list)

    }
    def fullSeq(list:Seq[Int],acc:List[Int]=List()) : List[Int] = {
      if(list.length < 3) return acc
      difference(list.tail,list.head,list(1) - list(0),0) match {
        case (count,Seq()) =>   count +: acc
        case (count,any)   => fullSeq(any,count::acc)
      }

    }
    fullSeq(nums).map( n => (n-2)*(n-1)/2).sum

  }
}