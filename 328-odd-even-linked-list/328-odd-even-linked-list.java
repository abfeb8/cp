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
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;
        
        ListNode oddHead = head, evenHead = head.next;
        if(evenHead == null)
            return oddHead;
        
        ListNode oddNode = oddHead, evenNode = evenHead;
        ListNode curNode = head.next.next;
        evenHead.next = null;
        boolean oddFlag = true;
        
        while(curNode != null) {
            ListNode nxtNode = curNode.next;
            curNode.next = null;
            if(oddFlag){
                oddNode.next = curNode;
                oddNode = curNode;
                oddFlag = false;
            } else {
                evenNode.next = curNode;
                evenNode = curNode;
                oddFlag = true;
            }
            curNode = nxtNode;
        }
        
        oddNode.next = evenHead;
        return oddHead;
    }
}