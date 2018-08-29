package cn.idestiny.heap;


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

    public MaxHeap(Item[] arr){
        data = (Item[])new Comparable[arr.length];
        capacity = arr.length;

        for (int i = 0;i<arr.length;i++){
            data[i+1] = arr[i];
        }

        count = arr.length;
        //完全二叉树 第一个非叶子节点的索引是二叉树元素个数/2
        for (int i = count/2;i>=1;i--){
            shiftDown(i);
        }

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
     * 弹出堆顶元素
     * @return
     */
    public Item extractMax(){

        assert count > 0:"空堆";

        Item item = data[1];

        swap(1,count);
        count--;

        shiftDown(1);

        return item;

    }

    /**
     * 寻找最后一个堆元素合适的位置
     * @param k
     */
    private void shiftDown(int k) {

        while(2*k<=count){
            int j = 2*k;
            if(j+1<=count&&data[j+1].compareTo(data[j])>0){
                j++;
            }

            if (data[k].compareTo(data[j])>=0){
                break;
            }
            swap(k,j);
            k = j;
        }

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


    public static void main(String[] args) {
        MaxHeap<Comparable<Integer>> maxHeap = new MaxHeap<>(100);

        for (int i = 0;i<100;i++){
            maxHeap.insert((int)(Math.random()*100));
        }


        while(!maxHeap.isEmpty()){
            System.out.print(maxHeap.extractMax()+"\t");
        }
    }
}
