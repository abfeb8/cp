# Problem: https://leetcode.com/problems/remove-linked-list-elements/

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


def solve(head: ListNode, val: int) -> ListNode:
    result = ListNode(0)
    # dummy head
    curr = result

    # iterating over link list
    while head:
        if int(head.val) != val:
            # adding val to dummy head
            curr.next = ListNode(head.val)
            curr = curr.next
        head = head.next

    return result.next


# !driver code
if __name__ == '__main__':
    head = ListNode(0)
    temp = head
    for i in input().split():
        temp.next = ListNode(i)
        temp = temp.next

    val = int(input())
    print(solve(head.next, val))
