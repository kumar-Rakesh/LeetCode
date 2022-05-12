class Solution {
    
    private Set<List<Integer>> set=new HashSet<>();
    
    private void swap(List<Integer> list, int i, int j){
        int x=list.get(i);
        list.set(i, list.get(j));
        list.set(j, x);
    }
    
    private void permuteUnique(List<Integer> list, int l, int r){
        if(l==r){
            this.set.add(new ArrayList(list));
            return;
        }
        for(int i=l;i<=r;++i){
            swap(list, l, i);
            permuteUnique(list, l+1, r);
            swap(list, l, i);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        permuteUnique(list, 0, list.size()-1);
        return new ArrayList(this.set);
    }
}