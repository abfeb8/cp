# Problem: https://leetcode.com/problems/reverse-linked-list/

'''
Time complexity O(n)
Space complexity O()
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
    result = None
    curr = head
    # iterating over link list
    while curr:
        nextNode = curr.next
        
        curr.next = result
        result = curr

        curr = nextNode
    
    return result


# !driver code
if __name__ == '__main__':
    head = ListNode(0)
    temp = head
    for i in input().split():
        temp.next = ListNode(i)
        temp = temp.next
    print(solve(head.next))
