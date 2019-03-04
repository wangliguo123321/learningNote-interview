import java.util.Stack;
import java.util.Iterator;

/**
 * @Author liguo
 * @Description 包含min函数的栈
 * @问题：定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @思路： 1:Stack 类中的pop方法，push方法，peek方法；
 * 2:min方法，借助迭代器Iterator，stack.iterator(),
 * 借助方法iterator.hasNext()的while循环，逐个比较iterator.next()和
 * @Data 2018-08-14 14:36
 */
public class Solution9 {

    Stack <Integer> stack = new Stack <Integer>();

    public void push(int node) {
        stack.push( node );
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = stack.peek();
        int temp = 0;
        Iterator <Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {                //循环比较大小；
            temp = iterator.next();
            if (min > temp) {
                min = temp;
            }
        }
        return min;
    }
}