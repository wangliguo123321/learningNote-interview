package LG.nowcoder;

/**
 * @Author liguo
 * @Description 第一个只出现一次的字符
 * @问题：题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * @思路：
 * 1:toCharArray()转化为字符串，然后直接通过
 * 2：新建立一个统计次数的数组，遍历上个一数组，将对应的值直接放进去；
 * 3：遍历计数的数组，直接输出值；
 * @Data 2018-08-17 11:48
 */

public class Solution15 {
    public int FirstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        int[] arr = new int[256];
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i]] == 1) return i;
        }
        return -1;
    }
}