package cn.idestiny.heap;

import cn.idestiny.util.GeneratedArray;


/**
 * @Auther: FAN
 * @Date: 2018/8/27 22:42
 * @Description:
 **/
public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    // 堆中存储的数量
    protected int count;
    // 堆中可存放的数据个数
    protected  int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity){
        data = (Item[]) new Comparable[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    /**
     *
     * @return 返回堆中的元素个数
     */
    public int size(){
        return count;
    }

    /**
     * 插入元素
     * @param item
     */
    public void insert(Item item){

        //判断堆中是否可以继续插入元素
        assert capacity > count+1:"堆已满";

        data[count+1] = item;
        count++;
        shiftUp(count);
    }

    /**
     * 找到元素合适的位置
     * @param k
     */
    private void shiftUp(int k){
        while (k > 1 && data[k/2].compareTo(data[k]) < 0){
            swap(k/2,k);
            k/=2;
        }
    }

    /**
     * 交换元素位置
     * @param i
     * @param j
     */
    private void swap(int i,int j) {
        Item tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    /**
     *
     * @return 返回一个布尔值, 表示堆中是否为空
     */
    public boolean isEmpty(){
        return count == 0;
    }

    public void print(){
        for (int i = 1;i<=count;i++){
            System.out.print(data[i]+"\t");
        }
    }

    public static void main(String[] args) {
        MaxHeap<Comparable<Integer>> maxHeap = new MaxHeap<>(100);

        for (int i = 0;i<50;i++){
            maxHeap.insert((int)(Math.random()*100));
        }
        for (int i = 1;i<=maxHeap.size();i++){
            System.out.print(maxHeap.data[i]+"\t");
        }

    }
}
