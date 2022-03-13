class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(int i = 0;i < s.size(); ++i){
            if(s[i] == '[' || s[i] == '{' || s[i] == '('){
                st.push(s[i]);
            }else{
                if(st.empty()){
                    return false;
                }
                char top = st.top();
                st.pop();
                if(s[i] != getClosingBracket(top)){
                    return false;
                }
            }
        }
        if(st.empty())
            return true;
        return false;
    }
    
    char getClosingBracket(char c){
        switch(c){
            case '[' : return ']';
            case '{' : return '}';
            case '(' : return ')';    
        }
        return ']';
    }
};