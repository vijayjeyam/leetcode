package com.vj.leetcode.sortList

case class SortList()

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
  override def toString: String = s"[ x= $x , $next ]"
}

object Solution {
  def sortList(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    val mid = getMid(head)
    val left = sortList(head)
    val right = sortList(mid)
    merge(left, right)
  }

  def merge( lista: ListNode, listb: ListNode): ListNode = {
    var (list1,list2) = (lista,listb);

    val dummyHead = new ListNode
    var tail = dummyHead
    while ( {
      list1 != null && list2 != null
    })
      if (list1.x < list2.x) {
      tail.next = list1
      list1 = list1.next
      tail = tail.next
    }
    else {
      tail.next = list2
      list2 = list2.next
      tail = tail.next
    }
    tail.next = if (list1 != null) list1
    else list2
    dummyHead.next
  }

  def getMid(head1: ListNode): ListNode = {
    var head = head1

    var midPrev:ListNode = null
    while ( {
      head != null && head.next != null
    }) {
      midPrev = if (midPrev == null) head
      else midPrev.next
      head = head.next.next
    }
    val mid = midPrev.next
    midPrev.next = null
    mid
  }
}
