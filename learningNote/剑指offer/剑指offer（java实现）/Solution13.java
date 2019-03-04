import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * @Author liguo
 * @Description 把数组排成最小的数
 * @问题：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @思路： 1：将数组转化为list；
 * 2：对list进行排序，重写compara构造方法，最小排序；
 * 3：对排序后的list进行累加；
 * @Data 2018-08-17 8:57
 */
public class Solution13 {
    public String PrintMinNumber(int[] numbers) {
        int n;
        String s = "";
        ArrayList <Integer> list = new ArrayList <Integer>();
        n = numbers.length;
        for (int i = 0; i < n; i++) {
            list.add( numbers[i] );//将数组放入arrayList中
        }
        //实现了Comparator接口的compare方法，原来的compare方法是从小到大排序，所以需要重写；
        //将集合元素按照compare方法的规则进行排序
        Collections.sort( list, new Comparator <Integer>() {

            @Override
            public int compare(Integer int1, Integer int2) {
                String s1 = int1 + "" + int2;
                String s2 = int2 + "" + int1;
                return s1.compareTo( s2 );           //对于string进行从小到大的排序；
            }
        } );
        for (int j : list) {
            s += j;
        }
        return s;
    }
}