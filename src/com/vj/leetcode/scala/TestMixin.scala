package com.vj.leetcode.scala

import scala.annotation.tailrec

trait TestMixin extends App{
  @tailrec
  final def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def tPrint[T](valu: T)(a: => T) = {
    val time = System.nanoTime()
    val executed = a
    val timeTaken = System.nanoTime() - time
    executed == valu match {
      case (true) => println(s"Passed in $timeTaken")
      case (false) => println(s"Expected $valu and got $executed  ")
    }

  }
  def searchIndex[T](arr:Array[T], lInd:Int, rInd:Int, comp:(T)=>Int) : Int = {
    if(arr.length == 0 || lInd > rInd) return -1
    val middle = lInd + ( rInd - lInd  )/2
    comp(arr(middle)) match {
      case 0 =>  middle
      case lesser if(lesser < 0) => searchIndex(arr,lInd,middle-1,comp)
      case greater   =>   searchIndex(arr,middle+1,rInd,comp)
    }
  }

}
case class Node[T](cont: T, var next: Node[T] = null)

object Node {
  @tailrec
  def reverse[T](node:Node[T], tempNode:Node[T]=null) : Node[T] = {
    if(node == null) return tempNode
    val toProcess= node.next
    node.next = tempNode
    reverse(toProcess, node)
  }
  def apply[T](seq: Seq[T]): Node[T] = {
    if(seq.isEmpty)return null
    val head = Node(seq.head)
    seq.tail.foldLeft(head)(
      (head, elem) => {
        head.next = Node(elem)
        head.next }
    )
    head
  }
}