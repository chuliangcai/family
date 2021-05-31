package com.family.algorithm.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {2, 8, 7, 5, 3, 1};
        //        for (int i;)
        a = bubbleSort(a);
        for (int x : a) {
            System.out.print(x + ",");
        }

    }

    public static int[] bubbleSort(int[] arr) {
        int count = 0;
        for (int i = arr.length; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    count++;
                }
            }
        }
        System.out.println("时间复杂度:" + count);
        return arr;
    }

}
