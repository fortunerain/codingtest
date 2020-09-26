package com.exam.test.tree.dfsbfs;


/*
      3
     / \
     9  20
       /  \
      15   7
*/
public class MaxDepth {
  public static void main(String[] args) {
    TreeNode left1 = new TreeNode(15);
    TreeNode right1 = new TreeNode(7);
    TreeNode left = new TreeNode(9);
    TreeNode right = new TreeNode(20, left1, right1);
    TreeNode root = new TreeNode(3, left, right);

    int i = maxDepth(root);
    System.out.println(i);
  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
