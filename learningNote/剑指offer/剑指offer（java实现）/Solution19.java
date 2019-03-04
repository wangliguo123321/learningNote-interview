
/**
 * @Author liguo
 * @Description
 * @问题： 构建乘积数组；
 * @思路：
 * @Data 2018-09-15 10:11
 */
public class Solution19 {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return new int[1];
        }
        int[] B = new int[A.length];
        int tmp1 = 1;
        int[] tmp2 = new int[A.length];
        tmp2[A.length - 1] = 1;
        for (int i = 1; i < A.length; i++) {
            tmp2[A.length - i - 1] = tmp2[A.length - i] * A[A.length - i];
        }
        for (int i = 0; i < A.length; i++) {
            if(i!=0){
                tmp1 *=A[i-1];
            }
            B[i] = tmp1 * tmp2[i];
        }
        return B;
    }
}