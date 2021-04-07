package com.family.algorithm.tree;

public class AvlTreeDemo {

    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();
        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(1);
    }

    /**
     * 定义AVL树的节点，和二叉搜索树的区别在于多了一个height属性
     * 一层的树的高度为1
     */
    public static class Node {
        private final int data;
        private Node left;
        protected Node right;
        private int height;

        public Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    public static class AvlTree {
        private Node root;

        public void insert(int key) {
            root = insert(root, key);
        }

        private static int height(Node node) {
            if (node == null) {
                return 0;
            }
            return node.height;
        }

        /**
         * 插入
         *
         * @param root 局部根节点
         * @param key  值
         * @return 新的根节点
         */
        private static Node insert(Node root, int key) {
            if (root == null) {
                return new Node(key);
            }

            if (root.data == key) {
                return root;
            }

            if (key < root.data) {
                root.left = insert(root.left, key);
            } else {
                root.right = insert(root.right, key);
            }

            if (Math.abs(height(root.left) - height(root.right)) > 1) {
                root = balance(root);
            }
            refreshHeight(root);
            return root;
        }

        private static void refreshHeight(Node node) {
            node.height = Math.max(height(node.left), height(node.right)) + 1;
        }

        private static Node balance(Node node) {
            Node node1, node2;
            // ll
            if (height(node.left) > height(node.right) &&
                    height(node.left.left) > height(node.left.right)) {
                node1 = node.left;
                node.left = node1.right;
                node1.right = node;
                refreshHeight(node);
                return node1;
            }
            // lr
            if (height(node.left) > height(node.right) &&
                    height(node.left.right) > height(node.left.left)) {
                node1 = node.left;
                node2 = node.left.right;
                node.left = node2.right;
                node1.right = node2.left;
                node2.left = node1;
                node2.right = node;

                refreshHeight(node);
                refreshHeight(node1);
                return node2;
            }
            // rr
            if (height(node.right) > height(node.left) &&
                    height(node.right.right) > height(node.right.left)) {
                node1 = node.right;
                node.right = node1.left;
                node1.left = node;

                refreshHeight(node);
                return node1;
            }
            // rl
            if (height(node.right) > height(node.left) &&
                    height(node.right.left) > height(node.right.right)) {
                node1 = node.right;
                node2 = node.right.left;
                node.right = node2.left;
                node1.left = node2.right;
                node2.left = node;
                node2.right = node1;

                refreshHeight(node);
                refreshHeight(node1);
                return node2;
            }
            return node;
        }
    }
}
