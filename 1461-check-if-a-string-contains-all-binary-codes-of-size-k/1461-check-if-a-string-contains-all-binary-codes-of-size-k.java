class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = 0, t = 0;
        while(t < k){
            n+=Math.pow(2,t);
            t++;
        }
        
        boolean[] arr = new boolean[n+1];
        var set = new HashSet<String>();
        // System.out.println(n);
        
        int l = s.length();
        for(int i = 0; i<=l-k; i++){
            String tempS = s.substring(i, i+k);
            if(!set.contains(tempS)){
                set.add(tempS);
                arr[Integer.parseInt(tempS, 2)] = true;
            }    
        }
        
        for(boolean b : arr){
            if(!b)
                return false;
        }
        
        return true;
    }
}