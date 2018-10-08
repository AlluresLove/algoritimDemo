package cn.idestiny.list;

/**
 * @Auther: FAN
 * @Date: 2018/10/7 17:41
 * @Description: 斐波那契数列计算方法
 **/
public class FSSequence {

    public static void main(String[] args) {

        long start = System.nanoTime();
        System.out.println();
        System.out.println(fsMethodOne(20));
        System.out.println((double) (System.nanoTime()-start)/10000000+"");
        long start2 = System.nanoTime();
        System.out.println(fsMethodTwo(45));
        System.out.println((System.nanoTime()-start2)/1000000+"");

    }

    /**
     * 倒推递归法求斐波那切数列
     * @param num
     * @return
     */
    public static int fsMethodOne(int num) {

        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return fsMethodOne(num - 1) + fsMethodOne(num - 2);

    }

    /**
     * 正推法，求解斐波那契数列
     * @param num
     * @return
     */
    public static int fsMethodTwo(int num) {
        int[] arr = new int[num+1];
        //当num == 0 时，数组默认值为0
        if (num >= 1) {
            arr[1] = 1;
        }

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[num];
    }

}
