public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;++i){
            int bit=1&(n>>i);
            res=(res<<1)|bit;
        }
        return res;
    }
}