package com.vj.leetcode.scala.allAncestorNodeDAG

import com.vj.leetcode.scala.TestMixin

import scala.collection.mutable.ListBuffer

object AllAncestorNodeDAG extends TestMixin{
  Solution.getAncestors(8,
    Array(Array(0,3),Array(0,4),Array(1,3),Array(2,4),Array(2,7),Array(3,5),Array(3,6),Array(3,7),Array(4,6)))
    .foreach(println)
}
object Solution {
  def getAncestors(n: Int, edges: Array[Array[Int]]): List[List[Int]] = {

    val result:Array[List[Int]] = Array.ofDim[List[Int]](n)
    def getAllParent(node:Int,edges: Array[Array[Int]]): List[Int] ={
      if(result(node) != null) return result(node)
      val res = edges.filter(tup => tup(1) == node).map(_(0))
      if(res.length == 0){
        result(node) = List.empty
        return List.empty
      }

      val some = for(n <- res) yield n :: getAllParent(n,edges )
      result(node) = some.flatten.toSet.toList
      result(node)
    }

    for(node <- 0 until n){
      getAllParent(node,edges)
    }
    result.map(_.sorted).toList
  }
}
object Solution_N {
  def getAllParent(node:Int,edges: Array[Array[Int]],acc:Set[Int],meme:Array[Set[Int]]): Set[Int] ={
    if(meme(node) != null) return meme(node)
    val res = edges.filter(tup => tup(1) == node).map(_(0))
    if(res.length == 0) {
      return acc
    }

    val some = for(n <- res) yield getAllParent(n,edges,acc ++ res,meme)
    meme(node) = some.flatten.toSet
    meme(node)
  }
  def getAncestors(n: Int, edges: Array[Array[Int]]): List[List[Int]] = {
    val meme = Array.ofDim[Set[Int]](n+1)
    val result:Array[Set[Int]] = Array.fill[Set[Int]](n+1)(Set.empty[Int])
    for(node <- 0 to n){
      result(node)= getAllParent(node,edges,Set.empty[Int],meme)
    }
    result.map(_.toList.sorted).toList
  }
}