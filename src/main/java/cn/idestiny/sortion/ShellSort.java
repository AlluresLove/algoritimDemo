package cn.idestiny.sortion;

import cn.idestiny.util.GeneratedArray;

/**
 * @Auther: FAN
 * @Date: 2018/8/25 22:25
 * @Description:希尔排序
 *
 * 重点：设置增量
 *   举例来说，含有1000个数据项的数组可能先以364为增量，然后以121为增量，以40为增量，
 *   以13为增量，以4为增量，最后以 1为增量进行希尔排序。用来形成间隔的数列被称为间隔序列。
 *   这里所表示的间隔序列由Knuth提出，此序列是很常用的。
 *   数列以逆向形式从1开始，通过递归表达式 h=3*b+1 来产生，初始值为1。
 *
 * 当增量为arr.length/2的时候
 * 1) 8,5,7,1,3,6,9.4  [8,3],[5,6]  [7,9],[1,4]
 * 2) 3,5,7,1,8,6,9,4  [3,7,8,9]  [5,1,6,4]
 * 3) 3,1,7,4,8,5,9,6  [3,1,7,4,8,5,9,6]
 * 4) 1,3,4,5,6,7,8,9
 **/
public class ShellSort {

    public static void main(String[] args) {

        int[] arr = GeneratedArray.randomGeneratedArray(0, 1000000, 1000000);
        long start = System.currentTimeMillis();
        shellSort(arr);
        GeneratedArray.isSorted(arr);
        System.out.println(System.currentTimeMillis()-start);
    }

    public static void shellSort(int[] arr) {

        //数组长度
        int size = arr.length;
        //设置间隔序列 详细请看文档注释
        int h = 1;
        while(h<size/3){
            h = 3*h +1;
        }
        //根据增量分组，增量为1时，只需要插入排序算法微调即可
        while(h>=1){
            //对每个分组执行插入排序算法
            for(int i = h;i<size;i++){
                //记录插入值
                int key = arr[h];
                //插入值前一个元素的位置
                int j = i-h;
                //如果插入之比前一个值大，则插入之只需向后排列即可，不用在和前面的元素比较。
                while(j>=0&&arr[j]>key){
                    //如果插入值比它前面的值小，则大值（插入值前面的值）向后移动一位，
                    arr[j+h] = arr[j];
                    //插入值之前的角标
                    j -= h;
                }
                //插入值最终应该放置的位置
                arr[j+h] = key;

            }
            //缩小增量
            h /= 3;
        }

    }

}
