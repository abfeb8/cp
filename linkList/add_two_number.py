# https://leetcode.com/problems/add-two-numbers/

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

'''
Time complexity O(n) -> we iterate every element one ones
Space complexity O(n) -> because we are storing result in a link list 
'''
def solve(l1, l2):
    result = ListNode(0)
    curr = result
    carry = 0
    # we iterate over both l1 and l2 until one of them ends
    while(l1 and l2):
        s = l1.val+l2.val+carry
        carry = s//10
        base = s % 10
        curr.next = ListNode(base)
        curr = curr.next
        l1 = l1.next
        l2 = l2.next

    # if l1 is left we add it to result 
    while l1:
        s = l1.val+carry
        carry = s//10
        base = s % 10
        curr.next = ListNode(base)
        curr = curr.next
        l1 = l1.next

    # if l2 is left we add it to result
    while l2:
        s = l2.val+carry
        carry = s//10
        base = s % 10
        curr.next = ListNode(base)
        curr = curr.next
        l2 = l2.next

    # if there is a carry we add it to result
    if carry:
        curr.next = ListNode(carry)
    result = result.next

    return result


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

    solve(l1, l2)
