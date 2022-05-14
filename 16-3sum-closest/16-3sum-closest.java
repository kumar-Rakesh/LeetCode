class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum=Integer.MAX_VALUE;
        int absDiff=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;++i){
            int j=i+1, k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                int newAbsDiff=Math.abs(sum-target);
                if(sum==target) return target;
                if(newAbsDiff<absDiff){
                    absDiff=newAbsDiff;
                    closestSum=sum;
                }
                if(sum<target) ++j;
                else --k;
            }
        }
        return closestSum;
    }
}