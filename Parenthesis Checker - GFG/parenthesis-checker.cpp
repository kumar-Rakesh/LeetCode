//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution
{
    private:
        stack<char> s;
        
        bool isOpenBrace(char c){
            if(c=='{' || c=='(' || c=='[') return true;
            return false;
        }
        
        char getOpenBrace(char c){
            if(c==']') return '[';
            else if(c=='}') return '{';
            return '(';
        }
    
    public:
        //Function to check if brackets are balanced or not.
        bool ispar(string x)
        {
            int n=x.size();
            if(n%2==1) return false;
            for(int i=0;i<n;++i){
                if(isOpenBrace(x[i])){
                    s.push(x[i]);
                }else{
                    if(s.empty()) return false;
                    else if(getOpenBrace(x[i])!=s.top()) return false;
                    else s.pop();
                }
            }
            return true;
        }

};

//{ Driver Code Starts.

int main()
{
   int t;
   string a;
   cin>>t;
   while(t--)
   {
       cin>>a;
       Solution obj;
       if(obj.ispar(a))
        cout<<"balanced"<<endl;
       else
        cout<<"not balanced"<<endl;
   }
}
// } Driver Code Ends