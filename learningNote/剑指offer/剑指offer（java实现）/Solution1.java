
/**
 * @Author liguo
 * @Description 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @Data 2018-08-11 21:50
 */

import java.util.Stack;
public class Solution1 {
    Stack <Integer> stack1 = new Stack <Integer>();
    Stack <Integer> stack2 = new Stack <Integer>();

    public void push(int node) {
        stack1.push( node );                                  //直接入栈
    }
    public int pop() {
        if (stack1.empty() && stack2.empty()) {               //判断栈为空
            throw new RuntimeException( "空的链表" );
        }
        if (stack2.empty()) {                                 //当第二个栈非空时，复制第一个栈到第二个栈
            while (!stack1.empty()) {
                stack2.push( stack1.pop() );
            }
        }
        return stack2.pop();                                 //返回第二个栈顶
    }
}
