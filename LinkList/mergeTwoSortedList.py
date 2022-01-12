# Problem: https://leetcode.com/problems/merge-two-sorted-lists/

'''
Time complexity O(n)
Space complexity O()
'''


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def solve(list1: ListNode, list2: ListNode) -> ListNode:
    result = ListNode(0)
    temp = result
    while list1 and list2:
        if list1.val<list2.val:
            temp.next = ListNode(list1.val)
            list1 = list1.next
            temp = temp.next
        else:
            temp.next = ListNode(list2.val)
            list2 = list2.next
            temp = temp.next
        
    if list1:
        temp.next = list1
    elif list2:
        temp.next = list2

    temp = result.next
    while temp:
        print(temp.val)
        temp = temp.next  

    return result.next


# !driver code
if __name__ == '__main__':
    list1 = ListNode(0)
    temp = list1
    for i in input().split():
        temp.next = ListNode(i)
        temp = temp.next

    list2 = ListNode(0)
    temp = list2
    for i in input().split():
        temp.next = ListNode(i)
        temp = temp.next

    solve(list1.next, list2.next)
