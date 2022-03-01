package com.vj.leetcode.scala.dp.climbingstairs

object ClimbingStairs extends App {
  //println(Solution.climbStairs(0) == 0)
  println(Solution.climbStairs(2))
  println(Solution.climbStairs(3) == 3)
  println(Solution.climbStairs(6) +"=="+ 13)
  println(Solution.climbStairs(45))
}

object Solution {
  def climbStairs(n: Int,acc:Int=1): Int = {
    lazy val steps: Stream[Int] = 1 #:: 2  #:: steps.zip(steps.tail).map { num => num._1 + num._2 }
    steps.take(n).last
   }
}

object Solution1 {
  var splits = 1;

  def climbStairs(n: Int): Int = {
    def climbingStairs_(n: Int): Unit = n match {
      case any if any < 2 =>
      case any => {
        splits = splits + 1;
        climbingStairs_(any - 1);
        climbingStairs_(any - 2)
      }
    }

    climbingStairs_(n)
    splits
  }


}