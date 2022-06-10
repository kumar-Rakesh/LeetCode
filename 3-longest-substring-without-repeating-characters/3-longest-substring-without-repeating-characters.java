class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0) return 0;
        int res=1;
        Set<Character> set=new HashSet<>();
        int l=0, r=1;
        set.add(s.charAt(l));
        while(l<n && r<n){
            char c=s.charAt(r);
            if(set.contains(c)){
                set.remove(s.charAt(l++));
            }else{
                set.add(c);
                res=Math.max(res, r-l+1);
                ++r;
            }
        }
        return res;
    }
}