class Solution {
    
    private int lSearch(int[] nums, int l, int r, int target){
        if(l>r) return -1;
        int mid=l+(r-l)/2;
        if(nums[mid]==target){
            int left=lSearch(nums, l, mid-1, target);
            left=left>-1?left:mid;
            return left;
        }else if(nums[mid]<target){
            return lSearch(nums, mid+1, r, target);
        }
        return lSearch(nums, l, mid-1, target);
    }
    
    private int rSearch(int[] nums, int l, int r, int target){
        if(l>r) return -1;
        int mid=l+(r-l)/2;
        if(nums[mid]==target){
            int right=rSearch(nums, mid+1, r, target);
            right=right>-1?right:mid;
            return right;
        }else if(nums[mid]<target){
            return rSearch(nums, mid+1, r, target);
        }
        return rSearch(nums, l, mid-1, target);
    }
    
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] res=new int[2];
        res[0]=-1;
        res[1]=-1;
        if(n==0) return res;
        int left=lSearch(nums, 0, n-1, target);
        int right=rSearch(nums, 0, n-1, target);
        res[0]=left;
        res[1]=right;
        return res;
    }
}