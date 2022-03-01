package com.vj.leetcode.scala.bestTimeBuySellStock

import com.vj.leetcode.scala.TestMixin

object BestTimeBuySellStock extends TestMixin {
  tPrint(5) {
    Solution.maxProfit(Array(7, 1, 5, 3, 6, 4))
  }
  tPrint(0) {
    Solution.maxProfit(Array(1))
  }
}

object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    if(prices.length == 1) return 0
    val dpMemo = scala.collection.mutable.Map[(Int,Int),Int]()

    def dp(buyDay: Int, sellDay: Int): Int = {
      if (buyDay == sellDay) return 0
      if (buyDay >= sellDay) return Int.MinValue
      if (dpMemo.get((buyDay,sellDay)).isEmpty) {
        val profit = prices(sellDay) - prices(buyDay)
        val maxP = if (buyDay == 0) {
          Math.max(profit, dp(buyDay, sellDay - 1))
        } else {
          Math.max(Math.max(profit, dp(buyDay - 1, sellDay)),
            Math.max(dp(buyDay, sellDay - 1), dp(buyDay - 1, sellDay - 1)))
        }
        dpMemo +=  ((buyDay,sellDay) -> maxP )
      }
      println(dpMemo.size)
      dpMemo((buyDay,sellDay))
    }
    dp(prices.length - 2, prices.length - 1)
  }
}

object Solution_old {
  def maxProfit(prices: Array[Int]): Int = {
    val dpMemo = Array.tabulate(prices.length, prices.length)((a, b) => -1)


    def dp(buyDay: Int, sellDay: Int): Int = {

      if (buyDay > sellDay || buyDay < 0 || buyDay >= prices.length || sellDay < 0 || sellDay >= prices.length) return Int.MinValue
      if (dpMemo(buyDay)(sellDay) > -1) return dpMemo(buyDay)(sellDay)
      val current = prices(sellDay) - prices(buyDay)
      println(s"dp($buyDay:Int,$sellDay:Int) = ${dpMemo(buyDay)(sellDay)}")
      dpMemo(buyDay)(sellDay) = (buyDay, sellDay) match {
        case (b, s) if (b == 0 && s == prices.length - 1) =>
          (current :: dp(b, s - 1) :: dp(b + 1, s) :: dp(b + 1, s - 1) :: Nil).max
        case (b, s) if (b == 0) =>
          (current :: dp(b, s - 1) :: dp(b, s + 1) :: dp(b + 1, s) :: dp(b + 1, s + 1) :: dp(b + 1, s - 1) :: Nil).max
        case (b, s) if (s == prices.length - 1) =>
          (current :: dp(b, s - 1) :: dp(b + 1, s) :: dp(b + 1, s - 1) :: dp(b - 1, s) :: dp(b - 1, s - 1) :: Nil).max
        case (b, s) =>
          (current :: dp(s, b + 1) :: dp(s, b - 1) ::
            dp(s - 1, b) :: dp(s - 1, b + 1) :: dp(s - 1, b - 1)
            :: dp(s + 1, b) :: dp(s + 1, b - 1) :: dp(s + 1, b + 1) :: Nil).max
      }
      println(s"dp($buyDay:Int,$sellDay:Int) = ${dpMemo(buyDay)(sellDay)}")
      dpMemo(buyDay)(sellDay)
    }

    dp(0, prices.length - 1)
  }
}