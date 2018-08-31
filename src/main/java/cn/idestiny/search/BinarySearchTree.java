package cn.idestiny.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Auther: Administrator
 * @Date: 2018/8/31 08:55
 * @Description: BinarySearchTree
 */
public class BinarySearchTree<Key extends Comparable, Value> {

    //私有化节点类
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * BinarySearchTree 根节点
     */
    private Node root;

    /**
     * BinarySearchTree节点个数
     */
    private int count;

    /**
     * 默认构造一个空的BinarySearchTree
     */
    public BinarySearchTree() {
        this.root = null;
        count = 0;
    }

    /**
     * @return 返回BinarySearchTree节点个数
     */
    public int size() {
        return count;
    }

    /**
     * @return 返回二叉搜索树是否为空
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 二叉搜索树中插入元素
     *
     * @param key   键
     * @param value 值
     */
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    /**
     * @param key 键
     * @return 返回BinarySearchTree中是否包含键
     */
    public boolean contain(Key key) {
        return contain(root, key);
    }

    /**
     * @param key 键
     * @return 返回BinarySearchTree中对应Key的Value
     */
    public Value search(Key key) {
        return search(root, key);
    }

    /**
     * 前序遍历(递归)
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 中序遍历（递归）
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 后序遍历（递归）
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 前序遍历（非递归）
     */
    public void preOrderRec(){
        preOrderRec(root);
    }

    /**
     * 中序遍历（非递归）
     */
    public void inOrderRec(){
        inOrderRec(root);
    }

    /**
     * 后续遍历（非递归）
     *
     *
     * 	后序遍历递归定义：先左子树，后右子树，再根节点。
     * 	后序遍历的难点在于：需要判断上次访问的节点是位于左子树，还是右子树。
     *  若是位于左子树，则需跳过根节点，先进入右子树，再回头访问根节点；
     * 	若是位于右子树，则直接访问根节点。
     *
     * 
     */
    public void postOrderRec(){
        postOrderRec(root);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node node = queue.remove();

            System.out.println(node.key);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }

    }



    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + "\t");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void preOrderRec(Node root) {

        Stack<Node> stack = new Stack<Node>();
        if (root!=null){
            stack.push(root);
        }

        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.key + "\t");
            if (node.right!=null)stack.push(node.right);
            if (node.left!=null)stack.push(node.left);
        }

    }


    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + "\t");
            inOrder(node.right);
        }
    }

    private void inOrderRec(Node root) {

        Stack<Node> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()){
                Node node = stack.pop();
                System.out.print(node.key+"\t");
                root = node.right;
            }
        }

    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + "\t");
        }
    }

    private void postOrderRec(Node node){

        Stack<Node> stack = new Stack<Node>();

        //记录当前访问节点
        Node curNode = node;
        //记录最后访问节点
        Node lastVisitNode = null;
        //把所有左节点入栈
        while(curNode!=null){
            stack.push(curNode);
            curNode = curNode.left;
        }

        while (!stack.isEmpty()){
            //弹出栈顶元素
            curNode = stack.pop();
            //一个根节点被访问的前提是：无右节点，或者，右节点已经被访问
            if(curNode.right!=null&&curNode.right!=lastVisitNode){
                //根节点重新入栈
                stack.push(curNode);
                //进入右子树，且可以肯定右子树一定不为空
                curNode = curNode.right;
                while (curNode!=null){
                    //在走进右子树最左边
                    stack.push(curNode);
                    curNode = curNode.left;
                }
            }else{
                //访问
                System.out.print(curNode.key+"\t");
                //修改最近被访问的节点
                lastVisitNode = curNode;
            }

        }

    }



    private Value search(Node node, Key key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }

    }

    //插入元素
    private Node insert(Node node, Key key, Value value) {

        //如果节点为null，则创建新节点并插入对应位置
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        //如果BinarySearchTree中存才相应的键,则替换该键对应的值
        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {//如果BinarySearchTree中key大于新插入的key，则去Tree中左子树查找相应位置
            node.left = insert(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {//如果BinarySearchTree中key小于新插入的key，则去Tree中右子树查找相应位置
            node.right = insert(node.right, key, value);
        }

        return node;

    }

    private boolean contain(Node node, Key key) {

        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }

    }

    public static void main(String[] args) {

        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(41, "50");
        binarySearchTree.insert(22, "50");
        binarySearchTree.insert(58, "50");
        binarySearchTree.insert(15, "40");
        binarySearchTree.insert(33, "40");
        binarySearchTree.insert(50, "40");
        binarySearchTree.insert(60, "40");
        binarySearchTree.insert(13, "40");
        binarySearchTree.insert(28, "40");
        binarySearchTree.insert(37, "40");
        binarySearchTree.insert(42, "40");
        binarySearchTree.insert(53, "41");

        binarySearchTree.postOrderRec();


    }


}
