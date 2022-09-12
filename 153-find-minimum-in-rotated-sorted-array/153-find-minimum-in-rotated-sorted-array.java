class Solution {
    
    private int pivot(int[] nums, int l, int r){
        while(l<r){
            if(l == r-1) return Math.min(nums[l], nums[r]);
            int mid = l + (r - l)/2;
            if(nums[mid] < nums[l]){
                r = mid;
            }else{
                l = mid;
            }
        }
        return r;
    }
    
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1 || nums[0] < nums[n-1]) return nums[0];
        return pivot(nums, 0, n-1);
    }
}