package com.family.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution525 {
    public static void main(String[] args) {
        Solution525 solution525 = new Solution525();
        int[] nums = {0, 1, 0};
        int a = solution525.findMaxLength(nums);
        System.out.println(a);
    }

    public int findMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] != nums[1] ? 2 : 0;
        }
        int[] count = new int[nums.length];
        int count0 = 0;
        int count1 = 0;
        Map<Integer, Integer> result = new HashMap<>();
        result.put(0,-1);
        int maxLength = 0;
        for (int i = 0; i < count.length; i++) {
            if (nums[i] == 0) {
                count0 += 1;
            } else {
                count1 += 1;
            }
            count[i] = count1 - count0;
            if (result.containsKey(count[i])) {
                int newLength = i - result.get(count[i]);
                if (newLength > maxLength) {
                    maxLength = newLength;
                }
            } else {
                result.put(count[i], i);
            }
        }
        return maxLength;
    }
}
