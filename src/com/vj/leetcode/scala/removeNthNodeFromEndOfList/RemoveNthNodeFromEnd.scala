package com.vj.leetcode.scala.removeNthNodeFromEndOfList

import com.vj.leetcode.scala.TestMixin

object RemoveNthNodeFromEnd extends TestMixin{
tPrint(){
  Solution.removeNthFromEnd(ListNode(1),1)
  //Solution.removeNthFromEnd(ListNode(1,ListNode(2,ListNode(3,ListNode(4,ListNode(5))))),2)
}
}
case class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    def getCount(node:ListNode,ciunt:Int = 0):Int = {
      if(node == null) return ciunt
      getCount(node.next,ciunt+1)
    }
    def getNthNode(node:ListNode,nth:Int=n):ListNode={
      if(nth == 0 || node == null) return node
      getNthNode(node.next,nth-1)
    }
    val count = getCount(head)
    if(count <= n) {
      return null
    }
    val nthNode = getNthNode(head,count-n-1)
    nthNode.next = nthNode.next.next
    head
  }
}