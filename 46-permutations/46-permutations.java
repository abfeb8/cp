class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        Set<Integer> taken = new HashSet<>();
        helper(nums, taken, new ArrayList<Integer>());
        
        return result;
    }
    
    private void helper(int[] nums, Set<Integer> taken, List<Integer> list){
        int n = nums.length;
        if(list.size() == n){
            result.add(new ArrayList(list));
            return;
        }
        
        for(int i : nums){
            if (!taken.contains(i)) {
                taken.add(i);
                list.add(i);
                helper(nums, taken, list);
                taken.remove(i);
                list.remove(list.size()-1);
            } 
        }
    }
}