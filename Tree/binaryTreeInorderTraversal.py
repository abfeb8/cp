# Problem: https://leetcode.com/problems/binary-tree-inorder-traversal/

'''
Time complexity O(N)
Space complexity O(N)
'''


from platform import node


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self) -> str:
        return str(self.val)


def preorderTraversal(root: TreeNode) -> list[int]:
    result = []
    if root:
        result.extend(preorderTraversal(root.left))
        result.append(root.val)       
        result.extend(preorderTraversal(root.right))
    return result


# !driver code
if __name__ == '__main__':
    root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)
    root.right.left = None
    root.right.right = TreeNode(4)
    print(preorderTraversal(root))
    for i in preorderTraversal(root):
        print(i)
