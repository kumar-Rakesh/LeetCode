class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp=new int[n];
        int currMin=Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(n-1).size();++i){
            dp[i]=triangle.get(n-1).get(i);
            currMin=Math.min(currMin, dp[i]);
        }
        if(n==1) return currMin;
        for(int i=n-2;i>=0;--i){
            int k=n-1;
            for(int j=triangle.get(i).size()-1;j>=0;--j){
                int x=triangle.get(i).get(j)+dp[k];
                int y=triangle.get(i).get(j)+dp[k-1];
                dp[k--]=Math.min(x, y);
            }
        }
        return dp[n-1];
    }
}