
import java.util.ArrayList;

/**
 * @Author liguo
 * @Description 和为S的两个数字
 * @问题 ：题目描述输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * @思路： 两个数之和一定，差越大，积越小；
 * 1：排除数组为空以及数组长度不够的情况；
 * 2：通过两边往中间靠近的原则
 * 3：while循环，当头小于尾的时候，将符合条件的放入list；
 * 4：当和大于给定的数时，两端的指针往中间靠近；
 * @Data 2018-09-07 23:31
 */
public class Solution20 {
    public ArrayList <Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList <Integer> list = new ArrayList <Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int index = 0, end = array.length - 1;
        while (index < end) {
            if (array[index] + array[end] == sum) {
                list.add( array[index] );
                list.add( array[end] );
                return list;
            } else if (array[index] + array[end] > sum) end--;
            else index++;
        }
        return list;
    }
}