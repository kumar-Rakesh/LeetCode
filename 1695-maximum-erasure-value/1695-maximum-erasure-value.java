class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        int l=0, r=1, currScore=nums[0], maxScore=nums[0];
        Set<Integer> set=new HashSet<>();
        set.add(nums[0]);
        while(l<n && r<n){
            if(set.contains(nums[r])){
                currScore-=nums[l];
                set.remove(nums[l++]);
            }else{
                set.add(nums[r]);
                currScore+=nums[r++];
            }
            maxScore=Math.max(currScore, maxScore);
        }
        return maxScore;
    }
}