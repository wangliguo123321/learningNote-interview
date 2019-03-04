
/**
 * @Author liguo
 * @Description 数组中只出现一次的数字
 * @问题： 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * @思路：
 * @Data 2018-09-26 22:55
 */
//将num1[0],num2[0]设置为返回结果
public class Solution28 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length < 2) return;
        int myxor = 0;
        int flag = 1;
        for (int i = 0; i < array.length; ++i)
            myxor ^= array[i];
        while ((myxor & flag) == 0) flag <<= 1;
        for (int i = 0; i < array.length; ++i) {
            if ((flag & array[i]) == 0) num2[0] ^= array[i];
            else num1[0] ^= array[i];
        }
    }
}