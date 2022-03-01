package com.vj.leetcode.scala.sqrt

object SquareRoot extends App{
  println(Solution.mySqrt(2147395599))
  println(Solution.mySqrt(2147483647))

  println(Solution.mySqrt(1))
  println(Solution.mySqrt(3))
  println(Solution.mySqrt(4))
  println(Solution.mySqrt(8))
  println(Solution.mySqrt(10))
  println(Solution.mySqrt(121))
}
object Solution {
  def mySqrt(x: Int): Int = {
    def priSq(num : Int): Int ={
      if(isGood(num)){
        num
      } else {
        priSq(improve(num))
      }
    }
    def improve(guess:Int):Int = {

      val num = (guess + x/guess)/2

      //println(s" Guess next for $guess is ${if(num < 0) guess/2 else num} ")
      if(num < 0) guess/2 else num
    }
    def isGood(num:Int): Boolean = {
      val current = (num  ) * (num )
      val isCurrent = current/num == num
      val after = (num +1 ) * (num + 1)
      val isafter = after/num == num
      //println(s" $num Check Good ${x == current || ( current < x && after > x && (isCurrent  && !isafter))}")
      x == current || ( current < x && after > x && (isCurrent  && !isafter)) || (isCurrent && current < x && !isafter)
    }
    x match {
      case c if c <= 0 => 0
      case _ => priSq(x)
    }

  }

}