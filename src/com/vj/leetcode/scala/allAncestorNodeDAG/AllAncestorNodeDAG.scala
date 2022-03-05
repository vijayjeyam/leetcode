package com.vj.leetcode.scala.allAncestorNodeDAG

import com.vj.leetcode.scala.TestMixin

import scala.collection.mutable.ListBuffer

object AllAncestorNodeDAG extends TestMixin{
  Solution.getAncestors(5,Array(Array(0,1),Array(0,2),Array(0,3),Array(0,4),Array(1,2),Array(1,3),Array(1,4),Array(2,3),Array(2,4),Array(3,4)))
    .foreach(println)
}
object Solution {
  def getAllParent(node:Int,edges: Array[Array[Int]],acc:Set[Int]): Set[Int] ={
    val res = edges.filter(tup => tup(1) == node).map(_(0))
    if(res.length == 0) return acc

    val some = for(n <- res) yield getAllParent(n,edges,acc ++ res)
    acc ++ some.flatten
  }
  def getAncestors(n: Int, edges: Array[Array[Int]]): List[List[Int]] = {
      val result:Array[Set[Int]] = Array.fill[Set[Int]](n)(Set.empty[Int])
      for(node <- 0 until n){
        result(node)= getAllParent(node,edges,Set.empty[Int])
      }
    result.map(_.toList.sorted).toList
  }
}