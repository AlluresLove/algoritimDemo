package cn.idestiny.sortion;

import cn.idestiny.util.GeneratedArray;

/**
 * @Auther: FAN
 * @Date: 2018/8/25 20:11
 * @Description:选择排序 每次排序选择出最小的数字放在对应位置
 * 1） 3，5，1，2 最小值 1 和3交换
 * 2） 1，5，3，2 最小值 2 和5交换
 * 3） 1，2，3，5 排序完成
 **/
public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = GeneratedArray.randomGeneratedArray(0, 100000, 100000);
        long start = System.currentTimeMillis();
        selectionsort(arr);
        System.out.println(System.currentTimeMillis() - start);
        //判断数组是否有序
        GeneratedArray.isSorted(arr);

    }

    /**
     * 选择排序算法实现
     *
     * @param arr
     */
    public static void selectionsort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            //寻找[i,arr.length)中的最小值，默认当前元素
            int minIndex = i;
            //循环遍历当前元素是不是最小值，若不是，替换标记
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            //判断当前表示是否是开始标记，若是则不用交换元素，若不是则交换元素位置
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

    }

}
