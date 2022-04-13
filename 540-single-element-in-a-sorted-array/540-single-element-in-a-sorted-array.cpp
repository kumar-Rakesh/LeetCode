class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int size=nums.size();
        int start=0, end=size-1;
        while(start<=end){
            if(start==end)
                return nums[start];
            int mid=start+(end-start)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
                return nums[mid];
            if(nums[mid]==nums[mid-1]){
                if((mid-start+1)%2!=0)
                    end=mid;
                else
                    start=mid+1;
            }else{
                if((end-mid+1)%2!=0)
                    start=mid;
                else
                    end=mid-1;
            }
        }
        return nums[end];
    }
};