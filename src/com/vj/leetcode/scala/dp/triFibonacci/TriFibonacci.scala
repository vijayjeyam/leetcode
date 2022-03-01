package com.vj.leetcode.scala.dp.triFibonacci

object TriFibonacci extends App{
  lazy val tFib:Stream[Int] = 0 #:: 1 #:: 1 #:: (tFib.zip(tFib.tail).zip(tFib.tail.tail)).map { case((a,b),c) => a+b+c}
  tFib.take(6).foreach(println)
}
object Solution {
  def tribonacci(n: Int): Int = {
    val array = Array.fill(n)(0);
    array(1) = 1
    array(2) = 1
    for( i <- 3 to n-1){
      array(i) = array(i-1)+array(i-2)+array(i-3)
    }
    array.last
  }
}