package com.vj.leetcode.java.add2PolynomialsLinList;

public class Add2PolynomialsLinList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addPoly(
                new PolyNode(2,2,new PolyNode(4,1, new PolyNode(3,0))),
        new PolyNode(3,2,new PolyNode(-4,1,new PolyNode(-1,0))));
    }
}
  class PolyNode {
      int coefficient, power;
      PolyNode next = null;

      PolyNode() {}
      PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
      PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
  }
class Solution {
    private void merge(PolyNode poly1, PolyNode poly2,PolyNode temp){
        if(poly1 == null) {temp.next = poly2; return;}
        if(poly2 == null) {temp.next = poly1; return;}

        if(poly1.power == poly2.power){
            int coeff = poly1.coefficient + poly2.coefficient;
            if(coeff != 0)
                temp.next = new PolyNode(coeff,poly1.power);
            merge(poly1.next, poly2.next,temp);
        }else if(poly1.power > poly2.power){
            temp.next = poly1;
            merge(poly1.next, poly2,temp.next);
        }else {
            temp.next = poly2;
            merge(poly1, poly2.next,temp.next);
        }
    }
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode tempPoly = new PolyNode();

        merge(poly1,poly2,tempPoly);

        return tempPoly.next;
    }
}