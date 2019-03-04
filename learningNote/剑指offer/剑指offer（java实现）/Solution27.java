
/**
 * @Author liguo
 * @Description 数组中的逆序对
 * @问题： 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * 示例1
 * 输入
 * 复制
 * 1,2,3,4,5,6,7,0
 * 输出
 * 复制
 * @思路：
 * @Data 2018-09-24 0:57
 */
public class Solution27 {
    int cnt;

    public int InversePairs(int[] array) {
        cnt = 0;
        if (array != null)
            mergeSortUp2Down( array, 0, array.length - 1 );
        return cnt;
    }

    /*
     * 归并排序(从上往下)
     */
    public void mergeSortUp2Down(int[] a, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) >> 1;
        mergeSortUp2Down( a, start, mid );
        mergeSortUp2Down( a, mid + 1, end );
        merge( a, start, mid, end );
    }

    /*
     * 将一个数组中的两个相邻有序区间合并成一个
     */
    public void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                tmp[k++] = a[i++];
            else {
                tmp[k++] = a[j++];
                cnt += mid - i + 1;
            }
        }
        while (i <= mid)
            tmp[k++] = a[i++];
        while (j <= end)
            tmp[k++] = a[j++];
        for (k = 0; k < tmp.length; k++)
            a[start + k] = tmp[k];
    }
}