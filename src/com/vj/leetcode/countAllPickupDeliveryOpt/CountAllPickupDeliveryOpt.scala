package com.vj.leetcode.countAllPickupDeliveryOpt

import com.vj.leetcode.scala.TestMixin

object CountAllPickupDeliveryOpt extends TestMixin{
  Solution.countOrders(10)
}
object Solution {

  def countOrders(n: Int): Int = {
    val dpAns = Array.ofDim[Long](n+1)
    val modulo = 1000000007
    dpAns(0) = 0
    dpAns(1) = 1
    for(num <- 4 to 2*n by 2){
      val res =  ((num*(num-1) /   2) * dpAns((num/2)-1) ) % modulo
      dpAns(num/2) = res

    }
    dpAns(n).intValue()
  }
}