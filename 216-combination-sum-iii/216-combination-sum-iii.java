class Solution {
    
    private List<List<Integer>> list = new ArrayList<>();
    
    private void combinationSum3(int k, int n, int index, LinkedList<Integer> curr){
        if(n==0 && curr.size()==k){
            this.list.add(new LinkedList(curr));
            return;
        }
        if(n<0 || index>9) return;
        for(int i=index;i<=9;++i){
            curr.add(i);
            combinationSum3(k, n-i, i+1, curr);
            curr.removeLast();
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k>n) return this.list;
        LinkedList<Integer> curr=new LinkedList<>();
        combinationSum3(k, n, 1, curr);
        return this.list;
    }
}