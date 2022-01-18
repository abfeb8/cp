# Problem: https://leetcode.com/problems/binary-tree-level-order-traversal/

'''
Time complexity O(n)
Space complexity O()
'''


import collections

from numpy import true_divide


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def levelOrder(root: TreeNode) -> list[list[int]]:
    # if root is null, return empty list
    if not root:
        return []

    # initialising queue to store levels
    queue = collections.deque()

    # initialising result
    result: list[list[int]] = []

    # adding root element to queue as list[TreeNode]
    queue.append([root])

    while len(queue):
        currLevel: list[TreeNode] = queue.popleft()
        nextLevel: list[TreeNode] = []
        # temp is to store current level node value
        temp = []
        isCurrLevelEmpty: bool = True

        for node in currLevel:
            # process node and add child node to nextLevel
            temp.append(node.val)
            if node.left:
                nextLevel.append(node.left)
            if node.right:
                nextLevel.append(node.right)
            isCurrLevelEmpty = False

        if(not isCurrLevelEmpty):
            queue.append(nextLevel)
            result.append(temp.copy())

    return result


# !driver code
if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(4)
    print(levelOrder(root))
