//package LG.nowcoder;
//
///**
// * @Author liguo
// * @Description
// * @Data 2018-08-12 9:57
// * <p>

// * }
// */
//
//import java.util.ArrayList;
//import java.util.Stack;
//     class wayListNode {
//        int val;
//        wayListNode next = null;
//
//        wayListNode(int val) {
//            this.val = val;
//        }
//    }
//
//
//
//
//import java.util.Stack;
//import java.util.ArrayList;
//
//public class Solution2 {
//
//    public ArrayList<Integer> printListFromTailToHead(wayListNode listNode) {
//        Stack<Integer> stack = new Stack <>();
//        ArrayList <Integer> list = new ArrayList <>();
//        while (listNode != null) {
//            stack.push( listNode.val );         //push方法进栈
//            listNode = listNode.next;
//        }
//        while (!stack.empty()) {                //empty()方法判断非空
//            list.add( stack.pop() );             //pop（）方法取出栈顶元素并加入新链表中
//        }
//        return list;
//    }
//}