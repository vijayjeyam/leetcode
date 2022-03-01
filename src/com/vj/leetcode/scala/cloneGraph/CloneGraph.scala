package com.vj.leetcode.scala.cloneGraph

import com.vj.leetcode.scala.TestMixin

object CloneGraph extends TestMixin {
  tPrint(Array[Int](0,1).mkString(",")){
    Solution2.twoSum(Array(3,3),6).mkString(",")
  }
  tPrint(Array(0,4).mkString(",")){
    Solution2.twoSum(Array(1,2,3,7,5),6).mkString(",")
  }
  tPrint(Array[Int]().mkString(",")){
    Solution2.twoSum(Array(1,2,3,7,5),100).mkString(",")
  }
  //  tPrint() {
//    val one = new Node(1)
//    val res = Solution.cloneGraph(one)
//    println(res)
//  }
//  tPrint() {
//    val one = new Node(1)
//    val two = new Node(2)
//    val three = new Node(3)
//    val four = new Node(4)
//    one.neighbors = List(two, four)
//    two.neighbors = List(one, three)
//    three.neighbors = List(two, four)
//    four.neighbors = List(one, three)
//    val res = Solution.cloneGraph(one)
//    println(res)
//  }
}

//Definition for a Node.
class Node(var _value: Int) {
  var value: Int = _value
  var neighbors: List[Node] = List()

}

object Solution {
  var nodeCache: Map[Node, Node] = Map()

  def cloneGraph(graph: Node): Node = nodeCache.get(graph) match {
    case None => {
      val ret = new Node(graph._value)
      nodeCache += (graph -> ret);
      ret.neighbors = graph.neighbors.map(cloneGraph);
      ret
    }
    case Some(others) => others
  }
}

object Solution2 {
  def searchIndex[T](arr:Array[T], lInd:Int, rInd:Int, comp:(T)=>Int) : Int = {
    if(arr.length == 0 || lInd > rInd) return -1
    val middle = lInd + ( rInd - lInd  )/2
    comp(arr(middle)) match {
      case 0 =>  middle
      case lesser if(lesser < 0) => searchIndex(arr,lInd,middle-1,comp)
      case greater   =>   searchIndex(arr,middle+1,rInd,comp)
    }
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    type T = (Int,Int)
    def targetFun(a:T)(b:T): Int ={
      target - a._1  - b._1
    }
    def twoSum(currentInd:Int = 0, numbers:Array[T]): Array[Int] = {
      searchIndex(numbers,currentInd+1,numbers.length-1,targetFun(numbers(currentInd))) match {
        case -1 =>  if(currentInd == numbers.length-1) Array() else twoSum(currentInd+1,numbers)
        case others => Array(currentInd,others)
      }
    }
    val newList = nums.zipWithIndex.sorted
    twoSum(0,newList).map(newList(_)._2)
  }
}