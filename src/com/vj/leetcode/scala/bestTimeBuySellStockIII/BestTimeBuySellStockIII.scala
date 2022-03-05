package com.vj.leetcode.scala.bestTimeBuySellStockIII

import com.vj.leetcode.scala.TestMixin

object BestTimeBuySellStockIII extends TestMixin {
  tPrint(13) {
    Solution.maxProfit(Array(1,2,4,2,5,7,2,4,9,0))
  }
  tPrint(6) {
    Solution.maxProfit(Array(3,3,5,0,0,3,1,4))
  }
  //  tPrint(0) {
  //    Solution.maxProfit(Array(1))
  //  }
}
object Solution {
  def getNext(nums: Array[Int], st: Int, isValey: Boolean): Int = {
    if(nums.length == st || st < 0) return -1
    val op: (Int,Int)=>Boolean =  (a: Int, b: Int) => isValey match {
      case true =>    a > b;
      case false =>   a < b;
    }
    def getNextPriv(ind: Int, current: Int): Int = {
      if(nums.length == ind) return ind-1
      if (op(nums(ind) , current)) {
        ind - 1
      } else {
        getNextPriv(ind+1,nums(ind))
      }
    }

    getNextPriv(st+1, nums(st))
  }

  def maxProfit(prices: Array[Int]): Int = {
    def maxProfit(currentInd:Int,acc:List[(Int,Int)]=Nil) :List[(Int,Int)]  = {
      val buyInd = (getNext(prices,currentInd,true))
      val sellInd = getNext(prices,buyInd+1,false)
      if(buyInd == -1 || sellInd == -1){
        acc
      } else {
        maxProfit(sellInd+1,(buyInd,sellInd) :: acc)
      }
    }
    var list1 = maxProfit(0)
    list1.foreach(println)
    var list =list1.map( a => prices(a._2) - prices(a._1)).sorted.reverse
    list1.zip(list1.map( a => (prices(a._1) , prices(a._2),prices(a._2) - prices(a._1)))).foreach(println)
    list = if(list.length>2) list.slice(0,2) else list
    list.sum
  }
}

