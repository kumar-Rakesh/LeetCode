class Solution {
    public int maxOperations(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int l=0, r=n-1, res=0;
        while(l<r){
            int sum=nums[l]+nums[r];
            if(sum==k){
                ++res;
                ++l;
                --r;
            }else if(sum<k){
                ++l;
            }else{
                --r;
            }
        }
        return res;
    }
}