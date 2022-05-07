class Solution {
    private int getConsecutiveOnes(int[] nums){
        int currCount1=0, max1=0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==0){
                currCount1=0;;
            }else{
                ++currCount1;
                max1=Math.max(currCount1, max1);
            }
        }
        return max1;
    }
    
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        if(k==0){
            return getConsecutiveOnes(nums);
        }
        int count1=0, max1=0, currStart=-1;
        Queue<Integer> q=new PriorityQueue<>();
        int i=0;
        while(i<n){
            if(nums[i]==0){
                if(q.size()<k){
                    q.add(i);
                }else{
                    int first0=q.remove();
                    currStart=first0+1;
                    count1=i-first0-1;
                    q.add(i);
                }
            }
            if(currStart==-1){
                currStart=i;
            }
            ++count1;  
            max1=Math.max(max1, count1);
            ++i;
        }
        return max1;
    }
}