/**
 *
 *
 *
 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

 示例:

 输入:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 输出: 1->1->2->3->4->4->5->6
 *
 */

public class MergeKLists {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  //分治法
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        int size = lists.length;
        while (size>1){
            int half = (size+1)/2;  //这里加1我想是为了处理奇数的
            for (int i = 0; i < size / 2; i++) {
                lists[i] = mergeTwoLists(lists[i],lists[i+half]);
            }
            size = half;
        }
        return lists[0];
    }

    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1!=null&l2!=null){
            if(l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1!=null){
            curr.next = l1;
        }
        if(l2!=null){
            curr.next = l2;
        }
        return dummy.next;
    }

}
