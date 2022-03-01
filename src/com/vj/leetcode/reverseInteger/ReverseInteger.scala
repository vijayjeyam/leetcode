package com.vj.leetcode.reverseInteger

object ReverseInteger extends App {
  println(Solution.reverse(-2147483648))


}
object Solution {
  def reverse(x: Int): Int = x match {
    case y if y >=  0 => reverse(0, y)
    case y if y <= (Math.pow(2,31) - 1)  * -1 => 0
    case others => reverse(0,  math.abs(x) ) * -1

  }
  val intMax:Int = Math.pow(2,31).toInt
  def check(acc: Int, num: Int): Boolean = {
    (intMax - num ) / 10 >= acc
  }

  private def reverse(acc:Int, num: Int):Int ={
    num match {
     case a if a >= 10 => reverse( acc * 10 +( num % 10), num / 10)
      case a if a < 10 && check(acc, a) =>   (acc * 10 + a)
      case others => 0
    }
  }
}