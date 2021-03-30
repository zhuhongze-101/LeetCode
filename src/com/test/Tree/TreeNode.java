package com.test.Tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(){}

    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        if(left ==null && right == null) return  val + "";
        return   val + " " + left + " " + right;
    }
}
