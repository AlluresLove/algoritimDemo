package cn.idestiny.sortion;

import cn.idestiny.util.GeneratedArray;

import java.util.Arrays;

/**
 * @Auther: FAN
 * @Date: 2018/8/26 21:25
 * @Description: 求逆序对
 **/
public class InversionCount {
    public static void main(String[] args) {
        int[] arr = GeneratedArray.randomGeneratedArray(10, 1000000, 10000000);
        mergeSort(arr);
        GeneratedArray.isSorted(arr);


    }

    private static void mergeSort(int[] arr) {

        long count = mergeSort(arr, 0, arr.length - 1);
        System.out.println(count);

    }

    private static long mergeSort(int[] arr, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int mid = (left + right) / 2;
        long res1 = mergeSort(arr, left, mid);
        long res2 = mergeSort(arr, mid + 1, right);

        return res1 + res2 + mergeSort(arr, left, mid, right);

    }

    private static long mergeSort(int[] arr, int left, int mid, int right) {

        int[] tmp = Arrays.copyOfRange(arr, left, right + 1);

        int i = left;
        int j = mid + 1;
        long count = 0l;

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
                count += (mid + 1 - i);
            } else {
                arr[k] = tmp[i - left];
                i++;
            }

        }

        return count;

    }


}
