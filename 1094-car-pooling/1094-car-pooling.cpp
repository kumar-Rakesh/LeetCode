class Solution {
public: 
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        map<int,int> totalFrom, totalTo;
        for(int i=0;i<trips.size();++i){
            
            if(totalFrom.find(trips[i][1])!=totalFrom.end()){
                totalFrom[trips[i][1]]+=trips[i][0];
            }else{
                totalFrom[trips[i][1]]=trips[i][0];
            }
            
            if(totalTo.find(trips[i][2])!=totalTo.end()){
                totalTo[trips[i][2]]+=trips[i][0];
            }else{
                totalTo[trips[i][2]]=trips[i][0];
            }
            
        }
        map<int,int> :: iterator it1, it2;
        it1=totalFrom.begin();
        it2=totalTo.begin();
        int currSize=it1->second;
        if(currSize>capacity){
            return false;
        }
        ++it1;
        while(it1!=totalFrom.end() && it2!=totalTo.end()){
            if(it1->first<it2->first){
                currSize+=it1->second;
                ++it1;
            }else if(it1->first>it2->first){
                currSize-=it2->second;
                ++it2;
            }else{
                currSize-=it2->second;
                currSize+=it1->second;
                ++it1;
                ++it2;
            }
            if(currSize>capacity){
                return false;
            }
        }
        return true;
    }
};