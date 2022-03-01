package com.vj.leetcode.scala.dp.divisorGame

import com.vj.leetcode.scala.TestMixin

object DivisorGame extends TestMixin {
  tPrint(true) {
    Solution.divisorGame(2)
  }
}
import com.vj.leetcode.scala.dp.divisorGame.DivisorGame.gcd

object Solution {
  def divisorGame(n: Int): Boolean = {
    def divisorGame(gameNum: Int, isAlice: Boolean): Boolean = {
      def selectNum(): Int = {
        (for (i <- 1 to gameNum - 1;
              j = gcd(i, gameNum)
              if (j != 0)
              ) yield j).last
      }

      if (gameNum == 1) return isAlice
      val selNum = selectNum()

      divisorGame(gameNum - selNum, !isAlice)

    }

    divisorGame(n, true)
  }
  final def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}