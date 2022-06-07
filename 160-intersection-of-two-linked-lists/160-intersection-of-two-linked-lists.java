/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode a = headA, b = headB;
        int A = 0, B = 0;
        
        while(a!=null){
            A++;
            a = a.next;
        }
        
        while(b!=null){
            B++;
            b = b.next;
        }
        
        a = headA; b = headB;
        int extra = A-B;
        
        while(extra>0){
            if(a == null) return null;
            a = a.next;
            extra--;
        }
        while(extra < 0){
            if(b == null) return null;
            b = b.next;
            extra++;
        }
        
        System.out.println(a.val + " " + b.val);
        
        while(a != null && b!= null){
            if(a == b)
                return a;
            a = a.next;
            b = b.next;
        }

        return null;
    }
}