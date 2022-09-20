class Pair{
    int val;
    int freq;
    Pair(int val, int freq){
        this.val=val;
        this.freq=freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;++i){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        int size=Math.min(k, map.size());
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p2.freq-p1.freq;
            }
        }); 
        for(Integer key:map.keySet()){
            pq.add(new Pair(key, map.get(key)));
        }
        int[] res=new int[size];
        int i=0;
        while(pq.size()>0){
            Pair p=pq.poll();
            res[i++]=p.val;
            if(i==k) break;
        }
        return res;
    }
}