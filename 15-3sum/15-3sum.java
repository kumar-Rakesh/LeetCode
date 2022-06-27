class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        if(n==0) return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<n-2;++i){
            int j=i+1, k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    set.add(l);
                    ++j;--k;
                }else if(sum<0){
                    ++j;
                }else{
                    --k;
                }
            }
        }
        return new ArrayList<>(set);
    }
}