package cn.idestiny.util;

/**
 * 排序算法工具类
 */
public class GeneratedArray {

    /**
     *
     * 生成随机长度数组[min,max)
     *
     * @param min 最小值
     * @param max 最大值
     * @param num
     * @return
     */
    public static int[] randomGeneratedArray(int min, int max, int num) {

        //断言判断
        assert max>min:"数组生成范围指定有误";

        int[] arr = new int[num];

        for (int i = 0; i < arr.length; i++) {
            //随机生成[min,max)范围内的数字，并且存放到数组中
            arr[i] = (int) (Math.random() * (max - min)) + min;
        }

        return arr;

    }

    /**
     *
     * 生成随机长度数组[min,max)
     *
     * @param min 最小值
     * @param max 最大值
     * @param num
     * @return
     */
    public static Integer[] randomGeneratedArray1(int min, int max, int num) {

        //断言判断
        assert max>min:"数组生成范围指定有误";

        Integer[] arr = new Integer[num];

        for (int i = 0; i < arr.length; i++) {
            //随机生成[min,max)范围内的数字，并且存放到数组中
            arr[i] = (int) (Math.random() * (max - min)) + min;
        }

        return arr;

    }

    /**
     * 生成一个近乎有序的数组
     * @param n 数组产固定
     * @param swapTimes 随机交换多少个数字
     * @return arr
     */
    public static int[] generateNearlyOrderedArray(int n, int swapTimes){

        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i ++ )
            arr[i] = i;

        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    /**
     * 打印数组
     * @param arr 数组
     */
    public static void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i+",");
        }
        System.out.println();
    }

    /**
     * 判断数组是否有序
     * @param arr
     */
    public static void isSorted(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                System.out.println("数组不是有序");
                return;
            }
        }
        System.out.println("数组有序");
    }

    /**
     * 复制数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr){
        int[] arrs = new int[arr.length];
        for (int i = 0;i<arrs.length;i++){
            arrs[i] = arr[i];
        }
        return arrs;
    }

    /**
     * arr[i] arr[j]交换位置
     * @param arr 数组
     * @param i
     * @param j
     */
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
