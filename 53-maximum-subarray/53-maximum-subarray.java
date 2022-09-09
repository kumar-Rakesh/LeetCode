class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int countNeg=0, sum=0, res=0, maxVal=nums[0];
        int maxSum[]=new int[n];
        for(int i=0;i<n;++i){
            if(nums[i]<0)++countNeg;
            maxVal=Math.max(maxVal, nums[i]);
            if(sum+nums[i]>0){
                sum+=nums[i];
                res=Math.max(res, sum);
            }else{
                sum=0;
            }
        }
        if(countNeg == n){
            return maxVal;
        }
        return res;
    }
}