class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long hmax = 0, vmax = 0, mod = (long)1e9+7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int pre = 0;
        for(int i : horizontalCuts){
            hmax = Math.max(i-pre, hmax);
            pre = i;
        }
        hmax = Math.max(h-pre, hmax);
        
        pre = 0;
        for(int i : verticalCuts){
            vmax = Math.max(i-pre, vmax);
            pre = i;
        }
        vmax = Math.max(w-pre, vmax);
        
        
        // System.out.println(hmax + " " + vmax);
        
        return (int) ((hmax*vmax)%mod);
    }
}