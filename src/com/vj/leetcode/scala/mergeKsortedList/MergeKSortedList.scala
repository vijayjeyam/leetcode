package com.vj.leetcode.scala.mergeKsortedList

import com.vj.leetcode.scala.TestMixin
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
  override def toString:String = s"$x"
}

object MergeKSortedList extends TestMixin{
tPrint(){
  Solution.mergeKLists(
    Array(
      new ListNode(1,new ListNode(3)),
      new ListNode(2)))
}
}
object Solution {

  def merge(first: ListNode, second: ListNode): ListNode = {
    var headNode = new ListNode(Int.MinValue)
    val something = headNode
    def appendAll(firstN: ListNode): Unit ={
      if(firstN == null) return
      headNode.next=firstN
      headNode = headNode.next
      appendAll(firstN.next)

    }
    def priv_merge(firstN: ListNode, secondN: ListNode):Unit = {
      if(firstN == null) {appendAll(secondN); return }
      if(secondN == null) {appendAll(firstN); return }
      if(firstN.x > secondN.x) return priv_merge(secondN,firstN)
      headNode.next=firstN
      headNode = headNode.next
      priv_merge(firstN.next,secondN)
    }

    priv_merge(first,second)
    something.next
  }

  def mergeKLists(lists: Array[ListNode]): ListNode = {
    if(lists.length == 0) return null
    if(lists.length == 1) return lists(0)
    var head = lists(0)
    for(list <- lists.tail){
      head = merge(head,list)
    }
    head
  }
}