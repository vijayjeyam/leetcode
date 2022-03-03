package com.vj.leetcode.scala.validateBST

import com.vj.leetcode.scala.TestMixin
// TODO
object ValidateBST extends TestMixin {

  tPrint(false){
    Solution.isValidBST(new TreeNode(32,
      _left = new TreeNode(26,
        _left =  new TreeNode(19),
        null),
      _right = new TreeNode(47,
        null,
        new TreeNode(56,null,new TreeNode(27)))))
  }

//  tPrint(true){
//    Solution.isValidBST(new TreeNode(3,new TreeNode(1,new TreeNode(0),new TreeNode(2)),new TreeNode(5,new TreeNode(4),new TreeNode(6))))
//  }
//
//  tPrint(false){
//  Solution.isValidBST(new TreeNode(1,null,new TreeNode(1)))
//}
}

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def isValid(parent: TreeNode, isRight: Boolean)(node: TreeNode): Boolean = {
    if (node == null) return true;
    val ret = ((node.left == null || (node.left.value < node.value &&
      (parent == null || (  if (isRight) {parent.value < node.left.value }else{ parent.value > node.left.value}))
    ) )&&
    (node.right == null || (node.right.value > node.value &&
      (parent == null ||(if (isRight) {parent.value < node.right.value }else {parent.value > node.right.value}))
    ) ))
    if(ret == false) println((parent,node))
    return ret
  }

  def postorderTraversal(root: TreeNode,
                         parent: TreeNode,
                         basevalidator: (TreeNode, Boolean) => TreeNode => Boolean,
                         validator: TreeNode => Boolean): Boolean = {
    if (root == null) return true
    postorderTraversal(root.left,root, basevalidator, basevalidator(parent, false)) &&
      postorderTraversal(root.right, root, basevalidator, basevalidator(root, true)) &&
      validator(root)

  }

  def isValidBST(root: TreeNode): Boolean = {
    postorderTraversal(root,root, isValid, isValid(null,true))
  }
}