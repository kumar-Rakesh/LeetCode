class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int rightMax[]=new int[n];
        rightMax[n-1]=prices[n-1];
        for(int i=n-2;i>=0;--i){
            if(prices[i]>rightMax[i+1]){
                rightMax[i]=prices[i];
            }else{
                rightMax[i]=rightMax[i+1];
            }
        }
        int res=0;
        for(int i=0;i<n;++i){
            res=Math.max(res, rightMax[i]-prices[i]);
        }
        return res;
    }
}