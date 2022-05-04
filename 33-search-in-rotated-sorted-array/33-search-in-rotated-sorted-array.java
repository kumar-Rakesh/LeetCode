class Solution {
    private int pivot(int[] nums){
        int l=0, r=nums.length;
        while(l<=r){
            if(l==r) break;
            int mid=l+(r-l)/2;
            if(nums[0]>nums[mid]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    private int search(int[] nums, int target, int l, int r){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target) return mid;
            else if(target<nums[mid]) r=mid-1;
            else l=mid+1;
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        if(nums.length==1 && nums[0]==target) return 0;
        int pivot=nums[0]<=nums[nums.length-1]?-1:pivot(nums);
        int l=0, r=nums.length-1;
        if(pivot!=-1){
            if(target>=nums[0] && target<=nums[pivot-1]){
                r=pivot-1;
            }else{
                l=pivot;
            }
        }
        return search(nums, target, l, r);
    }
}