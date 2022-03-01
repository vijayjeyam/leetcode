package com.vj.leetcode.scala.summaryRanges

import com.vj.leetcode.scala.TestMixin

object SummaryRanges extends TestMixin{
tPrint(List("1->3")) {
  Solution.summaryRanges(Array(1,2,3))
}
tPrint(List[String]()) {
    Solution.summaryRanges(Array())
}
 tPrint(List("1")) {
    Solution.summaryRanges(Array(1))
}

}
object Solution {
  def summaryRanges(nums: Array[Int]): List[String] = {
    val acc = scala.collection.mutable.ListBuffer[String]()

    def appendRange(from:Int,to:Int): Unit = from == to match{
      case true => acc.append(s"$from")
      case false => acc.append(s"$from->$to")
    }
    def summRange(fInd:Int, curInd:Int, lastElem:Int ):Unit ={

      if(curInd >= nums.length) {
        appendRange(nums(fInd),nums(curInd-1))
      } else
      nums(curInd) == lastElem + 1 match {
        case true => summRange(fInd, curInd + 1, nums(curInd))
        case false => appendRange(nums(fInd),nums(curInd-1))  ; summRange(curInd,curInd + 1, nums(curInd))
      }
    }
    if(nums.length !=0)
      summRange(0,0,nums(0)-1)
    acc.toList
  }
}