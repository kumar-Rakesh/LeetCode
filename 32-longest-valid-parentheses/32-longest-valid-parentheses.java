class Solution {
    
    private boolean isOpenBrace(char c){
        return c=='(';
    }
    
    private boolean isCloseBrace(char c){
        return c==')';
    }
    
    private char getOpenBrace(char c){
        if(c==')'){
            return '(';
        }
        return '#';
    }
    
    public int longestValidParentheses(String s) {
        int n=s.length();
        if(n==0) return 0;
        int resMax=0;
        Stack<Integer> st=new Stack<>();
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(st.isEmpty() || isOpenBrace(c)){
                st.push(i);
            }else{
                if(getOpenBrace(c)==s.charAt(st.peek())){
                    st.pop();
                    if(st.isEmpty()){
                        resMax=Math.max(resMax, i+1);
                    }else{
                        resMax=Math.max(resMax, i-st.peek());
                    }
                }else{
                    st.push(i);
                }
            }
            ++i;
        }
        return resMax;
    }
}