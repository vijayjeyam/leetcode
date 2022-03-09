package com.vj.leetcode.scala.removeDuplicates

import com.vj.leetcode.scala.TestMixin

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
object RemDupSortedListii extends TestMixin{
  tPrint(null.asInstanceOf[ListNode]){
    Solution.deleteDuplicates(new ListNode(1,new ListNode(1)))
  }

  tPrint(new ListNode(1).toString){
  Solution.deleteDuplicates(new ListNode(1,new ListNode(2,new ListNode(2)))).toString
}

}

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
  override def toString():String = s"[$x [$next]]"
}

object Solution {
  def deleteDuplicates(head: ListNode): ListNode = {
    val tempNode = new ListNode(0,head)
    def skip(node:ListNode,target:Int):ListNode ={
      if(node == null) return node
      if(node.x == target) return skip(node.next,target)
      node
    }

    def checkNode( newN:ListNode, prevNode:ListNode): Unit ={
      if(newN == null)return
      if(newN.next != null && newN.x == newN.next.x){
        val skipped = skip(newN.next,newN.x)
        prevNode.next = skipped
        checkNode(skipped,prevNode)
      } else {
        prevNode.next=newN
        val toProcess = newN.next
        newN.next = null
        checkNode(toProcess,newN)
      }
    }
    checkNode(head,tempNode)
    tempNode.next
  }
}
