package cn.idestiny.sortion;

import cn.idestiny.util.GeneratedArray;

import java.util.Arrays;

/**
 * @Auther: FAN
 * @Date: 2018/8/26 13:48
 * @Description:归并排序（自低向上） （分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)
 * 1) [5] [4] [8] [6] [7] [9] [3] [2]
 * 2) [4,5] [6,8] [7,9] [2,3]
 * 3) [4,5,6,8] [2,3,7,9]
 * 4) [2,3,4,5,6,7,8,9]
 **/
public class MergeSortBU {

    public static void main(String[] args) {

        int[] arr = GeneratedArray.randomGeneratedArray(10, 50, 100);
        mergeSort(arr);
        GeneratedArray.printArray(arr);
        GeneratedArray.isSorted(arr);

    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;

        for (int size = 1; size < n; size += size) {
            for (int i = 0; i < n - size; i += size + size) {
                if (arr[i + size - 1] > arr[i + size]) {
                    mergeSort(arr, i, i + size - 1, Math.min(i + size + size - 1, n - 1));
                }
            }
        }

    }

    private static void mergeSort(int[] arr, int left, int mid, int right) {

        int[] tmp = Arrays.copyOfRange(arr, left, right + 1);

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = tmp[j - left];
                j++;
            } else if (j > right) {
                arr[k] = tmp[i - left];
                i++;
            } else if (tmp[i - left] > tmp[j - left]) {
                arr[k] = tmp[j - left];
                j++;
            } else {
                arr[k] = tmp[i - left];
                i++;
            }

        }

    }
}
