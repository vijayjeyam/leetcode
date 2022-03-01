package com.vj.leetcode.scala.combinations

object Combinations extends App{
  Solution.combine(4,2).foreach(a => println(a.mkString(",")))
  object Solution {

    def combine(n: Int, k: Int): List[List[Int]] = {
      var out = List[List[Int]]()
      def backtrack(index:Int, list:List[Int]):Unit ={
        if(list.length == k) {
          out = list :: out;
        } else
        for(
          secondInd <- index to n
        )yield backtrack(secondInd+1,list :+ secondInd)
      }

      backtrack(1,List())
      out
    }

  }
}
