import java.util.ArrayList;
/**
 * @Author liguo
 * @Description 顺时针打印矩阵
 * @问题：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @思路：
1：确定循环的层数，公式mn =（ (Math.min(m,n)-1) ）/  2   +1
2：采用从左到右，从右上方到右下方，右下方到左下方，左下方到做左上方，关联打印圈数mn
3: 熟记以下代码，注意与i的联系；
for(int k = i;k<m-i;k++) result.add(array[i][k]);//左至右
for(int j=i+1;j<n-i;j++) result.add(array[j][m-i-1]);//右上至右下
for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) result.add(array[n-i-1][k]);//右至左
for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) result.add(array[j][i]);//左下至左上
 * @Data 2018-08-14 13:06
 */
public class Solution8 {
    public ArrayList<Integer> printMatrix(int [][] array) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(array.length==0) return result;
        int n = array.length,m = array[0].length;
        if(m==0) return result;
        int mn = (Math.min(n,m)-1)/2+1;//确定循环的层数
        for(int i=0;i<mn;i++){
            for(int k = i;k<m-i;k++) result.add(array[i][k]);//左至右
            for(int j=i+1;j<n-i;j++) result.add(array[j][m-i-1]);//右上至右下
            for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) result.add(array[n-i-1][k]);//右至左
            for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) result.add(array[j][i]);//左下至左上
        }
        return result;
    }
}