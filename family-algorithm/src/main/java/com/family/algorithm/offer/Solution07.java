package com.family.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Solution07 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0) {
            return null;
        }
        int root = preorder.get(0);
        TreeNode rootNode = new TreeNode(root);
        int i = inorder.indexOf(root);
        if (i > 0) {
            rootNode.left = buildTree(preorder.subList(1, 1 + i), inorder.subList(0, i));
        }
        int rightLength = inorder.size() - i - 1;
        if (rightLength > 0) {
            rootNode.right = buildTree(preorder.subList(i + 1, inorder.size()), inorder.subList(i + 1, inorder.size()));
        }
        return rootNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(Arrays.stream(preorder).boxed().collect(Collectors.toList()), Arrays.stream(inorder).boxed().collect(Collectors.toList()));
    }
}
