package cn.idestiny.sortion;

import cn.idestiny.util.GeneratedArray;

/**
 * @Auther: FAN
 * @Date: 2018/8/26 19:48
 * @Description:快速排序
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = GeneratedArray.randomGeneratedArray(1, 10, 1000000);
        long start = System.currentTimeMillis();
        quickSort(arr);
        GeneratedArray.isSorted(arr);
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {

//        if(left>=right){
//            return;
//        }

        //当数组长度过小时，采用插入排序，这样可以优化排序速度
        if (right - left <= 15) {
            insertionSort(arr, left, right);
            return;
        }
        //进行partition
        int p = partition(arr, left, right);
        //递归左范围
        quickSort(arr, left, p - 1);
        //递归右范围
        quickSort(arr, p + 1, right);

    }

    /**
     * 对arr[left...right]部分进行partition操作
     * 简单快速排序算法
     * @param arr
     * @param left
     * @param right
     * @return 返回p, 使得arr[left...p-1]<arr[p] arr[p+1...right]>arr[p]
     */
    private static int partition(int[] arr, int left, int right) {
        //随机选择数组中一个位置，与数组首位进行交换，
        GeneratedArray.swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);
        //选择数组中第一个元素作为标志
        int v = arr[left];

        //arr[left+1...j] < v  arr[j+1...right]>v
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < v) {
                //如果arr[i] < v 那么就把arr[i]加入到[left+1...j]中
                GeneratedArray.swap(arr, j + 1, i);
                j++;
            }
        }
        GeneratedArray.swap(arr, j, left);
        return j;
    }

    /**
     * 双路快速排序算法
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition2(int[] arr, int left, int right) {
        //随机选择数组中一个位置，与数组首位进行交换，
        GeneratedArray.swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);
        //选择数组中第一个元素作为标志
        int v = arr[left];

        //arr[left+1...i]<=v  arr[j...right]>=v
        int i = left + 1, j = right;
        while(true){
            while(i<=right&&arr[i]<v)i++;
            while(j>=left+1&&arr[j]>v)j--;
            if (i>j)break;
            GeneratedArray.swap(arr,i,j);
            i++;
            j--;
        }

        GeneratedArray.swap(arr, left, j);
        return j;

    }


    private static void insertionSort(int[] arr, int left, int right) {

        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

    }

}
