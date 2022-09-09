class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        res[0]=nums[0];
        for(int i=1;i<n;++i){
            res[i]=nums[i]*res[i-1];
        }
        int right=nums[n-1];
        res[n-1]=res[n-2];
        for(int i=n-2;i>=1;--i){
            res[i]=res[i-1]*right;
            right=right*nums[i];
        }
        res[0]=right;
        return res;
    }
}