class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n=nums.size();
        vector<pair<int, int>> v;
        for(int i=0;i<nums.size();++i){
            v.push_back(make_pair(nums[i],i));
        }
        sort(v.begin(), v.end());
        int i=0, j=nums.size()-1;
        vector<int> res;
        while(i<j){
            int sum=v[i].first+v[j].first;
            if(sum==target){
                res.push_back(v[i].second);
                res.push_back(v[j].second);
                break;
            }else if(sum<target){
                ++i;
            }else{
                --j;
            }
        }
        return res;
    }
};
