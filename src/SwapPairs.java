/**
 *
 *
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.
 说明:

 你的算法只能使用常数的额外空间。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 */

public class SwapPairs {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    //用递归实现
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode t = head.next;
        //实际上就是讲链表的末尾两个进行互换然后返回，以此递归回溯
        head.next = swapPairs(head.next.next);
        t.next = head;
        return t;

    }
}
