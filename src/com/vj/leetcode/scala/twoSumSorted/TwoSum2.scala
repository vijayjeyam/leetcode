package com.vj.leetcode.scala.twoSumSorted

object TwoSum2 extends App{

}
object Solution {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    val numWithIndex = numbers.zipWithIndex
    val foundIndex = for{
      num <- numWithIndex
      foundList = numWithIndex.filter(_._1 == target - num._1)
      found <- foundList
      if(found._2 != num._2 )
    }yield (num._2+1,found._2+1)
    Array(foundIndex.head._1,foundIndex.head._2)
  }
}