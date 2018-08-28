package cn.idestiny.sortion;

import cn.idestiny.util.GeneratedArray;

/**
 * @Auther: FAN
 * @Date: 2018/8/25 21:21
 * @Description:冒泡排序
 * 1) 4,2,5,3,7,1
 * 2) 2,4,3,5,1,7
 * 3) 2,3,4,1,5,7
 * 4) 2,3,1,4,5,7
 * 5) 2,1,3,4,5,7
 * 6) 1,2,3,4,5,7
 **/
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = GeneratedArray.randomGeneratedArray(0, 100000, 100000);
        bubbleSort(arr);
        GeneratedArray.isSorted(arr);

    }

    /**
     * 冒泡排序算法
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        //每次循环都去掉嘴都一个元素
        for(int i = arr.length-1;i>=0;i--){
            //找到最大元素排到最后
            for (int j = 0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

}
