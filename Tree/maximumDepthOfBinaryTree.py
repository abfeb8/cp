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

    def getDepth(root: TreeNode, currDepth=0) -> int:
        # if root is null return 0
        if not root:
            return 0
        # if we hit leaf node return 1
        if not (root.left or root.right):
            return currDepth+1
        currDepth += 1
        if root.right and root.left:
            currDepth = max(getDepth(root.left, currDepth),
                            getDepth(root.right, currDepth))
        elif root.right:
            currDepth = getDepth(root.right, currDepth)
        elif root.left:
            currDepth = getDepth(root.left, currDepth)
        return currDepth

    return getDepth(root)


# !driver code
if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right.left = TreeNode(5)
    root.right.left.left = TreeNode(6)
    root.right.right = TreeNode(4)
    print(maxDepth(root))
