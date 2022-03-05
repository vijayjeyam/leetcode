package com.vj.leetcode.scala.insertIntoSortedCircularLinkedList

import com.vj.leetcode.scala.TestMixin

object InsInSrtCirLinList extends TestMixin{
tPrint(){
  val node = new Node(1)
  node.next = node
  Solution.insert(node,0)
}
}
 class Node(var _value: Int) {
    var value: Int = _value
    var next: Node = null
  }


object Solution {
  var repeatNode:Node = null
  def comp(prev: Node, head: Node,  insertVal: Int):Unit ={
    if(head == repeatNode){
      val newNode = new Node(insertVal)
      prev.next = newNode
      newNode.next = head
      return
    } else {
      (prev.value, head.value) match {
        case (a, b) if (a == b) => comp(head, head.next, insertVal)
        case (a, b) if (a < b) =>

          if (insertVal >= a && insertVal <= b) {
            val newNode = new Node(insertVal)
            prev.next = newNode
            newNode.next = head
            return
          } else {
            comp(head, head.next, insertVal)
          }
        case (a, b) if (a > b) => {
          if (insertVal >= a || insertVal <= b) {
            val newNode = new Node(insertVal)
            prev.next = newNode
            newNode.next = head
            return
          } else {
            comp(head, head.next, insertVal)
          }
        }
      }
    }
  }
  def insert(head: Node, insertVal: Int): Node = {
    if(head == null){
      val node = new Node(insertVal)
      node.next = node
      return  node
    }
    if(head.next == head){
      val node = new Node(insertVal)
      head.next = node
      node.next = head
      return  node
    }
    repeatNode = head
    comp(head,head.next,insertVal)
    head
  }
}