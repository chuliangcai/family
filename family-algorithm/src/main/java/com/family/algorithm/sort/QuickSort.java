package com.family.algorithm.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {2, 8, 7, 5, 3, 1};
        quickSort(a, 0, a.length - 1);
        for (int x : a) {
            System.out.print(x + ",");
        }
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return;
        }
        int targetPosition = endIndex;
        for (int i = (endIndex - 1); i >= startIndex; i--) {
            if (arr[i] > arr[targetPosition]) {
                int temp = arr[i];
                arr[i] = arr[targetPosition];
                arr[targetPosition] = temp;
                targetPosition = i;
            }
        }
        if (targetPosition > 1) {
            quickSort(arr, startIndex, targetPosition - 1);
        }
        if (endIndex - targetPosition > 1) {
            quickSort(arr, targetPosition + 1, endIndex);
        }
    }
}
