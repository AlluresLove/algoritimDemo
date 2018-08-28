package cn.idestiny.sortion;

import cn.idestiny.util.GeneratedArray;

/**
 * @Auther: FAN
 * @Date: 2018/8/27 21:53
 * @Description: 选择第n大的数字
 **/
public class SelectionNum {

    public static void main(String[] args) {

        int[] arr = GeneratedArray.randomGeneratedArray(10,100,10);
        GeneratedArray.printArray(arr);
        int i = quicksort(arr,5);
        GeneratedArray.isSorted(arr);
        GeneratedArray.printArray(arr);
        System.out.println(i);

    }

    private static int quicksort(int[] arr,int n) {

        return quicksort(arr,0,arr.length-1,n-1);

    }

    private static int quicksort(int[] arr, int left, int right,int n) {
        if (left==right){
            return arr[left];
        }
        int p = partition(arr,left,right);
        if(p == n){
            return arr[p];
        }else if(p>n){
            return quicksort(arr,left,p-1,n);
        }else {
            return quicksort(arr,p+1,right,n);
        }

    }

    private static int partition(int[] arr, int left, int right) {

        GeneratedArray.swap(arr,left,(int)(Math.random()*(right-left+1))+left);

        int v = arr[left];
        int i = left;
        for (int j = left+1;j<=right;j++){
            if (arr[j]<v){
                i++;
                GeneratedArray.swap(arr,i,j);
            }
        }
        GeneratedArray.swap(arr,left,i);
        return i;
    }

}
