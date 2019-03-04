
import java.util.Arrays;

/**
 * @Author liguo
 * @Description
 * @Data 2018-08-12 10:40
 */
public class Solution3 {
//    public static String reOrderArray(int[] array) {
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = 0; j < array.length - 1 - i; j++) {
//                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
//                    int t = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = t;
//                }
//            }
//        }
//        return Arrays.toString( array );
//    }

    public static String paixu(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
//                    array[j] = array[j] + array[j + 1];
//                    array[j + 1] = array[j] - array[j + 1];
//                    array[j] = array[j] - array[j + 1];

                    int tem = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tem;
                }
            }
        }
        return Arrays.toString( array );
    }
}

