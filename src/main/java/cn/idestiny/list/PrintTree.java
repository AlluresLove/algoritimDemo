package cn.idestiny.list;

import static cn.idestiny.util.GeneratedArray.printArray;

/**
 * @Auther: FAN
 * @Date: 2018/9/2 15:15
 * @Description: 打印出二叉树所有路径
 **/
public class PrintTree {

    static class Node{

        public int value;
        public Node left;
        public Node right;

        Node(int value){
            this.value = value;
            left = null;
            right = null;
        }

    }

    public static void main(String[] args) {

        Node node = new Node(8);
        Node node1 = new Node(3);
        Node node2 = new Node(10);
        Node node3 = new Node(1);
        Node node4 = new Node(6);
        Node node5 = new Node(14);
        Node node6 = new Node(4);
        Node node7 = new Node(7);
        Node node8 = new Node(13);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        node5.left = node8;


        int[] path = new int[4];
        printPaths(node,path,0);

    }

    private static void printPaths(Node node, int[] path, int i) {

        if (node == null){
            return;
        }
        path[i++] = node.value;
        if (node.left==null&&node.right==null){
            printArray(path);
        }else{
            printPaths(node.left,path,i);
            printPaths(node.right,path,i);
        }

    }

}
