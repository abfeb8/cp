# Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/

'''
Time complexity O(N)
Space complexity O()
'''


from ast import Lambda
import collections
from webbrowser import get


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def maxDepth(root: TreeNode) -> int:
    if not root:
        return 0
    return max(maxDepth(root.left), maxDepth(root.right)) + 1


# !driver code
if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right.left = TreeNode(5)
    root.right.left.left = TreeNode(6)
    root.right.right = TreeNode(4)
    print(maxDepth(root))
