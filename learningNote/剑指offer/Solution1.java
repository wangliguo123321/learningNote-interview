
public class Solution1 {
    /**
     * @Author liguo
     * @Description 二维数组中的查找
     * 题目描述
     * 在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @思路 数组有序，从左下角元素开始遍历数组，大于数组右移，小于数组上移；
     */
    public boolean Find(int target, int[][] array) {
        int hangMax = array.length - 1;
        int lieMax = array[0].length;
        int hang = hangMax;
        int lie = 0;
        while (hang >= 0 && lie < lieMax) {
            if (array[hang][lie] == target)          return true;
            else if (array[hang][lie] > target)      hang--;
            else lie++;
        }
        return false;
    }




}