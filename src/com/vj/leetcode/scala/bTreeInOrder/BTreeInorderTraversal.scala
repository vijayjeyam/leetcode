package com.vj.leetcode.scala.bTreeInOrder

import com.vj.leetcode.scala.TestMixin

object BTreeInorderTraversal extends TestMixin{

}
 class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }
object Solution {
  def inorderTraversal(root: TreeNode): List[Int] = {
      if(root == null)return List()
      inorderTraversal(root.left) ::: List(root.value) ::: inorderTraversal(root.right) ::: Nil
  }
}