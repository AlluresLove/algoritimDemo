package cn.idestiny.sortion;

import cn.idestiny.util.GeneratedArray;

import java.util.Arrays;

/**
 * @Auther: FAN
 * @Date: 2018/8/26 9:46
 * @Description:归并排序（自顶向下） （分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)
 * 1) [2,3,4,5,6,7,8,9]
 * 2) [4,5,6,8] [2,3,7,9]
 * 3) [4,5] [6,8] [7,9] [2,3]
 * 4) [5] [4] [8] [6] [7] [9] [3] [2]
 **/
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = GeneratedArray.randomGeneratedArray(0, 1000000, 1000000);
        long start = System.currentTimeMillis();
        mergeSort(arr);
        GeneratedArray.isSorted(arr);
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 归并排序
     *
     * @param arr 待排序数组
     */
    private static void mergeSort(int[] arr) {
        //准备数据，进入排序
        mergeSort(arr, 0, arr.length - 1);

    }

    /**
     * 递归拆分排序部分
     *
     * @param arr   待排序数组
     * @param left  左边界
     * @param right 右边界
     */
    private static void mergeSort(int[] arr, int left, int right) {
        //如果left==right，则是[a],[b],[c]这种情况，所以不需要再拆分
//        if(left>=right){
//            return;
//        }
        //对小数组使用插叙排序算法
        if ((right - left) <= 15) {
            insertSort(arr, left, right);
            return;
        }

        //计算每次拆分的中间位置
        int mid = (left + right) / 2;
        //递归创建需要排序的左半边
        mergeSort(arr, left, mid);
        //递归创建需要排序的右半边
        mergeSort(arr, mid + 1, right);
        //判断左边元素和右边元素是否已经是有序的
        if (arr[mid] > arr[mid + 1]) {
            //进入排序
            mergeSort(arr, left, mid, right);
        }
    }

    /**
     * 归并排序的排序部分
     *
     * @param arr   待排序数组
     * @param left  左边界
     * @param mid   中间标识
     * @param right 右边界
     */
    private static void mergeSort(int[] arr, int left, int mid, int right) {
        //复制一份数组用于扫描比较
        int[] tmp = Arrays.copyOfRange(arr, left, right + 1);
        //初始化数据 i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = left, j = mid + 1;
        //排序
        for (int k = i; k <= right; k++) {
            //如果左半部分已经全部处理完毕
            if (i > mid) {
                arr[k] = tmp[j - left];
                j++;
            }
            //如果右半部分全部处理完毕
            else if (j > right) {
                arr[k] = tmp[i - left];
                i++;
            }
            //左半部分所指元素 > 右半部分所指元素
            else if (tmp[i - left] > tmp[j - left]) {
                arr[k] = tmp[j - left];
                j++;
            }
            //左半部分所指元素 《 右半部分所指元素
            else {
                arr[k] = tmp[i - left];
                i++;
            }

        }
    }

    /**
     * 范围性插入排序数组
     *
     * @param arr   待排序数组
     * @param left  左边界
     * @param right 右边界
     */
    public static void insertSort(int[] arr, int left, int right) {

        for (int i = left+1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

    }


}
