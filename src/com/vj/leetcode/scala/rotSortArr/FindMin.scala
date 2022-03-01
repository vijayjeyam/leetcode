package com.vj.leetcode.scala.rotSortArr

object FindMin extends App{
  println(Solution.findMin(Array(3,1,3)))

  object Solution {
    def findMin(nums: Array[Int]): Int = {
      findMin(nums,nums(0), 0, nums.length)
    }
    def findMin(nums: Array[Int],min:Int, st:Int, end:Int): Int = {
      def isArrayRoated() : Boolean = ! (nums(st) < nums(end-1))
      if (!isArrayRoated()) return if(nums(st) < min) nums(st)  else min
      val mid = (st + end )/2
      nums.slice(st,end) match  {
        case Array(first)  =>  if(first < min) first  else min
        case Array(first,second)  =>  if(second < min) second  else min
        case _ => val lMin = findMin(nums, min, st, mid)
          val rMin = findMin(nums, lMin, mid, end)
          rMin
      }


    }

  }
}

