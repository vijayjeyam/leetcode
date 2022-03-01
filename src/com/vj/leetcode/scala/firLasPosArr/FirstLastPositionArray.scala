package com.vj.leetcode.scala.firLasPosArr

object FirstLastPositionArray extends  App{
  println(Solution.searchRange(Array(),3).mkString)
  println(Solution.searchRange(Array(1),3).mkString)
  println(Solution.searchRange(Array(3),3).mkString)
  println(Solution.searchRange(Array(1,2,3),3).mkString)
  println(Solution.searchRange(Array(1,2,3),1).mkString)
  println(Solution.searchRange(Array(1,2,3),2).mkString)
  println(Solution.searchRange(Array(1,2,3,4,5,6,7,8),1).mkString)
  println(Solution.searchRange(Array(1,2,3,4,5,6,7,8),8).mkString)
  println(Solution.searchRange(Array(1,2,3,4,5,6,7,8),2).mkString)
  println(Solution.searchRange(Array(1,2,3,4,5,6,7,8),7).mkString)
  println(Solution.searchRange(Array(1,2,3,4,5,6,7,8),4).mkString)
  println(Solution.searchRange(Array(1,2,3,4,5,6,7,8),5).mkString)
  println(Solution.searchRange(Array(1,2,3,4,5,5,6,7,8),5).mkString)

}
object Solution {

  def expand(nums: Array[Int],target:Int,  i: Int) = {

    def move (curr:Int, dir:Int = 1 ): Int ={
      if(curr+dir < 0 || curr+dir >= nums.length) {
        return curr
      }
      if(nums(curr+dir) == target) {
        move(curr+dir,dir)
      } else {
        curr
      }
    }
    Array(move(i,-1),move(i,+1))
  }

  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    //println(s" ${nums.mkString}")
     nums match {
      case Array() => Array(-1,-1)
      case Array(a) =>  if(a == target) Array(0,0) else Array(-1,-1)
      case _ => expand(nums,target,searchIndex(nums,target,0,nums.length))
    }
  }
  def searchIndex(nums: Array[Int], target: Int, st:Int, end:Int) : Int = {
    //println(s" ${nums.slice(st,end).mkString} target $target index [$st,$end]")
     val mid = (st + end)/2
     nums(mid) match {
       case num if num == target => mid
       case num if mid +1 == end => if(nums(st) == target) st else -1
       case other if other < target => searchIndex(nums, target, mid+1 , end)
       case other if other > target => searchIndex(nums, target, st, mid)
     }
  }

}