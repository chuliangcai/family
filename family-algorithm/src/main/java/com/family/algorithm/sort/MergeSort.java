package com.family.algorithm.sort;

public class MergeSort {

    public static void main(String[] args) {

    }

    public static void merge(int[] arr, int L, int M, int R) {

    }

    public static void mergeSort(int[] arr, int L, int R) {
        //假设 arr.length = 8
        //L=0, R = 7
        int M = (R + L) / 2;
        if (R == (L + 1)) {
            merge(arr, L, M, R);
        } else {
            mergeSort(arr, L, M);
            mergeSort(arr, M, R);
        }
    }
}
