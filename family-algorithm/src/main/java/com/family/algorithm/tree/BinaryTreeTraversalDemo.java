package com.family.algorithm.tree;

public class BinaryTreeTraversalDemo {

    public static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode() {
            this.leftChild = null;
            this.rightChild = null;
            this.data = -1;
        }

        TreeNode(int data) {
            this.leftChild = null;
            this.rightChild = null;
            this.data = data;
        }

        public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}
