
/**
 * @Author liguo
 * @Description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
首先判断两个链表非空；
定义答案节点，小的就赋值给answer，递归求出answer.next
 * @Data 2018-08-13 23:41
 */
public class Solution5 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        //首先判断两个链表非空
        if(list1==null)             return list2;
        if(list2==null)             return list1;
        //定义答案节点，小的就赋值给answer，递归求出answer.next
        ListNode answer=null;
        if (list1.val<list2.val){
            answer = list1;
            answer.next= Merge(list1.next,list2);
        }else {
            answer= list2;
            answer.next= Merge(list1,list2.next);
        }
        return answer;
    }
}