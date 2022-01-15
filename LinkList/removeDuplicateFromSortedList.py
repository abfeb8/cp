# Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

'''
Time complexity O(N)
Space complexity O(1)
'''


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def __str__(self):
        p = ""
        while self:
            p += str(self.val)+"->"
            self = self.next
        return p


def solve(head: ListNode) -> ListNode:
    curr = head
    # iterating over link list
    while curr and curr.next:
        if curr.next.val == curr.val:
            curr.next = curr.next.next
            continue
        curr = curr.next

    return head


# !driver code
if __name__ == '__main__':
    head = ListNode(0)
    temp = head
    for i in input().split():
        temp.next = ListNode(i)
        temp = temp.next
    print(solve(head.next))
