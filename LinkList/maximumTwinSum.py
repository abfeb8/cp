'''
Time complexity O(n)
Space complexity O()
'''

def solve(head):
    temp = head
    n = 0
    arr = []
    while(temp):
        n+=1
        arr.append(temp.val)
        temp = temp.next
    
    maxSum = 0
    for i in range(n//2):
        maxSum=max(maxSum,arr[i]+arr[n-i-1])
    return maxSum


# !driver code
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

if __name__ == "__main__":
    head = ListNode()
    temp = head
    for i in input().split():
        temp.next = ListNode(int(i))
        temp = temp.next
        
    print(solve(head.next))