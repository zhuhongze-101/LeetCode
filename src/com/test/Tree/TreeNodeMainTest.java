package com.test.Tree;

public class TreeNodeMainTest {

    public static void main(String[] args) {
        TreeNodeSolution treeNodeSolution = new TreeNodeSolution();
        TreeNode p =new TreeNode(1,new TreeNode(2),new TreeNode(1));
        TreeNode q =new TreeNode(1,new TreeNode(1),new TreeNode(2));
        System.out.println(treeNodeSolution.isSameTree(p,q));


    }
}
