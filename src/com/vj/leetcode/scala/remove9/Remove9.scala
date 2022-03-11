package com.vj.leetcode.scala.remove9

//https://leetcode.com/problems/remove-9/
class Remove9 {

}
object Solution {
  def getNumber(n:Int,ans:String) : Int ={
    if(n == 0) return ans.toInt
      getNumber(n/10, (n%9).toString + ans)
  }
  def newInteger(n: Int): Int = {
    getNumber(n,"")
  }
}
