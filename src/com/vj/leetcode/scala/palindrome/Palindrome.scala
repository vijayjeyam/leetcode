package com.vj.leetcode.scala.palindrome

object  Palindrome extends App{
println(Solution.isPalindrome(9))
}
object Solution {
  def isPalindrome(x: Int): Boolean = {
    isPalindrome(x,0,x)
  }
  private def isPalindrome(x:Int,acc:Int,original:Int):Boolean = x match {
    case num if num < 0 => false
    case num if num == acc => true
    case num if num <= 9 => acc*10+num == original
    case _ =>    isPalindrome(x/10,(acc * 10) + (x%10),original)
  }
}