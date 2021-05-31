package com.family.algorithm.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] a = {2, 8, 7, 5, 3, 1};
        //        for (int i;)
        a = insertSort(a);
        for (int x : a) {
            System.out.print(x + ",");
        }
    }

    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                for (int j = i; j > 0; j--) {
                    //此处为了代码好理解，重复判断一下
                    if (arr[j] < arr[j - 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    }
                }
            }
        }
        return arr;
    }
}
