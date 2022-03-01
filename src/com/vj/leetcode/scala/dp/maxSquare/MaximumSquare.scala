package com.vj.leetcode.scala.dp.maxSquare

import com.vj.leetcode.scala.TestMixin

object MaximumSquare extends TestMixin {
tPrint(1){
  Solution.maximalSquare(Array(Array('0','1'),Array('1','0')))
}
  tPrint(4){
    Solution.maximalSquare(Array(Array('1','0','1','0','0'),
      Array('1','0','1','1','1'),
      Array('1','1','1','1','1'),
      Array('1','0','0','1','0')))
  }
}
object Solution {
  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    val dimR = matrix.length
    val dimC = matrix(0).length

    val dpVal:Array[Array[Int]] = Array.tabulate(dimR,dimC)((a,b) => -1)
    def dp(r:Int,c:Int):Int ={
      if(r == -1 || c == -1) return 0
      dpVal(r)(c) match {
        case -1 => {
          if(matrix(r)(c) == '0') {
            dpVal(r)(c) = 0
            dp(r-1,c)

            dp(r-1,c-1)
            dp(r,c-1)
          } else {
            val (t,s,l) = (dp(r-1,c),dp(r-1,c-1),dp(r,c-1))
            dpVal(r)(c) = Math.min(Math.min(t,s),l) + 1
          }
          dpVal(r)(c)
        }
        case others => others
      }
    }
    dp(dimR-1,dimC-1)
    val maxLen = dpVal.flatten.max
    maxLen*maxLen
  }
}
object SolutionOld {



  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    def findMaxSqr(x: Int, y: Int, len:Int = 1): Int ={
      if(x-len < 0 || y-len < 0) return len
      (for(
        xInd <- (x to (x-len) by -1);
        yInd <- (y to (y-len) by -1)
        if(matrix(xInd)(yInd) == '1')
      ) yield 1).sum == (len * len) match {
        case true => findMaxSqr(x,y,len+1)
        case false => len
      }
    }
    val dimX = matrix(0).length
    val dimY = matrix.length
    val dpVal:Array[Array[Int]] = Array.ofDim(dimX,dimY)
    dpVal(0)(0) = if(matrix(0)(0) == '1') 1 else 0
    def dp(x:Int,y:Int): Unit ={
      if(x == -1 || y == -1) return
    val res =  dpVal(x)(y)
      if(res ==0){
        val (newX,newY) = if(y == 0) (x-1,dimY - 1) else (x,y -1)
        dpVal(x)(y) = if(matrix(x)(y) == '1') findMaxSqr(x,y)  else -1
        dp(newX,newY)
      }
    }
    dp(dimX-1,dimY-1)
    dpVal.flatten.max
  }
}