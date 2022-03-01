package com.vj.leetcode.scala.integer2roman

import com.vj.leetcode.scala.TestMixin

object Integer2Roman extends TestMixin {
  tPrint("MCMXCIV") {Solution.intToRoman(1994)}
  tPrint("LVIII") {Solution.intToRoman(58)}
  tPrint("XXVI") {Solution.intToRoman(26)}
  tPrint("XI") {Solution.intToRoman(11)}
  tPrint("IX") {Solution.intToRoman(9)}
  tPrint("VIII") {Solution.intToRoman(8)}
  tPrint("I") {Solution.intToRoman(1)}
  tPrint("III") {Solution.intToRoman(3)}
  tPrint("IV") {Solution.intToRoman(4)}
  tPrint("V") {Solution.intToRoman(5)}
  tPrint("VI") {Solution.intToRoman(6)}





//  tPrint("MCMXCIV") {
//    Solution.intToRoman(1994)
//  }
}

object Solution {
  //val (I,V,X,L,C,D,M) = (1,5,10,50,100,500,1000)
  def getNum(num: Int, sym: (String, String, String)) = num match {
    case n if (n <= 3) => copy(sym._1, n)
    case n if (n < 5) => sym._1 + sym._2
    case n if (n == 5) => sym._2
    case n if (n <= 8) => sym._2 + copy(sym._1, n - 5)
    case n if (n < 10) => sym._1 + sym._3
    case _ => sym._2
  }

  def copy(str: String, times: Int): String = {
    if (times == 1) return str
    return str + copy(str, times - 1)
  }

  def intToRoman(num: Int): String = {
    val (thousands, remaining100) = getNumDivWithReminder(num, 1000)
    val (hundreds, remaining10) = getNumDivWithReminder(remaining100, 100)
    val (tens, units) = getNumDivWithReminder(remaining10, 10)
    //val (I,V,X,L,C,D,M) = (1,5,10,50,100,500,1000)
    val som:StringBuffer = new StringBuffer()
      if(thousands > 0){
        som.append(getNum(thousands,("M","","")))
      }
    if(hundreds > 0){
      som.append(getNum(hundreds,("C","D","M")))
    }
    if(tens > 0){
      som.append(getNum(tens,("X","L","C")))
    }
    if(units > 0){
      som.append(getNum(units,("I","V","X")))
    }
    som.toString
  }

  def getNumDivWithReminder(number: Int, needed: Int) = {
    ((number / needed), number % needed)
  }
}
