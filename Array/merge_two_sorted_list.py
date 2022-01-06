# https://leetcode.com/problems/merge-two-sorted-lists/

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


'''
Time complexity O(n)
Space complexity O(n)
'''
def solve(l1,l2) -> ListNode():
    result = ListNode(0)
    cur = result
    while(l1 and l2):
        if(l1.val<l2.val):
            cur.next = l1
            l1 = l1.next
        else:
            cur.next = l2
            l2 = l2.next
        cur = cur.next
    
    if l1:
        cur.next = l1
    elif l2:
        cur.next = l2 

    return result.next


# !driver code
if __name__ == "__main__":
    l1 = ListNode(0)
    curr = l1
    for i in map(int, input().split(",")):
        curr.next = ListNode(i)
        curr = curr.next
    l1 = l1.next

    l2 = ListNode(0)
    curr = l2
    for i in map(int, input().split(",")):
        curr.next = ListNode(i)
        curr = curr.next
    l2 = l2.next

    r = solve(l1, l2)
    while r:
        if r.next:
            print(r.val, end=",")
        else:
            print(r.val)
        r = r.next
