class Solution {
    public int getSum(int a, int b) {
        int carry=(a&b)<<1;
        int sum=a^b;
        while(carry!=0){
            int newCarry=(sum&carry)<<1;
            sum=sum^carry;
            carry=newCarry;
        }
        return sum;
    }
}