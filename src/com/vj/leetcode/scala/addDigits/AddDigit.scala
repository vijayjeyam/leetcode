package com.vj.leetcode.scala.addDigits

import com.vj.leetcode.scala.TestMixin

object AddDigit extends TestMixin{
  tPrint(1){Solution.addDigits(100)}
}
object Solution {
  def addDigits(num: Int): Int = {
    def addDigitsP(num: Int): Int = {
      if(num / 10 == 0) num
      num%10 + addDigits(num/10)
    }
    var res:Int = num
    while(res >= 10){
      res = addDigitsP(res)
    }

    res
  }
}