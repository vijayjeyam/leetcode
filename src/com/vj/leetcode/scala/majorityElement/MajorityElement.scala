package com.vj.leetcode.scala.majorityElement

import com.vj.leetcode.scala.TestMixin

object MajorityElement extends TestMixin{

  tPrint(3){
    Solution.majorityElement(Array(3,2,3))
  }
//  tPrint(5){
//    Solution.majorityElement(Array(6,5,5))
//  }
//  tPrint(1){
//  Solution.majorityElement(Array(1))
//}
}
object Solution {
  def majorityElement(nums: Array[Int]): Int = {
    var map = Map[Int,Int]()
    def loop(num_s:List[Int]): Int = num_s match{
      case a :: b =>  {
        val some:Int = map.getOrElse(a, 0 ) + 1
        map = map + (a -> some);
        if (some >= (nums.length+1)/2){
          return a
        }
        else loop(b)
      }
      case Nil =>return -1
    }
    loop(nums.toList)
  }
}