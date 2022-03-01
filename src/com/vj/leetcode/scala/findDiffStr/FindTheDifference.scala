package com.vj.leetcode.scala.findDiffStr

object FindTheDifference extends App{
println(Solution.findTheDifference("vijyaya","vijaya"))
}
object Solution {
  def findTheDifference(s: String, t: String): Char = {
  val nums:Array[Int] = Array.ofDim(26)
    def update(chars:List[Char]):Unit = chars match {
      case ch :: tail => nums(ch - 'a') = nums(ch - 'a') + 1; update(tail)
      case Nil =>
    }
    update(s.toList);update(t.toList)
    val charInt = (for{
      ind <- 0 to 25;
      if nums(ind)%2 == 1
    }yield ind)
    (charInt(0)+'a').asInstanceOf[Char]
  }
}