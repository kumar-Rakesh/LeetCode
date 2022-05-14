class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        Set<Integer> set=new TreeSet<>();
        for(int n: nums){
            set.add(n);
        }
        int prev=-1, maxDiff=0;
        for(int n: set){
            if(prev!=-1){
                maxDiff=Math.max(Math.abs(prev-n), maxDiff);
            }
            prev=n;
        }
        return maxDiff;
    }
}