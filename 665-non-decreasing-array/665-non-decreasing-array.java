class Solution {
    public boolean checkPossibility(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=n-1;i>=2;--i){
            if(nums[i-2]<=nums[i-1] && nums[i-1]<=nums[i]) continue;
            else if(nums[i-2]>nums[i-1] && nums[i-1]>nums[i]){
                count=2;
            }else if(nums[i-2]>nums[i-1] && nums[i-2]>nums[i] && nums[i-1]<=nums[i]){
                nums[i-2]=nums[i-1];
                ++count;
            }else if(nums[i-2]>nums[i-1] && nums[i-2]<nums[i] && nums[i-1]<nums[i]){
                if(i-3>=0){
                    if(nums[i-3]>nums[i-1]){
                        nums[i-1]=nums[i-2];
                    }else{
                        nums[i-2]=nums[i-1];
                    }
                    ++count;
                }else{
                    nums[i-2]=nums[i-1];
                    ++count;
                }
            }else if(nums[i-2]<nums[i-1] && nums[i-2]<nums[i] && nums[i-1]>nums[i]){
                nums[i]=nums[i-1];
                ++count;
            }else if(nums[i-2]<nums[i-1] && nums[i-2]>nums[i] && nums[i-1]>nums[i]){
                nums[i]=nums[i-1];
                ++count;
            }
            if(count>1){
                break;
            }
        }
        if(count>1) return false;
        return true;
    }
}