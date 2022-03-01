package com.vj.leetcode.scala.excelSheetColumnNumber

import com.vj.leetcode.scala.TestMixin

object ExcelSheetColumnNumber extends TestMixin{

  tPrint(701){
    Solution.titleToNumber("ZY")
  }
  tPrint(1){
    Solution.titleToNumber("A")
  }
  tPrint(28){
    Solution.titleToNumber("AB")
  }

}

object Solution {
  def titleToNumber(columnTitle: String): Int = {
    println(columnTitle.toCharArray.map(_-'A'+1).zip(columnTitle.length -1 to 0 by -1).mkString(","))
    columnTitle.toCharArray.map(_-'A'+1).zip(columnTitle.length -1 to 0 by -1).foldLeft(0) {
      case (a, b ) => a + (Math.pow(26,b._2)*b._1).toInt
    }
  }
}
