package cn.idestiny.sortion;

import cn.idestiny.util.GeneratedArray;

import java.util.Arrays;

/**
 * @Auther: FAN
 * @Date: 2018/8/26 22:54
 * @Description:
 * 比较Merge Sort和双路快速排序和三路快排三种排序算法的性能效率
 * 对于包含有大量重复数据的数组, 三路快排有巨大的优势
 * 对于一般性的随机数组和近乎有序的数组, 三路快排的效率虽然不是最优的, 但是是在非常可以接受的范围里
 * 因此, 在一些语言中, 三路快排是默认的语言库函数中使用的排序算法。比如Java:)
 **/
public class QuickSort3Ways {

    public static void main(String[] args) {

        int[] arr = GeneratedArray.randomGeneratedArray(1,1000,10000000);
        long start = System.currentTimeMillis();
        quickSortThreeWay(arr);
        System.out.println(System.currentTimeMillis()-start);
        GeneratedArray.isSorted(arr);
    }

    private static void quickSortThreeWay(int[] arr) {
        quickSortThreeWay(arr,0,arr.length-1);
    }

    private static void quickSortThreeWay(int[] arr, int left, int right) {

        // 对于小规模数组, 使用插入排序
        if(right-left<=15){
            insertSort(arr,left,right);
            return;
        }
        //随机选择标记，并且放到数组第一位
        int random = (int)(Math.random()*(right-left+1)+left);
        GeneratedArray.swap(arr,left,random);
        //标记
        int v = arr[left];

        //arr[left+1...lt]<0
        int lt = left;
        //arr[gt...r0ight]>0
        int gt = right+1;
        //arr[lt+1...gt) == 0
        int i = left+1;
        while(i<gt){

            if(arr[i]<v){
                GeneratedArray.swap(arr,i,lt+1);
                lt++;
                i++;
            }else if(arr[i]>v){
                GeneratedArray.swap(arr,i,gt-1);
                gt--;
            }else{//arr[i] == v
                i++;
            }

        }

        GeneratedArray.swap(arr,left,lt);
        quickSortThreeWay(arr,left,lt-1);
        quickSortThreeWay(arr,gt,right);
    }

    /**
     * 小范围数组运用插入排序效果较好
     * @param arr 使用插入排序的数组[left,right]
     * @param left 左边界
     * @param right 有边界
     */
    private static void insertSort(int[] arr, int left, int right) {

        for(int i = left+1;i<=right;i++){
            int key = arr[i];
            int j = i-left;
            while(j>=0&&arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

    }

}
