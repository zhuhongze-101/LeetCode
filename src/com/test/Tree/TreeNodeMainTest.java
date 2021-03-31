package com.test.Tree;

public class TreeNodeMainTest {

    public static void main(String[] args) {
        TreeNodeSolution treeNodeSolution = new TreeNodeSolution();
        TreeNode p =new TreeNode(2,null,new TreeNode(5));
        TreeNode q =new TreeNode(1,p,new TreeNode(3));
     //   System.out.println(treeNodeSolution.isSameTree(p,q));
     //   System.out.println(p);

      System.out.println(treeNodeSolution.binaryTreePaths(q));
    }
}
