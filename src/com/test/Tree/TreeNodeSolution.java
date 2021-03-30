package com.test.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeSolution {
    //判断二叉树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return  false;
        return  isSameTree(p.left,q.left) && isSameTree(p.right,q.right) && p.val == q.val;
    }
    //判断二叉树是否对称 对称性：左子树。val = 右子树。val 左子树的左子树与右子树的右子树对称
    public boolean isSymmetric(TreeNode root) {

        return IsMorrir(root.right,root.left);
    }

    public  boolean IsMorrir(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return  false;
        return  IsMorrir(right.left,left.right)
                && IsMorrir(right.right,left.left) && right.val == left.val;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1+ Math.max(maxDepth(root.right),maxDepth(root.left));
    }
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
    private HashMap<TreeNode,Integer> heghts = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode root){
        if(root == null)return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right =recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left-right) < 2 ? Math.max(left, right)+1 : -1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int dapth = Integer.MAX_VALUE;
        if(root.left!= null)
            dapth = Math.min(minDepth(root.left),dapth);
        if(root.right!= null)
            dapth = Math.min(minDepth(root.right),dapth);
        return dapth + 1;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return  false;
        if(root.right == null && root.left == null){
            return targetSum == root.val;
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return  null;
        if(root.left == null && root.right == null) return  root;
        TreeNode temp1 = invertTree(root.left);
        TreeNode temp2 = invertTree(root.right);
        root.right = temp1;
        root.left = temp2;
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        if(root.val > p.val && root.val < q.val) return root;
        else if(root.val > p.val && root.val > p.val) return lowestCommonAncestor(root.left,p,q);
        else return  lowestCommonAncestor(root.right,p,q);
    }



}
