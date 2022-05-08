class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st=new Stack<Character>();
        Stack<Integer> cst=new Stack<>();
        int i=0;
        while(i<s.length()){
            if(st.isEmpty() || s.charAt(i) != st.peek()){
                st.push(s.charAt(i++));
                cst.push(1);
            }else{
                st.push(s.charAt(i++));
                cst.push(cst.peek()+1);
                if(cst.peek()==k){
                    int count=0;
                    while(!st.isEmpty() && count<k){
                        st.pop();
                        cst.pop();
                        ++count;
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
            cst.pop();
        }
        if(sb.isEmpty()){
            return sb.toString();
        }
        return sb.reverse().toString();
    }
}