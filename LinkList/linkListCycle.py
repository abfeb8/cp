# Problem: https://leetcode.com/problems/linked-list-cycle/

'''
Time complexity O(N)
Space complexity O(1)
'''
# Floyd loop detection


def solve(head) -> bool:
    slow = fast = head
    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next
        if slow == fast:
            return True
    return False


# !driver code

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


if __name__ == '__main__':
    head = ListNode(0)
    temp = head
    for i in input().split():
        temp.next = ListNode(i)
        temp = temp.next

    print(solve(head.next))
