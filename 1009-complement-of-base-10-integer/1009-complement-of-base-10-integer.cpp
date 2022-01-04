class Solution {
public:
    int bitwiseComplement(int n) {
        if(n==0){
            return 1;
        }
        bool msbFound=false;
        for(int i=31;i>=0;--i){
            if(!msbFound){
                int bit=((1<<i)&n)>>i;
                if(bit==1){
                    msbFound=true;
                    n=(1<<i)^n;
                }
            }else{
                n=(1<<i)^n;
            }
        }
        return n;
    }
};