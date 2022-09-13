class Solution {
    
    private int countBitsUtil(int n){
        int count=0;
        for(int i=0;i<32;++i){
            if((1&n)==1)++count; 
            n=n>>1;
        }
        return count;
    }
    
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        for(int i=0;i<=n;++i){
            ans[i]=countBitsUtil(i);
        }
        return ans;
    }
}