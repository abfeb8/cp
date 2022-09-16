/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        
        ListNode[] l = divide(node);
        ListNode a = mergeSort(l[0]);
        ListNode b = mergeSort(l[1]);
        // a.next = null;
        
        return merge(a, b);
    }
    
    private ListNode[] divide(ListNode node){
        ListNode s = node, f = node, pr = node;
        while(f != null && f.next != null){
            pr = s;
            s = s.next;
            f = f.next.next;
        }
        
        pr.next = null;
        return new ListNode[]{node, s};
    }
    
    private ListNode merge(ListNode a, ListNode b){
        ListNode tempHead = new ListNode();
        ListNode result = tempHead;
        while(a != null && b != null){
            ListNode nxtNode;
            if(a.val <= b.val){
                nxtNode = a.next;
                result.next = a;
                a.next = null;
                a = nxtNode;
            } else {
                nxtNode = b.next;
                result.next = b;
                b.next = null;
                b = nxtNode;
            }
            result = result.next;
        }
        
        if(a!=null){
            result.next = a;
        }
        if(b!=null){
            result.next = b;
        }
        
        return tempHead.next;
    }
}