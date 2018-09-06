/**
 *
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。

 k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。

 示例 :

 给定这个链表：1->2->3->4->5

 当 k = 2 时，应当返回: 2->1->4->3->5

 当 k = 3 时，应当返回: 3->2->1->4->5

 说明 :

 你的算法只能使用常数的额外空间。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 */

public class ReverseKGroup {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    //两个函数
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k == 1) return head;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode curr = head;
        dummy.next = head;
        int i = 0;
        while (curr!=null){
            ++i;
            if(i%k==0){
                pre = reverseNode(pre,curr.next);
                curr = pre.next;
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public ListNode reverseNode(ListNode pre,ListNode next){
        //为什么要用last记录一下，因为要返回下一个翻转的前一个NODE
        ListNode last = pre.next;
        ListNode curr = last.next;
        while(curr!=next){
            last.next = curr.next;
            //为什么用Pre.next?因为Pre.next指向上一个curr
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }
        return last;
    }

}
