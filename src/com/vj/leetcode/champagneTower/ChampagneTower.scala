package com.vj.leetcode.champagneTower

import com.vj.leetcode.scala.TestMixin

object ChampagneTower extends TestMixin{
  tPrint(1.000){
    Solution.champagneTower(poured = 100000009, query_row = 33, query_glass = 17)
  }
}
object Solution {
  def distribute(parent:Champagne): Unit ={
    if(parent.content <1) return
    val contentToDistribute = (parent.content-1)/2
    parent.content = 1
    if(contentToDistribute > 0){
      if(parent.left!=null){
        parent.left.content = parent.left.content + contentToDistribute
      }
      if(parent.right !=null ){
        parent.right.content = parent.right.content + contentToDistribute
      }
    }
  }
  class Champagne(){
    var content:Double = 0
    var left:Champagne = null
    var right:Champagne = null
  }
  def champagneTower(poured: Int, query_row: Int, query_glass: Int): Double = {
    val rows:scala.collection.mutable.Map[Int,scala.collection.mutable.Map[Int,Champagne]] = scala.collection.mutable.Map[Int,scala.collection.mutable.Map[Int,Champagne]]()
    for(i <- query_row to 0 by -1){
     if(!rows.contains(i)) {
       rows += (i->scala.collection.mutable.Map[Int,Champagne]())
      }
      val min = Math.max(0,query_glass - (query_row-i))
      val max = Math.min(query_glass,i)
      for(ind <- min to max){
        val newChamp = new Champagne()
        rows(i) = rows(i) + (ind -> newChamp)
        if(ind < query_row){
          rows.get(i+1).foreach(_.get(ind+1).foreach(newChamp.right = _))
          rows.get(i+1).foreach(_.get(ind).foreach(newChamp.left = _))
        }
      }
    }
    rows(0)(0).content = poured
    for(ind <- 0 until rows.size){
      rows(ind).foreach(champWithIndex => distribute(champWithIndex._2))
    }
    //mainCup.fill(poured)
    rows(query_row)(query_glass).content
  }
}