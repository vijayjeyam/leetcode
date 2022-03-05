package com.vj.leetcode.scala.sortJumbledNumbers

import com.vj.leetcode.scala.TestMixin
//TODO
object SortJumbledNumbers extends TestMixin{
tPrint(Array(454,95,404,47799,19021,162535,51890378).mkString(",")){Solution.sortJumbled(Array(7,9,4,1,0,3,8,6,2,5
  ),Array(47799,19021,162535,454,95,51890378,404)).mkString(",")}
}
object Solution {
  def mapRev(mapping: Array[Int], num: Int, ans: Int = 0): Int = {
    if (num == 0) return ans
    val unit = num % 10
    val toMap = mapping(unit)
    mapRev(mapping, num / 10, ans * 10 + toMap)
  }

  def sortJumbled(mapping: Array[Int], nums: Array[Int]): Array[Int] = {
    val revMap = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val some = nums.map(num => (num,
      if(num<10) mapping(num) else mapRev(mapping, num))).map(numMapped => (numMapped._1,if(numMapped._2 < 10)revMap(numMapped._2) else mapRev(revMap, numMapped._2)))
    some.foreach(println)
    some.map(nums => {
      val strnum1 = nums._1.toString
      val strnum2 = nums._2.toString
    })
    val res = some.sortWith((a, b) => {
      if (a._2 == b._2) true else a._2 < b._2
    }).map(_._1)
    res
  }
}
//}[9,8,7,6,5,4,3,2,1,0]
//[9,0,8,7,6,5,4,3,2,1]