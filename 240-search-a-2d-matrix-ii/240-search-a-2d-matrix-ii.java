class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        int m=nums.length;
        int n=nums[0].length;
        int i=0, j=n-1;
        while(i>=0 && i<m && j>=0 && j<n){
            if(target==nums[i][j]){
                return true;
            }else if(target<nums[i][j]){
                --j;
            }else if(target>nums[i][j]){
                ++i;
            }
        }
        return false;
    }
}