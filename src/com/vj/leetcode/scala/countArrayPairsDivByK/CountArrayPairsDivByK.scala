package com.vj.leetcode.scala.countArrayPairsDivByK

import scala.annotation.tailrec
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
// @TODO @VIJAY
object CountArrayPairsDivByK extends App{
//  Utils.vPrint(7L){
//    Solution.countPairs(Array(1,2,3,4,5),2)
//  } //
//  Utils.vPrint(0L){
//    Solution.countPairs(Array(1,2,3,4),5) // 0
//  } //
//
//  Utils.vPrint(18L){
//    Solution.countPairs(Array(8,10,2,5,9,6,3,8,2),6) //18
//  } //

  Utils.vPrint(3L){
    Solution1.countPairs(Array(2,4,8),8) //18
  }
  Utils.vPrint(18L){
    Solution1.countPairs(Array(8,10,2,5,9,6,3,8,2),6) //18
  } //

}
object Solution1{
  //8,10,2,5,9,6,3,8,2 6 // 2,4,8 8
  def countPairs(n: Array[Int], k: Int): Long ={
     var res:Long = 0;
     val cnt = Array.fill(100001)(0) ;
    for (i <- 0 to n.length-1) {
      if (n(i) % k == 0) {
        res += i;
        cnt(0) = cnt(0) + 1;
      }
      else {
        val div:Int = Utils.gcd(k, n(i));
        for (d <- 0 to div-1){
          val find = k / div * d
          res += cnt(find);
        }

        cnt(div) = cnt(div) + 1;
      }
    }
    return res;
  }
  def countPairs2(n: Array[Int], k: Int): Long = {
    var res: Long = 0;
    val cnt = Array.fill(100001)(0);
    for (i <- 0 to n.length-1) {
      if (n(i) % k == 0) {
        res += i;
        cnt(0) = cnt(0) + 1;
      } else {
        val div = Utils.gcd(k, n(i));
        for (
          d <- 0 to div
        ) {
          res += cnt(k / div * d);
          cnt(div) = cnt(div) + 1;
        }
      }

    }
    return res;
  }
}
object Solution {
  import scala.collection.mutable.ListBuffer
  def countPairs(nums: Array[Int], k: Int): Long = {
    var list = ListBuffer[ListBuffer[Int]]()

    val n = nums.length
    def backTrack(index:Int,currList:ListBuffer[Int]):Unit = {
      if(currList.size ==2){
        if(nums(currList.head-1) * nums(currList.last-1) % k == 0){
          list.append(currList)
        }
        return
      } else {

        for(sInd <- index to n){
          currList.append(sInd)
          backTrack(sInd+1, currList)
          currList.remove(currList.size-1)
        }
      }
    }
    backTrack(1,ListBuffer[Int]())
    list.size
  }
}
object Utils{
  @tailrec
  def gcd(a: Int, b: Int): Int = if(b==0)  a else gcd(b,a%b)

  def vPrint[T](valu:T)(a: =>T) = {
    val time = System.nanoTime()
    val executed = a
    val timeTaken =  System.nanoTime() - time
    executed == valu match{
      case(true) => println(s"Passed in $timeTaken")
      case(false) => println(s"Expected $valu and got $executed  ")
    }

  }
}