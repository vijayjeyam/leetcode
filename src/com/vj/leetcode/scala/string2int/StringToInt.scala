package com.vj.leetcode.scala.string2int

object StringToInt extends App {
  println(Solution.myAtoi("   -11 123") == -11)
  println(Solution.myAtoi("   +1 123") == 1)
  println(Solution.myAtoi("   -0 123") == 0)
  println(Solution.myAtoi(" -0012a42") == -12)
  println(Solution.myAtoi("00000-42a1234") == 0)
  println(Solution.myAtoi("   -42") == -42)
  println(Solution.myAtoi("-91283472332") == -2147483648)
  println(Solution.myAtoi("123456789066") == 2147483647)
}
