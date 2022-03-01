package com.vj.leetcode.scala.compVerNum

import com.vj.leetcode.scala.TestMixin

object CompVerNum extends TestMixin {
  tPrint(0) {
    Solution.compareVersion("1.0.0", "1")
  }

  tPrint(1) {
    Solution.compareVersion("1.10.1", "1.1.1")
  }
  tPrint(-1) {
    Solution.compareVersion("1.10.1", "10.1.1")
  }
  tPrint(0) {
    Solution.compareVersion("1.1.1", "1.1.1")
  }

}

object Solution {
  def compVer(firstL: List[String], secondL: List[String]): Int = (firstL, secondL) match {
    case (Nil, Nil) => 0
    case (first :: taila, second :: tailb) if (first.toInt.compare(second.toInt) != 0) => first.toInt.compare(second.toInt)
    case (_,_) =>  compVer(firstL.tail, secondL.tail)
  }

  def compareVersion(version1: String, version2: String): Int = {
    var v1 = version1.split("[.]").toList
    var v2 = version2.split("[.]").toList
    val maxLen =  Math.max(v1.length,v2.length)
    for(ind <- v1.length to maxLen){
      v1 = v1 :+ "0"
    }
    for(ind <- v2.length to maxLen){
      v2 = v2 :+ "0"
    }
    compVer(v1, v2)
  }
}