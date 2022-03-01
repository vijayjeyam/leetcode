package com.vj.leetcode.scala.search2D

class Search2D {

}

object Solution {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val lenY = matrix(0).length
    val lenX = matrix.length
    def searchIndex(st:Int, end:Int) : Int = {
      //println(s" ${nums.slice(st,end).mkString} target $target index [$st,$end]")
      def getAt(i:Int) = matrix(i/lenY)(i%lenY)
      val mid = (st + end)/2
      getAt(mid) match {
        case num if num == target => mid
        case num if mid +1 == end => if(getAt(st) == target) st else -1
        case other if other < target => searchIndex( mid+1 , end)
        case other if other > target => searchIndex( st, mid)
      }
    }
    searchIndex(0, lenX*lenY) != -1
  }
}