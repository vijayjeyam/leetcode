package com.vj.leet.verticalordtrav;

import com.sun.source.tree.Tree;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VertOrdTraBiTree {
}

/*
 * Definition for a binary tree node.
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15,new TreeNode(9),new TreeNode(20,new TreeNode(3),new TreeNode(7)));


        root = new TreeNode(3,new TreeNode(1,new TreeNode(0),new TreeNode(2)),new TreeNode(4,new TreeNode(2),null));
        root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(6)),new TreeNode(3,new TreeNode(5),new TreeNode(7)));
        root = new TreeNode(3,new TreeNode(1,new TreeNode(0),new TreeNode(2)),new TreeNode(4,new TreeNode(2),null));
        root = new TreeNode(0,new TreeNode(5,new TreeNode(9),null),
        new TreeNode(1,new TreeNode(2,null,new TreeNode(3,new TreeNode(4,new TreeNode(6,new TreeNode(7),null),null),new TreeNode(8))),null));
        Solution solution = new Solution();
        solution.traverse(root);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        return traverse(root);
    }

    private List<List<Integer>> traverse(TreeNode root){
        List<List<List<Integer>>> result = new ArrayList<>();
        offset = 0;
        populate(0,0,root,result);
        List<List<Integer>> transformed = new ArrayList<>();
        for (List<List<Integer>> integers : result) {
            transformed.add(getFlatList(integers));
        }
        //transformed.forEach(a -> System.out.println(a));
        return transformed;
    }

    private List<Integer> getFlatList(List<List<Integer>> integers) {
        List<Integer> res = new ArrayList<>();

        for(int ind = integers.size()-1; ind >=0 ;ind--){
            List<Integer> ints =  integers.get(ind);
            Collections.sort(ints);
            //for (int i = 0; i < ints.size() ; i++) {
            for (int i = ints.size()-1; i >=0 ; i--) {
                res.add(0,ints.get(i));
            }
        }
        return res;

    }
    private int offset;
    private void populate(int currX,int curY,TreeNode root, List<List<List<Integer>>> result) {
         populateNode(root.val,result,currX,curY);
        if(root.left != null )
            populate(currX-1,curY+1, root.left,result);
        if(root.right != null )
            populate(currX+1,curY+1, root.right,result);


    }
    private void populateNode(int val, List<List<List<Integer>>> res, int x,int y){
         int lendth  = x + offset + 1;
        List<List<Integer>> result = null;
         if(lendth > 0 && res.size() >= lendth){
             result =  res.get(x+offset);
         } else {
             result = new ArrayList<>();

            if(x < 0){
                offset++;
                res.add(0,result);
            } else {
                res.add(result);
            }
         }
         if(result.size() >= y+1){
             result.get(y).add(val);
         } else {
             List<Integer> integers = new ArrayList<>();
             for(int j = result.size()-1; j < y; j++){
                 result.add(new ArrayList<>());
             }
             result.get(y).add(val);
         }
    }
}