package com.test.Tree;

import java.util.*;

public class TreeNodeSolution {
    //判断二叉树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }

    //判断二叉树是否对称 对称性：左子树。val = 右子树。val 左子树的左子树与右子树的右子树对称
    public boolean isSymmetric(TreeNode root) {
        return IsMorrir(root.right, root.left);
    }

    public boolean IsMorrir(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return IsMorrir(right.left, left.right)
                && IsMorrir(right.right, left.left) && right.val == left.val;
    }

    //获得二叉树最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }

    //深度
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

    //给定一个二叉树，判断它是否是高度平衡的二叉树。
    //本题中，一棵高度平衡二叉树定义为：
    //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    //获得二叉树最小深度
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int dapth = Integer.MAX_VALUE;
        if (root.left != null)
            dapth = Math.min(minDepth(root.left), dapth);
        if (root.right != null)
            dapth = Math.min(minDepth(root.right), dapth);
        return dapth + 1;
    }

    //给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
    //叶子节点 是指没有子节点的节点。
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/path-sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.right == null && root.left == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    //翻转一棵二叉树。
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode temp1 = invertTree(root.left);
        TreeNode temp2 = invertTree(root.right);
        root.right = temp1;
        root.left = temp2;
        return root;
    }

    //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    //百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    //链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        if (root.val > p.val && root.val < q.val) return root;
        else if (root.val > p.val && root.val > p.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }

    List<String> tempResult;
    //返回二叉树所有路径(广度搜索法)

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> queueStr = new LinkedList<>();
        queue.offer(root);

        queueStr.offer(Integer.toString(root.val));
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            String str = queueStr.poll();
            if (node.left == null && node.right == null) {
                result.add(str);
            } else {
                if (node.left != null) {
                    queue.offer(node.left);
                    queueStr.offer(new StringBuffer(str).append("->").append(node.left.val).toString());
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    queueStr.offer(new StringBuffer(str).append("->").append(node.right.val).toString());
                }
            }

        }
        return result;

    }


}
