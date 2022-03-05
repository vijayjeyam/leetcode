package com.vj.leetcode.scala.dp.coinChange

import com.vj.leetcode.scala.TestMixin

object CoinChange extends TestMixin{
  tPrint(-1){Solution.coinChange(Array(2),3)}
tPrint(3){Solution.coinChange(Array(1,2,5),11)}

  tPrint(0){Solution.coinChange(Array(1),0)}
}

object Solution {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val memo = Array.fill(amount+1)(Int.MinValue)
    memo(0) = 0
    for(coin <- coins){if(coin <= amount) memo(coin) = 1}
    def dp(money:Int):Int = {
      if(money<0) return -1
      if(memo(money) == Int.MinValue){
        var best = Int.MaxValue
        for(coin <- coins){
          val numCoinsRemain = dp(money-coin)
          if(-1 == numCoinsRemain) {} else best  = Math.min(best,1 + dp(money-coin))
        }
        memo(money) = if(best == Int.MaxValue) -1 else best
      }
      memo(money)
    }
    dp(amount)
  }
}