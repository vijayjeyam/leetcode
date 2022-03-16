package com.vj.leetcode.scala.rotateList

import com.vj.leetcode.scala.TestMixin

object RotateList extends TestMixin{

  tPrint("51234") {
    Solution.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5))))), 1).toString
  }
  tPrint("201"){
  Solution.rotateRight(new ListNode(0,new ListNode(1,new ListNode(2))),4).toString
}
}
 class ListNode(_x: Int = 0, _next: ListNode = null) {
   var next: ListNode = _next
   var x: Int = _x

   override def toString: String = s"$x${if(next!=null) next else ""}"
 }

object Solution {

  def getLastNodeWithIndex(head: ListNode, index:Int = 0):(ListNode,Int) = {
    if(head ==null) return (head,index)
    if(head.next == null) return (head,index+1)
    getLastNodeWithIndex(head.next,index+1)
  }

  def moveRight(head: ListNode,i: Int): ListNode = {
    if(i ==0) {
      head
    } else {
      moveRight(head.next,i-1)
    }
  }

  def rotateRight(head: ListNode, k: Int): ListNode = {
    if(head == null || k == 0) return head
    val (lastNode:ListNode,index:Int) = getLastNodeWithIndex(head)
    lastNode.next=head
    val node = moveRight(head,index  - (k%index) - 1 )
    val res = node.next
    node.next = null
    res
  }
}