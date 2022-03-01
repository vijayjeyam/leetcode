package com.vj.leetcode.scala.missingRanges

import com.vj.leetcode.scala.TestMixin
import com.vj.leetcode.scala.summaryRanges.Solution
import com.vj.leetcode.scala.summaryRanges.SummaryRanges.tPrint

object MissingRanges extends TestMixin{
  tPrint(List[String]()) {
    Solution.findMissingRanges(Array(0,1),0,1)
  }
  tPrint(List[String]("0")) {
    Solution.findMissingRanges(Array(-1),-1,0)
  }
  tPrint(List[String]()) {
    Solution.findMissingRanges(Array(-1),-1,-1)
  }
  tPrint(List[String]("1")) {
    Solution.findMissingRanges(Array(),1,1)
  }
  tPrint(List("2","4->49","51->74","76->99")) {
    Solution.findMissingRanges(Array(0,1,3,50,75),0,99)
  }
  tPrint(List[String]("0","2->4")) {
    Solution.findMissingRanges(Array(1),0,4)
  }

}
object Solution {
  def findMissingRanges(nums: Array[Int], lower: Int, upper: Int): List[String] = {
    val acc = scala.collection.mutable.ListBuffer[String]()

    def appendRange(from:Int,to:Int): Unit = from == to match{
      case _ if from > to =>
      case true  => acc.append(s"$from")
      case false => acc.append(s"$from->$to")
    }
    def summRange(fInd:Int, curInd:Int, lastElem:Int ):Unit ={
      if(curInd == nums.length  ) {
        if(nums(curInd-1)+1 <= upper) appendRange(nums(curInd-1)+1,upper)
      } else
        nums(curInd) == lastElem + 1 match {
          case true => summRange(fInd, curInd + 1, nums(curInd))
          case false => appendRange(lastElem+1,nums(curInd)-1)  ; summRange(curInd,curInd + 1, nums(curInd))
        }
    }
    if(nums.length !=0)
      summRange(0,0,lower-1)
    else
      appendRange(lower,upper)
    acc.toList
  }
}