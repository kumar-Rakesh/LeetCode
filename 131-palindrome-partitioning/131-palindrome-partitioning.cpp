class Solution {
public:
    void partitionUtil(string s, vector<vector<bool>>& palindrome, int n, vector<vector<string>>& res, vector<string> curr, int index){
        if(index==n){
            res.push_back(curr);
            return;
        }
        for(int i=index;i<n;++i){
            if(palindrome[index][i]){
                curr.push_back(s.substr(index,i-index+1));
                partitionUtil(s, palindrome, n, res, curr, i+1);
                curr.pop_back();
            }
        }
    }
    
    vector<vector<string>> partition(string s) {
        int n=s.size();
        vector<vector<bool>> palindrome(n, vector<bool>(n, false));
        for(int i=0;i<n;++i){
            palindrome[i][i]=true;
        }
        for(int i=0;i<n-1;++i){
            if(s[i]==s[i+1]){
                palindrome[i][i+1]=true;
            }
        }
        for(int len=3;len<=n;++len){
            for(int i=0;i<n-len+1;++i){
                if((i+len-1)<n){
                    if(s[i]==s[i+len-1] && palindrome[i+1][i+len-2]){
                        palindrome[i][i+len-1]=true;
                    }
                }
            }
        }
        vector<vector<string>> res;
        vector<string> curr;
        partitionUtil(s, palindrome, n, res, curr, 0);
        return res;
    }
};