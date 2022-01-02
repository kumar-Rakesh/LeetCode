class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        int n=time.size();
        int res=0;
        vector<int> rem;
        for(int i=0;i<n;++i){
            rem.push_back(time[i]%60);
        }
        map<int,vector<int>> mp;
        vector<int> v;
        v.push_back(0);
        mp[rem[0]]=v;
        for(int i=1;i<n;++i){
            int val=abs(60-rem[i]);
            if(val==60){
                if(mp.find(0)!=mp.end()){
                    res+=mp[0].size();
                }
            }else if(mp.find(val)!=mp.end()){
                res+=(mp[val].size());
            }
            if(mp.find(rem[i])==mp.end()){
                vector<int> v1;
                v1.push_back(i);
                mp[rem[i]]=v1;
            }else{
                mp[rem[i]].push_back(i);
            }
        }
        return res;
    }
};