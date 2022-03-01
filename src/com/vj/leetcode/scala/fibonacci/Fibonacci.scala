package com.vj.leetcode.scala.fibonacci

object Fibonacci extends App{
  val solution = new Solution()
println(solution.fibSeries2(30).mkString(","))
}

class Solution{
  def fibSeries(numSeq:Int) : List[Int] = {
    lazy val fib:Stream[Int] = 0 #:: 1 #:: fib.zip(fib.tail).map ( num => num._1 + num._2 )
    fib.take(numSeq).toList
  }

  def fibSeries2(numSeq:Int) : List[Int] = {
    var list = Array.fill(numSeq)(0)
    list(1) = 1
    val a  = for{
      i <- 2 to numSeq-1
    } {
      list(i) = list(i-2) + list(i-1)
    }
    list.toList

  }
}