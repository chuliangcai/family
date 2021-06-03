package com.family.algorithm.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution523 {
    public static void main(String[] args) {
        int[] nums = {5,0,0,0};
        boolean a = checkSubarraySum2(nums,3);
        System.out.println(a );
    }

    //方法1，最土的办法，时间复杂度不符合要求
    public static boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = (i + 1); j < nums.length; j++) {
                sum += nums[j];
                if (i == 0 && j == 2) {
                    System.out.println(sum);
                }
                if (sum % k == 0) {
                    System.out.println(i + ":" + j + ":" + sum);
                    return true;
                }
            }
        }
        return false;
    }

    //方法2，同余定理+哈希表
    public static boolean checkSubarraySum2(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        // 如果 i-j的子数组满足条件的话。
        // 如果pre(j)%k = pre(i)%k 并且 j>i+1 满足条件
        int[] pre = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            pre[i] = sum;
            if (pre[i] % k == 0 && i > 0) {
                return true;
            }
        }
        Set<Node> a = new HashSet<>();
        for (int i = 0; i < pre.length; i++) {
            Node node = new Node(pre[i] % k, i);
            if (a.contains(node)) {
                return true;
            }
            a.add(node);
        }
        return false;
    }

    public static class Node {
        int y;
        int index;

        public Node(int y, int index) {
            this.y = y;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            Node other = (Node) o;
            return other.y == this.y && Math.abs(other.index - this.index) > 1;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y);
        }
    }
}
