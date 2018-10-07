package cn.idestiny.search;

/**
 * @Auther: FAN
 * @Date: 2018/9/3 22:03
 * @Description:
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 **/
public class Solution {
    public boolean find(int target, int [][] array) {
        int col = array[0].length-1;
        int row = 0;
        while(col>=0&&row<=array.length-1){
            if(array[row][col] == target){
                return true;
            }else if(array[row][col] > target){
                col--;
            }else if(array[row][col] < target){
                row++;
            }
        }
        return false;
    }
}