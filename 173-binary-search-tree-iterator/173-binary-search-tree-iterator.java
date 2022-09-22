class BSTIterator {
    LinkedList<TreeNode> nodes = new LinkedList<>();
    Iterator<TreeNode> currPointer;
    
    public BSTIterator(TreeNode root) {
        dfs(root);
        currPointer = nodes.iterator();
    }
    
    private void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        nodes.add(root);
        dfs(root.right); 
    }
    
    public int next() {
        return currPointer.next().val;
    }
    
    public boolean hasNext() {
        return currPointer.hasNext();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */