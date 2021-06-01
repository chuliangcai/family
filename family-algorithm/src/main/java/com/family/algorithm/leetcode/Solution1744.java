package com.family.algorithm.leetcode;

import java.math.BigDecimal;

//你能在你最喜欢的那天吃到你最喜欢的糖果吗？
public class Solution1744 {

    public static void main(String[] args) {
        //[43,1054,49];
        int[] count = {5215, 14414, 67303, 93431, 44959, 34974, 22935, 64205, 28863, 3436, 45640, 34940, 38519, 5705, 14594, 30510, 4418, 87954, 8423, 65872, 79062, 83736, 47851, 64523, 15639, 19173, 88996, 97578, 1106, 17767, 63298, 8620, 67281, 76666, 50386, 97303, 26476, 95239, 21967, 31606, 3943, 33752, 29634, 35981, 42216, 88584, 2774, 3839, 81067, 59193, 225, 8289, 9295, 9268, 4762, 2276, 7641, 3542, 3415, 1372, 5538, 878, 5051, 7631, 1394, 5372, 2384, 2050, 6766, 3616, 7181, 7605, 3718, 8498, 7065, 1369, 1967, 2781, 7598, 6562, 7150, 8132, 1276, 6656, 1868, 8584, 9442, 8762, 6210, 6963, 4068, 1605, 2780, 556, 6825, 4961, 4041, 4923, 8660, 4114};
        System.out.println(count.length);
        boolean[] a = canEat(count, new int[][]{{91, 244597, 840227137}});
        System.out.println(a[0]);
    }

    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        //计算出每天吃一个和每天吃最多颗，指定天能吃到第几个类型
        long[] sum = sum(candiesCount);
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = canEat(sum, queries[i]);
        }
        return result;
    }

    public static long[] sum(int[] candiesCount) {
        long[] sumArr = new long[candiesCount.length];
        long sum = 0;
        for (int i = 0; i < candiesCount.length; i++) {
            sum += candiesCount[i];
            sumArr[i] = sum;
        }
        return sumArr;
    }

    public static boolean canEat(long[] sum, int[] query) {
        int min = query[1];
        BigDecimal max = BigDecimal.valueOf(query[2]).multiply(BigDecimal.valueOf(query[1]));
//        long max = query[2] * query[1];
        long smin = (query[0] == 0 ? 0 : sum[query[0] - 1]) + 1;
        long smax = sum[query[0]];
        System.out.println(min + ":" + max + ":" + smin + ":" + smax);
        //return smin <= max && min <= smax;
        //0 .... 43 天的和是1054
        return true;
    }
}
