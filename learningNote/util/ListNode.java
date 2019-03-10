/**
 * @Author liguo
 * @Description
 */
class wayListNode {

    //反转链表
   public static ListNode reverse(ListNode head){
        if(head.next == null )  return head;
        ListNode newHead = reverse (head.next );
        head.next.next = head ;
        head.next = null ;
        return newHead ;
    }
}


class ListNode {
    Integer data;
    ListNode next;

}