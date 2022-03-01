package com.vj.leetcode.scala.string2int


object Solution {

  def getNum(sign:Option[Boolean] = None,i: Int, a: Int): Int = sign match {
    case Some(false) => -1 * (if (((Int.MinValue  + a) /10) <= -1 * i)  (-1 * (i * 10 + a)) else Int.MinValue)
    case _ =>if (((Int.MaxValue - a) /10) >= i) i*10 + a else Int.MaxValue
  }

  def getVal(sign: Option[Boolean], i: Int): Int = sign match {
    case Some(false) => i * -1
    case _ => i
  }

  def myAtoi(sign:Option[Boolean], i: Int, toCharArray: List[Char]): Int = (sign, toCharArray) match {
    case (_,' ' :: list) => getVal(sign, i)
    case (None, '+' :: list ) =>  myAtoi(Some(true),i, list)
    case (None, '-' :: list)  => myAtoi(Some(false),i, list)
    case (_, '+' :: list ) =>  getVal(sign, i)
    case (_, '-' :: list)  => getVal(sign, i)
    case (_,a :: list)  if !a.isDigit  => getVal(sign, i)
    case (_,a :: list) => myAtoi(sign.orElse(Some(true)),getNum(sign,i ,a.asDigit),list)
    case (_,_) => getVal(sign, i)
  }

  def myAtoi(s: String): Int = {
    myAtoi(None,0,s.trim.toCharArray.toList)
  }
}
