package com.vj.leetcode.scala.palindromeLinkList

object PalindromeLinkList extends App {
  val list = new ListNode(1,new ListNode(2, new ListNode(2, new ListNode(1))))
  println(Solution.isPalindrome(list))
}

/**
 * Definition for singly-linked list.
 */
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  override def toString: String = s"[ x= $x , $next ]"
  }

object Solution {
  def isPalindrome(head: ListNode): Boolean = {
    val list = reverse(midList(head,head))
    checkSame(head,list)

  }
  def checkSame(node: ListNode, toCheck: ListNode): Boolean= toCheck match {
    case a if(a != null) => if(a.x == node.x) checkSame(node.next,toCheck.next) else false
    case others => true
  }
  def reverse(head: ListNode , current : ListNode = null): ListNode = head match {
    case elem if(elem == null) => current
    case other => reverse(head.next, new ListNode(head.x,current))
  }

  def midList(slow:ListNode, fast:ListNode):ListNode = fast match {
    case some if(some.next == null || some.next.next == null)=> slow.next
    case others => midList(slow.next,fast.next.next)
  }
}