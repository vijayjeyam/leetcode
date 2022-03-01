package com.vj.leetcode.scala.trappRainWater

object TrappRainWater extends App {
  println(Solution.countEven(910)) // 455
  println(Solution.countEven(564)) // 281
  //println(Solution.maximumEvenSplit(2))
  //println(Solution4.coutPairs(Array(3,2,6,1,8,4,1),3)) //11
//  println(Solution.goodTriplets(Array(4,0,1,3,2),
//  Array(4,1,0,2,3)))
//  println(Solution.goodTriplets(Array(2,0,1,3),Array(0,1,2,3)))
}
object Solution {
  def countEven(num: Int): Int = {
    val to1000 = if((num != 1000)) 0 else 1
    val to100 = if((num / 100) % 2 != 1)0 else 1
    val toRem = if((num / 10) % 2 == 1)0 else 1


    val out = if((toRem + to100 + to1000 )%2 == 0){
      num -1
    } else {num}
    out/2
  }
}
object SolutionW {
  def coutPairs(nums: Array[Int], k: Int): Long = {
    val out = for {
      numb <- 0 to nums.length - 1
      some <- if( nums(numb)!=0 && nums(numb) % k == 0){
        (numb to nums.length-2)//.map((nums(numb),_))
      } else  for {
        elem <- numb+1 to nums.length - 1
        if (nums(elem) * nums(numb) % k == 0)
      }yield (0)
    }yield  some
    //out.foreach(println)
    out.size
  }
}
object Solution3 {
  def countPairs(nums: Array[Int], k: Int): Int = {
     val some = nums.filter(n => n == 0 || n % k == 0).zipWithIndex.groupBy(_._1)
      val output = for {
        valu <- some
         list = valu._2.map(_._2)
         some : List[Array[Int]] = list.combinations(2).toList
         res = for(
          elem <- some
          if(elem.head*elem.last %k == 0)
            )yield (elem.head,elem.last)
      } yield res
    output.flatten.size
  }
}
object Solution2 {
  def goodTriplets(nums1: Array[Int], nums2: Array[Int]): Long = {
    val len = nums1.length - 1
    val ans = for {n1 <- 0 to len
                   firstNum = nums1(n1)
                   ans1 =  {
                     val ans2 = for {n2 <- n1 + 1 to len
                                     secondNum = nums1(n2)
                                     ans3 = if (nums2.indexOf(firstNum) < nums2.indexOf(secondNum) ) {
                                       val a = for {n3 <- n2 + 1 to len
                                                    thirdNum = nums1(n3)
                                                    if (nums2.indexOf(secondNum) < nums2.indexOf(thirdNum) )
                                                    } yield (firstNum, secondNum, thirdNum)
                                       a
                                     } else {
                                       List()
                                     }
                                     } yield ans3
                     ans2.flatten
                   }
                   } yield ans1

    ans.flatten.length
  }
}
object Solutionff {
  def maximumEvenSplit(finalSum: Long): List[Long] = {
    if(finalSum%2 == 1) return List()
    val some = 2L to finalSum  by 2
    val res = for{
      len <- 1 to some.length
      a <- some combinations len
      if(a.sum == finalSum)
    }yield a
    if(res.length > 0) res.last.toList else List()
  }
}
object Solutions {
  def sumOfThree(num: Long): Array[Long] = {
    val numSt = num - 3;
    val ans = numSt / 3
    if (numSt % 3 == 0)
      (ans to ans + 2).toArray
    else
      Array(0)
  }
}