package com.vj.leetcode.scala.minAddParan

import com.vj.leetcode.scala.TestMixin

object MinAddParan extends TestMixin{
tPrint(0){Solution.minAddToMakeValid("()")}
  tPrint(1){Solution.minAddToMakeValid("(")}
  tPrint(1){Solution.minAddToMakeValid(")")}
  tPrint(1){Solution.minAddToMakeValid("(()")}
  tPrint(4){Solution.minAddToMakeValid("()))((")}
}
object Solution {
  def minAddToMakeValid(s: String): Int = {

    def find(chars:List[Char],count:Int = 0, ret:Int = 0):Int = chars match{
      case a :: tail if( a == '(' ) => {
        if(count < 0)
          find(tail,1,ret - count)
        else
          find(tail,count+1,ret)
      }
      case a :: tail => find(tail,count-1,ret)
      case Nil => ret + Math.abs(count)
    }
    find(s.toList)
  }
}