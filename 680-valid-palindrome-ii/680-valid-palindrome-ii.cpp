class Solution {
public:
    bool validPalindrome(string s) {
        if(s.size() == 0){
            return true;
        }
        int i=0, j=s.size()-1;
        int count=0;
        while(i<j){
            if(s[i]==s[j]){
                ++i;
                --j;
            }else{
                break;
            }
        }
        if(i+1==j || i==j)
            return true;
        return validPalindromeUtil(s, i, j-1) || validPalindromeUtil(s, i+1, j);
    }
    
    bool validPalindromeUtil(string s, int i, int j){
        while(i<j){
            if(s[i]!=s[j]){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
};