package com.vj.leetcode.scala.minsubarr

object MinSubArray extends App{
println(Solution.minSubArrayLen(7,Array(2,3,1,2,4,3))==2)
  println(Solution.minSubArrayLen(4,Array(1,4,4))==1)
}

object Solution {
  def minSubArrayLen(target: Int, numbers: Array[Int]): Int = {
    val length = numbers.length
    def  window(acc:Int=0, winSize:Int = 0, st:Int=0, end:Int=0,size:Int): Int = {
      //println(s"window($acc:acc, $winSize:winSize, $st:st, $end:end,$size:size)")
      if(end == length || st == length || st > end)
        return size
       if(acc > target){
         window(acc - numbers(st),winSize-1, st+1,end,size)
       } else if(acc == target){
         window(acc - numbers(st),winSize-1, st+1,end,if(winSize > size)size else winSize-1)
       } else {
       numbers(end) + acc match {
         case num if num == target => window(num, winSize-1, st+1,end,if(winSize > size)size else winSize+1)
         case num =>  window(num,winSize+1, st,end+1,size)
       }
       }

    }
    window(size = Int.MaxValue) match {
      case Int.MaxValue => 0
      case other => other
    }
  }
}