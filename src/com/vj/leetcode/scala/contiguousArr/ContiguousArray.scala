package com.vj.leetcode.scala.contiguousArr

object ContiguousArray extends App {
  println(Solution.findMaxLength(Array(0, 1, 1, 0, 1, 1, 1, 0)) == 4)
  println(Solution.findMaxLength(Array(0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1)))
  println(Solution.findMaxLength(Array(0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1)))

  println(Solution.findMaxLength(Array(1, 1, 1, 1, 1, 1, 1, 1)))
  println(Solution.findMaxLength(Array(0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1)) == 68)

  println(Solution.findMaxLength(Array(0, 0, 1, 0, 0, 0, 1, 1)) == 6)
  println(Solution.findMaxLength(Array(1, 0, 1)) == 2)
  println(Solution.findMaxLength(Array(1)) == 0)
  println(Solution.findMaxLength(Array(1, 0)) == 2)
  println(Solution.findMaxLength(Array(1, 1, 0, 0)) == 4)
}
object Solution{
  def findMaxLength(arr: Array[Int]): Int = {
    def map(arr: Array[Int], fun: (Int, Int) => Int, value: Int = 0, index: Int = 0): Array[Int] = index match {
      case in if in == arr.length => arr
      case _ =>
        val newVal = fun(value, arr(index))
        arr(index) = newVal;
        map(arr, fun, newVal, index + 1)
    }
    def getRevIndex(arr: Array[Int], toFind: Int, st: Int): Int = {
      def getRevIndex(st: Int, end: Int): Int = {
        arr(end - 1) match {
          case _ if (st == (end - 1)) => st
          case num if (num == toFind) => end
          case _ => getRevIndex(st, end - 1)
        }
      }

      val res = getRevIndex(st, arr.length)
      //println(s" Checking for Rev Index for $toFind  found $res")
      res;
    }
    def findMaxSep(): Int = {
      def findMax(max: Int, st: Int): Int = {
        if (st >= arr.length) throw new RuntimeException("illegal");
        val numToFind = arr(st);
        getRevIndex(arr, numToFind, 0) match {
          case index if (arr.length - st <= max) => max
          case index if ((index - st) > max) => findMax(index - st, st + 1)
          case index => findMax(max, st + 1)
        }
      }
      map(arr, (valu, num) => if (num == 0) valu - 1 else valu + 1)
      val zeroIndex = getRevIndex(arr, 0, 0) + 1
      val res = findMax(zeroIndex, 0)
      //println(s" Checking for Max found $res")
      res - 1
    }
    findMaxSep()
  }
}
object Solution2 {
  def findMaxLength(nums: Array[Int]): Int = {
    var count = 0;
    var index = 0

    def map(toMap: Seq[Int], mapped: Seq[(Int, Int)] = Array[(Int, Int)]()): Seq[(Int, Int)] = toMap match {
      case Seq() => (0, 0) +: mapped
      case Seq(1, others@_*) => count = count + 1; index = index + 1; map(others, mapped :+ (index, count))
      case Seq(0, others@_*) => count = count - 1; index = index + 1; map(others, mapped :+ (index, count))
    }

    map(nums).groupBy(_._2).filter(_._2.length > 1).map(a => a._2.last._1 - a._2.head._1).fold(0)((a, b) => if (a > b) a else b)
  }
}

object Solution1 {
  def findMaxLength(nums: Array[Int]): Int = {
    val one = nums.filter(_ == 1).length
    val zero = nums.filter(_ == 0).length
    val max = if (one > zero) {
      one * 2
    } else zero * 2

    def findMaxLength_(st: Int, winSize: Int, oneCount: Int, zeroCount: Int, current: Int = Integer.MIN_VALUE): Int = {
      println(s"  $st $winSize , one = $oneCount zerp = $zeroCount , $current")
      if (winSize < current) return current
      //    if(0 < current) return current

      val head = nums(st)
      val tail = nums(st + winSize - 1)
      (oneCount, zeroCount, head, tail) match {
        case (0, _, _, _) => 0
        case (_, 0, _, _) => 0
        case (oneC, zeroC, _, _) if (oneC == zeroC) => {
          if (winSize > current) winSize else current
        }
        case (oneC, zeroC, h, t) if (oneC > zeroC) && (h == 1 || t == 1) => {
          if (h == 1) {
            findMaxLength_(st + 1, winSize - 1, (oneC - 1), zeroC, current)
          } else {
            findMaxLength_(st, winSize - 1, (oneC - 1), zeroC, current)
          }
        }
        case (oneC, zeroC, h, t) if (oneC < zeroC) && (h == 0 || t == 0) => {
          if (h == 0) {
            findMaxLength_(st + 1, winSize - 1, oneC, zeroC - 1, current)
          } else {
            findMaxLength_(st, winSize - 1, oneC, zeroC - 1, current)
          }
        }

        case (oneC, zeroC, _, _) => {
          var left = findMaxLength_(st + 1, winSize - 1, if (head == 1) (oneC - 1) else oneC, if (head == 0) (zeroC - 1) else zeroC, current)
          left = if (left > current) left else current
          findMaxLength_(st, winSize - 1, if (tail == 1) (oneC - 1) else oneC, if (tail == 0) (zeroC - 1) else zeroC, left)
        }
      }
    }

    nums match {
      case Array(one) => 0
      case _ => findMaxLength_(0, nums.length, one, zero)
    }

  }

}