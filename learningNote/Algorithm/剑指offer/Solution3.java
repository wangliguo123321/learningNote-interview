import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author liguo
 * @Description 从尾到头打印链表
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @思路 入栈，出栈；利用栈储存整个链表，然后stack.pop()出栈；
 */
public class Solution3 {


    public ArrayList <Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList <Integer> arrayList = new ArrayList <>();
        Stack <Integer> stack = new Stack <>();
        //入栈
        while (listNode != null) {
            stack.push( listNode.val );
            listNode = listNode.next;
        }
        //出栈
        while (!stack.isEmpty()) {
            arrayList.add( stack.pop() );
        }
        return arrayList;
    }

}