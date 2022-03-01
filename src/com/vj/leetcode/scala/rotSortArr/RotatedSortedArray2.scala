package com.vj.leetcode.scala.rotSortArr

object RotatedSortedArray2 extends App{

}


object Solution {
  def search(nums: Array[Int], target: Int): Int = {
    searchIndex(nums,target,0,nums.length)
  }
  def searchIndex(nums: Array[Int], target: Int, st:Int, end:Int) : Int = {
    //println(s" ${nums.slice(st,end).mkString} target $target index [$st,$end]")
    val mid = (st + end)/2
    nums(mid) match {
      case num if num == target => mid
      case num if mid +1 == end => if(nums(st) == target) st else -1
      case other if other < target => {
        val ind = searchIndex(nums, target, mid+1 , end)
        if(ind == -1) {
          searchIndex(nums, target, st, mid)
        } else {
          ind
        }
      }
      case other if other > target =>{
        val ind = searchIndex(nums, target, st, mid)
        if(ind == -1) {
          searchIndex(nums, target, mid+1 , end)
        } else {
          ind
        }
      }
    }
  }

}

