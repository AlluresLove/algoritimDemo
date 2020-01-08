package cn.idestiny.search;

import cn.idestiny.util.GeneratedArray;

import java.util.Arrays;

/**
 * @Auther: FAN
 * @Date: 2018/8/30 21:15
 * @Description:二分查找法
 **/
public class BinarySerach {

    /**
     * 对数组进行二分查找，获得位置
     * @param arr 数组
     * @param v 元素
     * @return 元素所在位置
     */
    public static int binarySearch(int[] arr,int v){

        //数组范围[i,j]
        int i = 0;
        int j = arr.length-1;

        while(i<=j){

            int mid = i+(j-i)/2;

            if(arr[mid] == v){
                return mid;
            }else if(arr[mid]>v){
                j = mid-1;
            }else{
                i = mid+1;
            }

        }

        return -1;

    }

    public static void main(String[] args) {

        int[] arr = {10,11,11,27,10,25,20,29,12,18};
        Arrays.sort(arr);
        GeneratedArray.printArray(arr);
        System.out.println(binarySearch(arr,20));
    }

}
