package com.vj.leetcode.scala.dp.maxiSplitPositiveEvenIntegers

import com.vj.leetcode.scala.TestMixin

object MaxiSplitPositiveEvenIntegers extends TestMixin{
//  tPrint(List[Long](2)){//96
//    Solution.maximumEvenSplit(8)
//  }
//  tPrint(List[Long](2)){//96
//    Solution.maximumEvenSplit(10)
//  }
  tPrint(List[Long]( 2)){//96
    Solution.maximumEvenSplit(2)
  }
  tPrint(List[Long](6, 4, 2)){//96
  Solution.maximumEvenSplit(12)
}
//  tPrint(List[Long](2)){
//    Solution.maximumEvenSplit(14)
//  }

}
object Solution {
  def maximumEvenSplit(finalSum: Long): List[Long] = {
    if(finalSum %2 ==1 ) return List()
    if(finalSum == 2) return List()
    val toFInd = finalSum/2;
    def getSeq(acc:List[(Long,Long)]=Nil,
               index:Int = 1, last:Long = 0) : List[(Long,Long)] = {
      if(toFInd <= last) return acc.tail

      acc match {
        case (a,b) :: _ => getSeq((index+a,index*2L) :: acc, index+1,index+a)
        case Nil =>getSeq(List((1,2)),index + 1, index)
      }

    }
    val series = getSeq()
//    println(series.mkString(","))
//    println((toFInd - series.head._1) * 2)
    val residue = ((toFInd - series.head._1) * 2)
    series.find(_._2 == residue) match {
      case Some(_) =>  series.head._2+residue :: series.map(_._2).tail
      case None =>  residue :: series.map(_._2)
    }

  }
}
object SolutionBackTrack {
  def maximumEvenSplit(finalSum: Long): List[Long] = {
    if(finalSum%2 == 1) return List()
    val toCheck = 2L to (finalSum/2)+1 by 2
    val toCheckLen = toCheck.length
    var out:List[Long] = List()
    def backTrack(index:Int,list:List[Long]):Unit = {
      if(list.sum == finalSum &&  list.length > out.length){
        out = list
        return
      }
      if(index == toCheckLen || list.sum > finalSum){
        return
      }
      for( sInd <- index to toCheckLen -1 ){
        backTrack(index+1,list :+ toCheck(sInd))
      }
    }
    backTrack(0,List())
  out
  }
}