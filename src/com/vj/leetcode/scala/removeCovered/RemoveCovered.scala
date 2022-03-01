package com.vj.leetcode.scala.removeCovered

import com.vj.leetcode.scala.TestMixin

//1288. Remove Covered Intervals
//Medium
//
//1787
//
//43
//
//Add to List
//
//Share
//Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.
//
//The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
//
//Return the number of remaining intervals.
object RemoveCovered extends TestMixin {
  tPrint(1) {
    Solution.removeCoveredIntervals(Array(Array(1, 2), Array(1, 4), Array(3, 4)))
  }
}

object Solution {
  def removeCoveredIntervals(intervals: Array[Array[Int]]): Int = {
    val some = intervals sortWith {
      (a, b) =>
        (a, b) match {
          case (Array(fH, fT), Array(sH, sT)) => {
            if (fH > sH) false
            else if (fH < sH) true
            else if (sT > fT) false
            else if (sT < fT) true
            else false
          }
        }
    }
def isBounded(a:Int,pair:Array[Int]) = pair match {
  case Array(f,s) if( a >=f && a<=s) => true
  case others => false
}
    println(some.map(_.mkString("",",","\n")).mkString("","","\n"))
    def removeCovered_(nums: List[Array[Int]],
                       acc: List[Array[Int]],
                       current: Array[Int]): List[Array[Int]] = nums match {
      case a :: tail if (!isBounded(a.last,current)) => removeCovered_(tail, a :: acc, a)
      case a :: tail => removeCovered_(tail, acc, current)
      case Nil => acc
    }

    removeCovered_(some.toList, List(Array(0, 0)), Array(0, 0)).length - 1
  }
}