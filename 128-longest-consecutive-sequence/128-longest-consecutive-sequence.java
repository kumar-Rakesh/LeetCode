class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        Set<Integer> set=new TreeSet<>();
        for(int i=0;i<n;++i){
            set.add(nums[i]);
        }
        Integer prev=null, count=1, res=1;
        for(Integer val:set){
            if(prev!=null){
                if(val-prev==1){
                    ++count;
                    res=Math.max(res, count);
                }else{
                    count=1;
                }
            }
            prev=val;
        }
        return res; 
    }
}