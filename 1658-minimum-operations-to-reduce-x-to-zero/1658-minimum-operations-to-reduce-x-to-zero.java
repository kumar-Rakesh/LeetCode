class Solution {
    
    private int sum(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;++i){
            sum+=nums[i];
        }
        return sum;
    }
    
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int sum=sum(nums);
        if(sum==x) return n;
        int winSum=sum-x;
        int l=0, r=1;
        int currSum=nums[0], winSize=currSum==winSum?1:0;
        while(l<n){
            if(currSum>winSum){
                currSum-=nums[l++];
                if(currSum==winSum)
                    winSize=Math.max(winSize, r-l);
            }else{
                if(r==n) break;
                currSum+=nums[r];
                if(currSum==winSum)
                    winSize=Math.max(winSize, r-l+1);
                ++r;
            }
        }
        if(winSize==0) return -1;
        return n-winSize;
    }
}