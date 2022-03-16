package com.vj.leetcode.scala.threeSum

import com.vj.leetcode.scala.TestMixin
//https://leetcode.com/problems/3sum/
object ThreeSum extends TestMixin{
println(Solution.threeSum(Array(-7,2,1,10,9,-10,-5,4,13,-9,-4,6,11,-12,-6,-9,-6,-9,-11,-4,10,10,-3,-1,-4,-7,-12,-15,11,5,14,11,-7,-8,6,9,-2,9,-10,-12,-15,2,10,4,5,11,10,6,-13,6,-13,12,-7,-9,-12,4,-9,13,-4,10,4,-12,6,4,-5,-10,-2,0,14,4,4,6,13,-9,-5,-5,-13,12,-14,11,3,10,8,11,-13,4,-8,-7,2,4,10,13,7,2,2,9,-1,8,-5,-10,-3,6,3,-5,12,6,-3,6,3,-2,2,14,-7,-13,10,-13,-2,-12,-4,8,-1,13,6,-9,0,-14,-15,6,9)));
}

object Solution {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val some =  nums.zipWithIndex.map(a => (a._2,a._1)).toMap
    val some2 = for {
      num1 <- some
      num2 <- some - num1._1
      all = (some - num1._1 - num2._1).filter(a => 0 == a._2 + num1._2 + num2._2)
      if(all.size > 0)
    } yield all.map(a => List(a._2,num1._2,num2._2).sorted)
    some2.flatten.toSet.toList
  }
}