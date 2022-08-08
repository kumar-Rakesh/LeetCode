class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> t1=new ArrayList<Integer>();
        t1.add(1);
        res.add(new ArrayList<Integer>(t1));
        if(numRows==1) return res;
        t1.add(1);
        res.add(new ArrayList<Integer>(t1));
        if(numRows==2) return res;
        for(int i=3;i<=numRows;++i){
            List<Integer> temp=new ArrayList<Integer>();
            temp.add(1);
            for(int j=0;j<t1.size()-1;++j){
                temp.add(t1.get(j)+t1.get(j+1));
            }
            temp.add(1);
            res.add(new ArrayList<Integer>(temp));
            t1=temp;
        }
        return res;
    }
}