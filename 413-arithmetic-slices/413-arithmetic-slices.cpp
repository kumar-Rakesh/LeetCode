class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int size = nums.size();
        vector<bool> ap1(size, false);
        int result = 0;
        for(int i = 2; i < size; ++i){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                ap1[i] = true;
                ++result;
            }
        }
        for(int l = 4; l <= size; ++l){
            vector<bool> ap2(size, false);
            for(int i = l-1; i < size; ++i){
                if(ap1[i-1]){
                    if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                        ++result;
                        ap2[i] = true;
                    }else{
                        ap2[i] = false;
                    }
                }
            }
            ap1 = ap2;
        }
        return result;
    }
};