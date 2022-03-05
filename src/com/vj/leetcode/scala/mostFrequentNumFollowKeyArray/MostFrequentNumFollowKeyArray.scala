package com.vj.leetcode.scala.mostFrequentNumFollowKeyArray

import com.vj.leetcode.scala.TestMixin

object MostFrequentNumFollowKeyArray extends TestMixin{
tPrint(100){Solution.mostFrequent( Array(1,100,200,1,100), key = 1)}
  tPrint(2){Solution.mostFrequent( Array(2,2,2,2,3), key = 2)}
}

object Solution {
  def mostFrequent(nums: Array[Int], key: Int): Int = {
      def scan(numbers:List[Int], acc:List[Int] = Nil) : List[Int] = numbers match {
        case Nil => return acc
        case head::Nil => return acc
        case head:: tail if(head == key)=> scan(tail,tail.head :: acc)
        case head:: tail => scan(tail, acc)
      }
    val temp = scan(nums.toList).groupBy(a => a)
      val temp2 = temp.map(a => (a._1,a._2.length)).toList
       val temp3 = temp2.sortBy(_._2)
         temp3.last._1
  }
}