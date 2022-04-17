class Solution {
public:
    
    int search(vector<int>& arr, int x){
        int l = 0, r = arr.size()-1;
        while(l <= r){
            if(l == r){
                break;
            }
            int m = l + (r-l)/2;
            if(arr[m] < x){
                l = m + 1;
            }else if(arr[m] > x){
                r = m - 1;
            }else{
                return m;
            }
        }
        return l;
    }
    
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        int index = search(arr, x);
        long lDiff = INT_MAX, rDiff = INT_MAX, diff = INT_MAX;
        if(index-1 >= 0){
            lDiff = abs((long)x - arr[index-1]);
        }
        if(index+1 < n){
            rDiff = abs((long)x - arr[index+1]);
        }
        diff = abs((long)x - arr[index]);
        if((lDiff < diff) || (lDiff == diff)){
            index = index-1;
        }else if(rDiff < diff){
            index = index+1;
        }
        int i = index, j = index;
        while(j-i+1 < k){
            int left = i-1 >= 0 ? arr[i-1] : INT_MAX;
            int right = j+1 < n ? arr[j+1] : INT_MAX;
            long leftDiff = abs((long)left-x);
            long rightDiff = abs((long)right-x);
            if(left != INT_MAX && right != INT_MAX){
                if(leftDiff < rightDiff){
                    --i;
                }else if(leftDiff > rightDiff){
                    ++j;
                }else if(leftDiff == rightDiff && left < right){
                    --i;
                }else{
                    ++j;
                }
            }else if(left == INT_MAX && right == INT_MAX){
                break;
            }else if(left == INT_MAX){
                ++j;
            }else{
                --i;
            }
        }
        vector<int> res;
        for(i;i<=j;++i){
            res.push_back(arr[i]);
        }
        return res;
    }
};