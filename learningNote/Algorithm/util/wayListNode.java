import java.util.*;

/**
 * @Author liguo
 * @Description
 */

public class wayListNode {


    //反转链表
    public ListNode reverse1(ListNode head) {
        if (head.next == null) return head;
        ListNode newHead = reverse1( head.next );
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //非递归实现链表的反转
    public ListNode reverse2(ListNode head) {
        if (head == null) return head;
        ListNode next, pre =null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //输入两个链表，找出它们的第一个公共结点。
    //第一种方法
    public ListNode FindFirstCommonNode0(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
//遍历找到长度
        int count1 = 0;
        ListNode p1 = pHead1;
        while (p1 != null) {
            p1 = p1.next;
            count1++;
        }
        int count2 = 0;
        ListNode p2 = pHead2;
        while (p2 != null) {
            p2 = p2.next;
            count2++;
        }
//计算长度,让长的走长度差个单位
        int flag = count1 - count2;
        if (flag > 0) {
            while (flag > 0) {
                pHead1 = pHead1.next;
                flag--;
            }
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        }
        if (flag <= 0) {
            while (flag < 0) {
                pHead2 = pHead2.next;
                flag++;
            }
            //移动到找相等
            while (pHead1 != pHead2) {
                pHead2 = pHead2.next;
                pHead1 = pHead1.next;
            }
            return pHead1;
        }
        return null;
    }

    //第二种解法.最简洁表达：
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        /**
         *在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头,
         而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
         */
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    //第三种，借助HashMap来实现，先把p1储存进hashmap，然后存储p2的时候， 看一下containsKey()，有就返回
    public ListNode FindFirstCommonNode(ListNode p1, ListNode p2) {
        HashMap <Integer, Integer> hashMap = new HashMap <>();
        while (p1 != null) {
            hashMap.put( p1.val, null );
            p1 = p1.next;
        }
        while (p2 != null) {
            if (hashMap.containsKey( p2.val )) return p2;
            p2 = p2.next;
        }
        return null;
    }

    //从尾到头打印链表
    //用栈
    public ArrayList <Integer> printListFromTailToHead0(ListNode listNode) {
        ArrayList arrayList = new ArrayList <Integer>();
        Stack stack = new Stack <Integer>();
        while (listNode.next != null) {
            stack.push( listNode.val );
            listNode = listNode.next;
        }
        if (!stack.isEmpty()) {
            arrayList.add( stack.pop() );
        }
        return arrayList;
    }

    //用vector往头部插入
    public Vector <Integer> printListFromTailToHead1(ListNode listNode) {
        Vector vector = new Vector <Integer>();
        while (listNode != null) {
            vector.insertElementAt( listNode.val, 0 );
            listNode = listNode.next;
        }
        return vector;
    }


    //输出该链表中倒数第k个结点
    //两次遍历， 第一次计算出总结点数， 并储存，再遍历输出
    public ListNode FindKthToTail(ListNode head, int k) {
        int num = 1;
        ListNode p1 = head;
        while (p1 != null) {
            num++;
            p1 = p1.next;
        }
        if (num <= k) return null;

        ListNode p2 = head;
        for (int i = 1; i < num - k; i++) {
            p2 = p2.next;
        }

        return p2;
    }

    //  环形链表
    //用set进行储存
    public boolean hasCycle(ListNode head) {
        Set <ListNode> set = new HashSet <>();
        boolean ans = false;
        while (head != null) {
            if (set.contains( head.val )) {
                return true;
            } else {
                set.add( head );
                head = head.next;
            }
        }
        return false;
    }

    //快慢指针
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //环形链表返回入环的第一个值
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
// 步骤一：使用快慢指针判断链表是否有环
        ListNode p = head, p2 = head;
        boolean hasCycle = false;
        while (p2.next != null && p2.next.next != null) {
            p = p.next;
            p2 = p2.next.next;
            if (p == p2) {
                hasCycle = true;
                break;
            }
        }
        // 步骤二：若有环，找到入环开始的节点
        if (hasCycle) {
            ListNode q = head;
            while (p != q) {
                p = p.next;
                q = q.next;
            }
            return q;
        } else
            return null;
    }

    //删除链表中第k个值，

    /**
     * 一个指针先走n-1步，另一个指针从头开始向后走，当先走的那个走不下去的时候，
     * 另一个指针的位置就是待删除结点。 Java执行用时2ms
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pioneer = head;
        for (int i = 0; i < n - 1; i++) {
            pioneer = pioneer.next;
        }
        //哨兵
        ListNode pre = new ListNode( -1 );
        ListNode start = pre;
        pre.next = head;
        while (pioneer.next != null) {
            pioneer = pioneer.next;
            pre = pre.next;
        }
        //执行删除操作
        pre.next = pre.next.next;
        return start.next;
    }

    //奇数偶数链表
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode temp = second;
        while (second != null && second.next != null) {
            // 奇数放到奇数后面
            first.next = second.next;
            first = first.next;
            second.next = first.next;
            second = second.next;
        }
        // 把偶数的全部连接在后面
        first.next = temp;
        return head;
    }

    //回文链表
    public boolean isPalindrome(ListNode head) {
        //极端情况
        if (head == null || head.next == null) return true;
        //找中节点，反转链表，然后便利对比

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse( slow.next );


        while (slow.next != null) {
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode newHead = reverse( head.next );
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    //合并两个有序链表

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode ans = new ListNode( 0 );
        ListNode cur = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return ans.next;
    }
    //两数 相加
        public ListNode addTwoNumbers(ListNode one,ListNode two){
            ListNode ans = new ListNode(0);
            ListNode p = one, q = two, curr = ans;
            int carry = 0;
            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return ans.next;
        }

    //旋转链表
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k==0) return head;

        // 获取长度，对k取模，并获得尾节点rear
        int length = 1;
        ListNode rear = null;
        for (rear=head; rear.next!=null; rear=rear.next) length++;
        k %= length;

        if (k==0) return head;

        // 遍历获得倒序第k+1个节点preSubEnd，倒序第k个节点postSubStart
        ListNode preSubEnd = null, postSubStart = head;
        while (k!=length)
        {
            preSubEnd = postSubStart;
            postSubStart = postSubStart.next;
            k++;
        }

        // preSubEnd为旋转后的尾节点，将原先的尾节点rear连接上原先的头节点head
        preSubEnd.next = null;
        rear.next = head;

        return postSubStart;
    }


}

