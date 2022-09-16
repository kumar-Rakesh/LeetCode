class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2){
                if(i1[0]==i2[0]) return i2[1]-i1[1];
                return i1[0]-i2[0];
            }
        });
        int i=1, currStart=intervals[0][0], currEnd=intervals[0][1], count=0;
        while(i<n){
            if(intervals[i][0]<currEnd && intervals[i][1]<=currEnd){
                ++count;
                currStart=intervals[i][0];
                currEnd=intervals[i][1];
            }else if(intervals[i][0]<currEnd && intervals[i][1]>currEnd){
                ++count;
            }else{
                currStart=intervals[i][0];
                currEnd=intervals[i][1];
            }
            ++i;
        }
        return count;
    }
}