import java.util.*;


/**
 * @Author liguo
 * @Description
 */
public class Sort {

    //选择排序
    static int[] selectSort(int[] arr) {
        Scanner in = new Scanner( System.in );
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) min = j;
            }
            //交换
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    //插入
    static int[] insertSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return arr;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int k = i - 1;
            while (k >= 0 && arr[k] > temp)
                k--;
            //腾出位置插进去,要插的位置是 k + 1;
            for (int j = i; j > k + 1; j--)
                arr[j] = arr[j - 1];
            //插进去
            arr[k + 1] = temp;
        }
        return arr;
    }

    //冒泡
    static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        if (arr == null || n < 2) return arr;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) break;
        }
        return arr;
    }

    //希尔
    public static int[] shellSort(int arr[]) {
        if (arr == null || arr.length < 2) return arr;
        int n = arr.length;
        // 对每组间隔为 h的分组进行排序，刚开始 h = n / 2;
        for (int h = n / 2; h > 0; h /= 2) {
            //对各个局部分组进行插入排序
            for (int i = h; i < n; i++) {
                // 将arr[i] 插入到所在分组的正确位置上
                insertI( arr, h, i );
            }
        }
        return arr;
    }

    /**
     * 将arr[i]插入到所在分组的正确位置上
     * arr[i]] 所在的分组为 ... arr[i-2*h],arr[i-h], arr[i+h] ...
     */
    private static void insertI(int[] arr, int h, int i) {
        int temp = arr[i];
        int k;
        for (k = i - h; k > 0 && temp < arr[k]; k -= h) {
            arr[k + h] = arr[k];
        }
        arr[k + h] = temp;
    }

    //归并
    public static int[] mergeSort(int[] arr, int left, int right) {
        // 如果 left == right，表示数组只有一个元素，则不用递归排序
        if (left < right) {
            // 把大的数组分隔成两个数组
            int mid = (left + right) / 2;
            // 对左半部分进行排序
            arr = mergeSort( arr, left, mid );
            // 对右半部分进行排序
            arr = mergeSort( arr, mid + 1, right );
            //进行合并
            merge( arr, left, mid, right );
        }
        return arr;
    }

    // 合并函数，把两个有序的数组合并起来
    // arr[left..mif]表示一个数组，arr[mid+1 .. right]表示一个数组
    private static void merge(int[] arr, int left, int mid, int right) {
        //先用一个临时数组把他们合并汇总起来
        int[] a = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                a[k++] = arr[i++];
            } else {
                a[k++] = arr[j++];
            }
        }
        while (i <= mid) a[k++] = arr[i++];
        while (j <= right) a[k++] = arr[j++];
        // 把临时数组复制到原数组
        for (i = 0; i < k; i++) {
            arr[left++] = a[i];
        }
    }
    //快排
    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //获取中轴元素所处的位置
            int mid = partition( arr, left, right );
            //进行分割
            arr = quickSort( arr, left, mid - 1 );
            arr = quickSort( arr, mid + 1, right );
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        //选取中轴元素
        int pivot = arr[left];
        int i = left + 1;
        int j = right;
        while (true) {
            // 向右找到第一个小于等于 pivot 的元素位置
            while (i <= j && arr[i] <= pivot) i++;
            // 向左找到第一个大于等于 pivot 的元素位置
            while (i <= j && arr[j] >= pivot) j--;
            if (i >= j)
                break;
            //交换两个元素的位置，使得左边的元素不大于pivot,右边的不小于pivot
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[j];
        // 使中轴元素处于有序的位置
        arr[j] = pivot;
        return j;
    }


    //测试
    public static void main(String[] args) {

        int[] arr = {5, 6, 8, 9, 1, 2, 3, 4, 9, 7};
        System.out.println( "排序前" + Arrays.toString( arr ) );
        quickSort( arr, 0, arr.length - 1 );
        System.out.println( "排序后" + Arrays.toString( arr ) );
    }
}