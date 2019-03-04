/**
 * @Author liguo
 * @Description 输入一个链表，反转链表后，输出新链表的表头。
 * 思路：定义当前head，前序节点pre，后续节点next；
 * 依次遍历所有节点，将所有节点的next指向前一个节点
 * @Data 2018-08-13 23:24
 */
public class Solution4 {
    public ListNode ReverseList(ListNode head) {
            ListNode pre = null;
            ListNode next = null;
            while (head != null) {
                next = head.next;//持有下一个节点的引用
                head.next = pre;//将当前节点对下一个节点的引用指向前一个节点
                pre = head;//将前一个节点指向当前节点
                head = next;//将当前节点指向下一个节点
            }
            return pre;
    }
}