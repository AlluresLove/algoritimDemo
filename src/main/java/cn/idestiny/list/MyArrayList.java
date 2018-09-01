package cn.idestiny.list;


import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @Auther: FAN
 * @Date: 2018/9/1 21:41
 * @Description: 自定义ArrayList
 **/
public class MyArrayList<AnyType>{

    //默认数组大小
    private static final int DEFAULT_CAPACITY = 10;

    private int  theSize;
    private AnyType[] theItems;

    //初始化
    public MyArrayList(){
        doClear();
    }

    public void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     *
     * @return 返回集合元素大小
     */
    public int size(){
        return theSize;
    }

    /**
     *
     * @return 返回集合元素是否为空
     */
    public boolean isEmpty(){
        return theSize == 0;
    }

    public void trimToSize(){
        ensureCapacity(size());
    }

    /**
     *
     * @param index 角标
     * @return 返回角标为index的元素
     */
    public AnyType get(int index){

        if (index < 0 || index > theSize){
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[index];

    }

    /**
     *
     * @param index 需要修改的角标
     * @param newAnyType 需要修改的AnyType
     * @return 返回旧的AnyType
     */
    public AnyType set(int index,AnyType newAnyType){
        if (index<0||index>theSize){
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = theItems[index];
        theItems[index] = newAnyType;
        return old;
    }


    private void ensureCapacity(int newCapatity) {

        if (newCapatity < theSize){
            return;
        }

        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapatity];
        for (int i = 0;i<size();i++){
            theItems[i] = old[i];
        }
    }


    /**
     *
     * @param anyType 待添加的元素
     * @return 如果anyType添加成功返回true
     */
    public boolean add(AnyType anyType){
        add(theSize,anyType);
        return true;
    }

    public void add(int index, AnyType anyType) {

        if (theItems.length == theSize){
            ensureCapacity(theSize*2+1);
        }
        for (int i = theSize;i>index;i--){
            theItems[i] = theItems[i-1];
        }
        theItems[index] = anyType;
        theSize++;

    }

    public AnyType remove(int index){
        if (index<0||index>theSize){
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType removeItem = theItems[index];
        for (int i = index;i<theSize-1;i++){
            theItems[i] = theItems[i+1];
        }
        theSize--;
        return removeItem;
    }

    public Iterator<AnyType> iterator(){
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<AnyType>{

        private int current = 0;

        public boolean hasNext() {
            return current<size();
        }

        public AnyType next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
        }

    }
}
