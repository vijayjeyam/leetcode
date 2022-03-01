package com.vj.leetcode.scala.mergeSortedArray

import com.vj.leetcode.scala.TestMixin

import scala.collection.mutable.ArrayBuffer

object MergeSortedArray extends TestMixin{
  tPrint(Array(1,2).mkString(",")){
    val so = Array(0,0,3,0,0,0,0,0,0)
    Solution.merge(so,3,Array(-1,1,1,1,2,3),6)
    so.mkString(",")
  }
  tPrint(Array(1,2).mkString(",")){
    val so = Array(-1,0,0,3,3,3,0,0,0)
    Solution.merge(so,6,Array(1,2,2),3)
    so.mkString(",")
  }
  tPrint(Array(1,2).mkString(",")){
    val so = Array(2,0)
    Solution.merge(so,3,Array(1),3)
    so.mkString(",")
  }
  tPrint(Array(1).mkString(",")){
    val so = Array(1)
    Solution.merge(so,3,Array(),3)
    so.mkString(",")
  }
  tPrint(Array(1,2,2,3,5,6).mkString(",")){
    val so = Array(1,2,3,0,0,0)
    Solution.merge(so,3,Array(2,5,6),3)
    so.mkString(",")
  }
  object Solution {

    def getNum(nums2: Array[Int], sInd: Int) = nums2.length > sInd match {
      case false => Int.MaxValue
      case true => nums2(sInd)
    }

    def merge(numbers: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
      val nums1:Array[Int] =( for{
                    ind <- 0 to numbers.length-1
                    x = if(ind >= m && numbers(ind)==0) {
                        Int.MaxValue
                      } else numbers(ind)
                    }yield x ).toArray


      def mergeP(mainInd:Int,fInd:Int,sInd:Int):Unit = {
        if(mainInd > numbers.length -1 ) return
         (getNum(nums1,fInd),getNum(nums2,sInd)) match {
          case (a,b) if a == b => numbers(mainInd) = b;mergeP(mainInd+1,fInd+1,sInd)
          case (a,b) if a > b => numbers(mainInd) = b; mergeP(mainInd+1,fInd,sInd+1)
          case (a,b) if a < b => numbers(mainInd) = a ;mergeP(mainInd+1,fInd+1,sInd)
        }
      }
      mergeP(0,0,0)
    }
  }
}

