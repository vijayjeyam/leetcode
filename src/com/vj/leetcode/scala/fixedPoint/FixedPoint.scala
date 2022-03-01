package com.vj.leetcode.scala.fixedPoint

import com.vj.leetcode.scala.TestMixin

object FixedPoint extends TestMixin{
  tPrint(-1){
    Solution.fixedPoint(Array())
  }
tPrint(3){
  Solution.fixedPoint(Array(-1,0,1,3,4))
}
  tPrint(3){
    Solution.fixedPoint(Array( -10,-5,0,3,7))
  }
  tPrint(0){
    Solution.fixedPoint(Array(0))
  }
  tPrint(-1){
    Solution.fixedPoint(Array(1))
  }
  tPrint(4){
    Solution.fixedPoint(Array(-10,-5,-2,0,4,5,6,7,8,9,10))
  }
}

object Solution {
  def fixedPoint(arr: Array[Int]): Int = {
    def search(left:Int,right:Int,current:Int) :Int= {
      if(left > right) return current
      val mid = left + (right - left)/2
      arr(mid) match {
        case num if mid == num => search(left,mid-1,mid)
        case num if mid > num => return search(mid+1,right,current)
        case num  => return search(left,mid-1,current)
      }
    }
    search(0,arr.length-1,-1)
  }
}