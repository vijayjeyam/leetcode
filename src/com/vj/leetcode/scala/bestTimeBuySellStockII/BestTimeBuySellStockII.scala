package com.vj.leetcode.scala.bestTimeBuySellStockII

import com.vj.leetcode.scala.TestMixin

object BestTimeBuySellStockII extends TestMixin {
  tPrint(4) {
    Solution.maxProfit(Array(1,2,3,4,5))
  }

  tPrint(0) {
    Solution.maxProfit(Array(5,4,3,2,1))
  }
  tPrint(7) {
    Solution.maxProfit(Array(7,1,5,3,6,4))
  }

  tPrint(-1) {
    Solution.maxProfit(Array(1, 5, 6, 3, 5, 7, 3, 6))
  }
  tPrint(5) {
    Solution.maxProfit(Array(7, 1, 5, 3, 6, 4))
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
    var profit:Int = 0;
    def maxProfit(currentInd:Int) : Int = {
      val buyInd = (getNext(prices,currentInd,true))
      val sellInd = getNext(prices,buyInd+1,false)
      if(buyInd == -1 || sellInd == -1){
        profit
      } else {
        profit = profit + prices(sellInd) - prices(buyInd)
        maxProfit(sellInd+1)
      }
    }
    maxProfit(0)
  }
}
