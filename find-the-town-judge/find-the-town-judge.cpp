class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> aTrustB(n+1, 0);
        vector<int> bTrustA(n+1, 0);
        for(int i=0;i<trust.size();++i){
            ++aTrustB[trust[i][0]];
            ++bTrustA[trust[i][1]];
        }
        int judge=-1, count=0;
        for(int i=1;i<=n;++i){
            if(aTrustB[i]==0 && bTrustA[i]==n-1){
                judge=i;
                ++count;
                if(count>1){
                    judge=-1;
                    break;
                }
            }
        }
        return judge;
    }
};