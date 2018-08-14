/**
 *
 * 描述：
 *
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 解析：
 *
 * 这道并不是什么难题，算法很简单，链表的数据类型也不难。就是建立一个新链表，然后把输入的两个链表从头往后撸，每两个相加，添加一个新节点到新链表后面，就是要处理下进位问题。还有就是最高位的进位问题要最后特殊处理一下。
 *
 * 出处：
 *
 * http://www.cnblogs.com/grandyang/p/4129891.html
 *
 */

public class AddTwoNumbers {


    //     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int carry = 0;

        while(l1!=null || l2!=null){
            int d1 = l1==null?0:l1.val;
            int d2 = l2==null?0:l2.val;

            int sum = d1 + d2 +carry;

            curr.next = new ListNode(sum%10);
            curr = curr.next;

            carry = sum>=10?1:0;

            if(l1!=null){
                l1 = l1.next;
            }

            if(l2!=null){
                l2 = l2.next;
            }

        }

        if(carry==1){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
