class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var result = new int[m+n];
        int p1 = 0, p2 = 0, i = 0;
        
        while(p1<m && p2<n){
            if(nums1[p1] < nums2[p2])
                result[i++] = nums1[p1++];
            else
                result[i++] = nums2[p2++];
        }
        
        while(p1<m)
             result[i++] = nums1[p1++];
        
        while(p2<n)
            result[i++] = nums2[p2++];
        
        for(int j = 0; j<m+n; j++)
            nums1[j] = result[j];
    }
}