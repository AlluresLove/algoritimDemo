package cn.idestiny.sortion;

import cn.idestiny.util.GeneratedArray;

/**
 * 插入排序算法实现
 */
public class InsertionSort {

    public static void main(String[] args) {

        //随机生成指定长度数组
        int[] randomarr = GeneratedArray.randomGeneratedArray(0, 100, 100000);
        //打印为排序的数组
        long start = System.currentTimeMillis();
        insertionsort(randomarr);
        System.out.println(System.currentTimeMillis()-start);
    }

    public static void insertionsort(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0&&arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

}
