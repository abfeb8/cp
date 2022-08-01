class NumArray {
    
    class Segment {
        int low, high, val;
        Segment left, right;
        
        public Segment(int l, int h){
            low = l;
            high = h;
        }
    }
    
    Segment seg;

    public NumArray(int[] nums) {
        seg = new Segment(0, nums.length-1);
        buildSeg(nums, seg);
    }
    
    private Segment buildSeg(int[] nums, Segment root){
        
        if(root.low == root.high){
            root.val = nums[root.low];
            return root;
        }
        int mid = (root.low + root.high)/2;
        root.left = buildSeg(nums, new Segment(root.low, mid));
        root.right = buildSeg(nums, new Segment(mid+1, root.high));
        root.val = root.left.val + root.right.val;
        return root;
    }
    
    public void update(int node, int val) {
        updateSeg(seg, node, val);
    }
    
    private void updateSeg(Segment seg, int node, int val){
        if(seg.low == seg.high){
            seg.val = val;
            return;
        }
        int mid = (seg.low+seg.high)/2;
        if(seg.low<=node && mid>=node)
            updateSeg(seg.left, node, val);
        else
            updateSeg(seg.right, node, val);
        seg.val = seg.left.val + seg.right.val;
    }
    
    public int sumRange(int low, int high) {
        return getSum(seg, low, high);
    }
    
    private int getSum(Segment seg, int low, int high){
        if(seg.low>=low && seg.high<=high){
            return seg.val;
        }
        if(seg.high<low || seg.low>high){
            return 0;
        }
        
        return getSum(seg.left, low, high) + getSum(seg.right, low, high);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */