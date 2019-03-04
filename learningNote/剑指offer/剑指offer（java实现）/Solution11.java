import java.util.ArrayList;
import java.util.TreeSet;
/**
 * @Author liguo
 * @Description 字符串的排列
 * @问题： 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @思路：基于回溯法思想
 * @Data 2018-08-15 10:44
 */
public class Solution11 {
    public ArrayList <String> dieDai(String str) {
        ArrayList <String> result = new ArrayList <String>();
        if (str == null || str.length() == 0) return result;

        char[] chars = str.toCharArray();
        TreeSet <String> temp = new TreeSet <String>();
        dieDai( chars, 0, temp );
        result.addAll( temp );
        return result;
    }
    public void dieDai(char[] chars, int begin, TreeSet <String> result) {
        if (chars == null || chars.length == 0 || begin < 0 || begin > chars.length - 1) return;
        if (begin == chars.length - 1) {
            result.add( String.valueOf( chars ) );
        } else {
            for (int i = begin; i <= chars.length - 1; i++) {
                swap( chars, begin, i );
                dieDai( chars, begin + 1, result );
                swap( chars, begin, i );
            }
        }
    }
    public void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

}