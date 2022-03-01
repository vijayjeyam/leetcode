package com.vj.leetcode.scala.validPalindrome

object ValidPalindrome extends App{
  println(Solution.isPalindrome("malay alam"))
}

object Solution {
  def isPalindrome(s: String): Boolean = {
    val chars = strip(s.toLowerCase)
    checkPalin(chars,chars.length)
  }
def checkPalin(chars : List[Char] , len:Int) : Boolean = chars match {
  case _ if len <=1 => return true
  case a :: list if a == list(len -2) => checkPalin(list,len-2)
  case a :: list  => false
  case _ => false
}
  def strip(s:String) : List[Char] =  {
    s.foldLeft(Nil:List[Char])((a : List[Char],b) => b match {
      case ch if ch.isLetterOrDigit => ch :: a
      case _ => a
    })
  }
}