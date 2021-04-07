package com.family.algorithm.tree;

public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.add(8);
        bt.add(3);
        bt.add(10);
        bt.add(1);
        bt.add(6);
        bt.add(14);
        bt.add(4);
        bt.add(7);
        bt.add(13);
        bt.print();
    }

    public static class BinarySearchTree {
        private TreeNode root;

        public void add(int data) {
            if (root == null) {
                root = new TreeNode(data);
            } else {
                root.addNode(data);
            }
        }

        public void print() {
            root.print();
        }
    }

    public static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.leftChild = null;
            this.rightChild = null;
            this.data = data;
        }

        //中序遍历
        public void print() {
            if (this.leftChild != null) {
                this.leftChild.print();
            }
            System.out.print(this.data + "->");
            if (this.rightChild != null) {
                this.rightChild.print();
            }
        }

        public void addNode(int data) {
            if (data < this.data) {
                if (this.leftChild == null) {
                    this.leftChild = new TreeNode(data);
                } else {
                    this.leftChild.addNode(data);
                }
            } else {
                if (this.rightChild == null) {
                    this.rightChild = new TreeNode(data);
                } else {
                    this.rightChild.addNode(data);
                }
            }
        }
    }
}
