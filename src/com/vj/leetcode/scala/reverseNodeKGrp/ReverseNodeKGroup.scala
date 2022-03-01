package com.vj.leetcode.scala.reverseNodeKGrp

import com.vj.leetcode.scala.TestMixin

object ReverseNodeKGroup extends TestMixin {
  println(Solution.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3))
}

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x

  override def toString: String = s" $x  ${
    if (next != null) {
      ", " + next.toString
    } else {
      "null"
    }
  }"
}

object Solution {
  def reverse(node: ListNode, current: ListNode = null): ListNode = {
    if (node == null) return current
    val temp = node.next
    node.next = current
    reverse(temp, node)
  }

  def split(node: ListNode, temp: ListNode = null, count: Int): (Int, ListNode, ListNode) = {
    if (temp == null) {
      return split(node, node, count-1)
    }
    if (count == 0 || node.next == null) {
      if (node != null) {
        val tempL = node.next;
        node.next = null
        return (count, tempL, temp)
      } else {
        return (count, node, temp)
      }
    }
    split(node.next, temp, count - 1)
  }
  def getLastNode(a: ListNode): ListNode = {
    if (a.next == null) return a
    getLastNode(a.next)
  }

  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    def splitAndRevIfKElem(nodeT: ListNode): List[ListNode] = {
      var node = nodeT
      val nodeList = scala.collection.mutable.ListBuffer[ListNode]()
      while (node != null) {
        val (a, b, c) = split(node, count = k)
        node = b
        if (a == 0) {
          nodeList.append(reverse(c))
        } else {
          nodeList.append(c)
        }
      }
      nodeList.toList
    }


    val splitL: List[ListNode] = splitAndRevIfKElem(head)
    var toAppend = getLastNode(splitL.head)
    val result = splitL.head
    for (eList <- splitL.tail) {
      toAppend.next = eList
      toAppend = getLastNode(toAppend)
    }
    result
  }
}