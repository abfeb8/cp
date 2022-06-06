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
        var set = new HashSet<ListNode>();
        
        ListNode a = headA, b = headB;
        
        while(a!=null){
            set.add(a);
            a = a.next;
        }
        
        while(b!=null){
            if(set.contains(b)){
                return b;
            }
            b = b.next;
        }
        
        return null;
    }
}