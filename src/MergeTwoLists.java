/**
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 *
 *
 */

public class MergeTwoLists {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    //方法一
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1!=null?l1:l2;
        return dummy.next;
    }

    //方法2递归
    public static ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        if (l1 == null) {
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args){
        ListNode dummy = new ListNode(-1);
        ListNode head = new ListNode(1);
        dummy.next = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(4);
        ListNode dummy1 = new ListNode(-1);
        ListNode head1 = new ListNode(1);
        dummy1.next = head1;
        head1.next = new ListNode(2);
        head1 = head1.next;
        head1.next = new ListNode(3);
        mergeTwoLists2(dummy.next,dummy1.next);
    }

}
