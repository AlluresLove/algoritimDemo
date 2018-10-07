package cn.idestiny.sortion;

import cn.idestiny.util.GeneratedArray;

import java.util.Arrays;

/**
 * @Auther: FAN
 * @Date: 2018/9/24 9:35
 * @Description:
 **/
public class SortionDemo {

    public static void main(String[] args) {

        int[] arr = GeneratedArray.randomGeneratedArray(50, 10000, 1000000);
        long start = System.currentTimeMillis();
        quick3Ways(arr);
        System.out.println(System.currentTimeMillis() - start);
        GeneratedArray.isSorted(arr);
    }

    /**
     * 冒泡排序 time=1351776
     *
     * @param arr
     */
    public static void bubblieSort(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    GeneratedArray.swap(arr, i, j);
                }
            }
        }

    }

    /**
     * 插入排序 time=148752
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

    }

    /**
     * 希尔排序 time = 346
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {

        int size = arr.length;
        int h = 1;
        while (h < size / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {

            for (int i = h; i < size; i++) {

                int key = arr[i];
                int j = i - h;
                while (j >= 0 && arr[j] > key) {
                    arr[j + h] = arr[j];
                    j -= h;
                }
                arr[j + h] = key;

            }

            h /= 3;
        }

    }


    /**
     * 归并排序 time = 219
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {

        if (right - left <= 15) {
            insertSort(arr, left, right);
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        if (arr[mid] > arr[mid + 1]) {
            mergeSort(arr, left, mid, right);
        }
    }

    private static void insertSort(int[] arr, int left, int right) {

        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

        }

    }

    private static void mergeSort(int[] arr, int left, int mid, int right) {

        int[] tmp = Arrays.copyOfRange(arr, left, right + 1);

        int i = left;
        int j = mid + 1;

        for (int k = i; k <= right; k++) {
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

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {

        if (right - left <= 15) {
            insertSort(arr, left, right);
            return;
        }

        int p = partition(arr, left, right);
        quickSort(arr, left, p);
        quickSort(arr, p + 1, right);

    }

    /**
     * 普通快速排序 time=200
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] arr, int left, int right) {

        GeneratedArray.swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);
        int v = arr[left];

        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < v) {
                GeneratedArray.swap(arr, i, j + 1);
                j++;
            }
        }
        GeneratedArray.swap(arr, j, left);
        return j;
    }

    /**
     * 双路快速排序 time=149
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition2(int[] arr, int left, int right) {

        GeneratedArray.swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);
        int v = arr[left];

        int i = left + 1;
        int j = right;
        for (; ; ) {
            while (i <= right && arr[i] < v) {
                i++;
            }
            while (j >= left && arr[j] > v) {
                j--;
            }
            if (i > j) {
                break;
            }
            GeneratedArray.swap(arr, i, j);
            i++;
            j--;
        }
        GeneratedArray.swap(arr, left, j);
        return j;
    }

    /**
     * 三路快速排序算法 time=134
     *
     * @param arr
     */
    public static void quick3Ways(int[] arr) {
        quick3Ways(arr, 0, arr.length - 1);
    }

    private static void quick3Ways(int[] arr, int left, int right) {

        // 对于小规模数组, 使用插入排序
        if (right - left <= 15) {
            insertSort(arr, left, right);
            return;
        }

        //随机选择标记，并且放到数组第一位
        int random = (int) (Math.random() * (right - left + 1) + left);
        GeneratedArray.swap(arr, left, random);
        //标记
        int v = arr[left];

        int lt = left;
        int gt = right + 1;
        int i = left + 1;
        while (i < gt) {
            if (arr[i] < v) {
                GeneratedArray.swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i] > v) {
                GeneratedArray.swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        GeneratedArray.swap(arr, left, lt);
        quick3Ways(arr, left, lt);
        quick3Ways(arr, gt, right);

    }
}
