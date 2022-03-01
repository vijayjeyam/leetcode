package com.vj.leetcode.scala.intersect2Arraysii

import com.vj.leetcode.scala.TestMixin

object Intersect2Arraysii extends TestMixin{
  tPrint(Array(1,1).mkString(",")){
    Solution2.intersect(Array(1,1,2,3),Array(1,1)).mkString(",")
  }
  tPrint(Array(1).mkString(",")){
    Solution.intersection(Array(1,1,2,3),Array(1,1)).mkString(",")
  }

  tPrint(Array(1).mkString(",")){
Solution2.intersect(Array(1,2,3),Array(1)).mkString(",")
}
}

object Solution {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val a1 = nums1.sorted.toList
    val a2 = nums2.sorted.toList
    type T = List[Int]
    def intersectP(acc:Set[Int] = Set[Int](), arr1:T, arr2:T):Set[Int] = (arr1,arr2) match {
      case(a,b) if(a == Nil || b == Nil)=> acc
      case( a::tail, b::sTail ) if (a == b) => intersectP(acc+a,tail,sTail)
      case( a::tail, b::sTail )  => if (a > b) intersectP(acc,arr1,sTail) else intersectP(acc,tail,arr2)
      case (a,b) => acc
    }
    intersectP(arr1=a1,arr2 = a2).toArray
  }
}
object Solution2 {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val a1 = nums1.sorted.toList
    val a2 = nums2.sorted.toList
type T = List[Int]
    def intersectP(acc:T = List(), arr1:T, arr2:T):T = (arr1,arr2) match {
        case(a,b) if(a == Nil || b == Nil)=> acc
        case( a::tail, b::sTail ) if (a == b) => intersectP(a::acc,tail,sTail)
        case( a::tail, b::sTail ) if (a > b) => intersectP(acc,arr1,sTail)
        case( a::tail, b::sTail ) => intersectP(acc,tail,arr2)
    }
    intersectP(arr1=a1,arr2 = a2).toArray
  }
}