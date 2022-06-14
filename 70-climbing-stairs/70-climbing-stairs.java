class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] dp=new int[n+1];
        Arrays.fill(dp, 0);
        dp[n]=1;
        for(int i=n-1;i>=0;--i){
            if(i+1<=n) dp[i]+=dp[i+1];
            if(i+2<=n) dp[i]+=dp[i+2];
        }
        return dp[0];
    }
}