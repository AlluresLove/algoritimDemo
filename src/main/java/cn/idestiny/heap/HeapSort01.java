package cn.idestiny.heap;

import cn.idestiny.util.GeneratedArray;

/**
 * @Auther: Administrator
 * @Date: 2018/8/29 17:53
 * @Description:堆排序
 */
public class HeapSort01 {

    public static void main(String[] args) {

        Integer[] arr = GeneratedArray.randomGeneratedArray1(10,11,10000000);
        long start = System.currentTimeMillis();
        heapsort(arr);
        System.out.println(System.currentTimeMillis()-start);

    }

    private static void heapsort(Integer[] arr) {

        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);

        for (int i = arr.length-1;i>=0;i--){
            arr[i] = maxHeap.extractMax();
        }

    }


}
