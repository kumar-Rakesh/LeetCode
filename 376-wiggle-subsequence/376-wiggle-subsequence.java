class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;
        if(n==2){
            return nums[0]!=nums[1]?2:1;
        }
        int res=1;
        char[] sign=new char[n];
        int[] dp=new int[n];
        Arrays.fill(sign, '+');
        Arrays.fill(dp, 1);
        for(int i=1;i<n;++i){
            for(int j=0;j<i;++j){
                if(nums[j]==nums[i]) continue;
                if(dp[j]==1){
                    int diff=nums[i]-nums[j];
                    int val=dp[j]+1;
                    if(val>dp[i]){
                        dp[i]=val;
                        if(diff>0){
                            sign[i]='+';
                        }else{
                            sign[i]='-';
                        }
                    }
                }else{
                    int diff=nums[i]-nums[j];
                    if(diff>0 && sign[j]=='-'){
                        int val=dp[j]+1;
                        if(val>dp[i]){
                            dp[i]=val;
                            sign[i]='+';
                        }
                    }else if(diff<0 && sign[j]=='+'){
                        int val=dp[j]+1;
                        if(val>dp[i]){
                            dp[i]=val;
                            sign[i]='-';
                        }
                    }
                }
                res=Math.max(dp[i], res);
            }
        }
        return res;
    }
}