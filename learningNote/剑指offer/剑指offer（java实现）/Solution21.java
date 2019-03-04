
/**
 * @Author liguo
 * @Description
 * @问题： 把字符串转化为整数
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * @思路： 转化为数组，判断非空；然后根据数字0到9的ASIC码来确定，判断数组是否处于48到57；返回sum = sum*10 + 数组；
 * @Data 2018-09-15 9:41
 */
public class Solution21 {
    public static int StrToInt(String str) {
        if (str.equals( "" ) || str.length() == 0)
            return 0;
        char[] a = str.toCharArray();
        int shouwei = 0;
        if (a[0] == '-')
            shouwei = 1;
        int sum = 0;
        for (int i = shouwei; i < a.length; i++) {
            if (a[i] == '+')
                continue;
            if (a[i] < 48 || a[i] > 57)
                return 0;
            sum = sum * 10 + a[i] - 48;
        }
        return shouwei == 0 ? sum : sum * -1;
    }

    public static void main(String[] args) {
        String test2 = "-2133";
        String test1 = "12334";
        System.out.println( Integer.valueOf( test2 ) );
        System.out.println( StrToInt( test2 ) );
    }
}