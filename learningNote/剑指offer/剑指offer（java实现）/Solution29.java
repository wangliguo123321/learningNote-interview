
/**
 * @Author liguo
 * @Description 不使用加减乘除来实现数字的相加  写一个函数，
 * 求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Solution29 {
    public int Add(int num1, int num2) {
        if (0 == num2)
            return num1;//若进位为0，运算结束
        int temp = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        return Add( temp, carry );//若存在不为0的进位，则重复运算
    }
}