class UndergroundSystem {
private:
    map<int, pair<string, int>> checkInMap;
    map<pair<string, string>, pair<int, int>> totalTimeMap;
public:
    UndergroundSystem() {
        checkInMap.clear();
        totalTimeMap.clear();
    }
    
    void checkIn(int id, string stationName, int t) {
        checkInMap[id] = make_pair(stationName, t);
    }
    
    void checkOut(int id, string stationName, int t) {
        string startStationName = checkInMap[id].first;
        int startTime = checkInMap[id].second;
        pair<string, string> fromAndTo = make_pair(startStationName, stationName);
        int totalTime = t - startTime;
        if(totalTimeMap.find(fromAndTo)!=totalTimeMap.end()){
            pair<int, int> p = totalTimeMap[fromAndTo];
            p.first += totalTime;
            ++p.second;
            totalTimeMap[fromAndTo] = p;
        }else{
            pair<int,int> p = make_pair(totalTime, 1);
            totalTimeMap[fromAndTo] = p;
        }
    }
    
    double getAverageTime(string startStation, string endStation) {
        pair<int, int> p = totalTimeMap[make_pair(startStation, endStation)];
        return ((double)p.first)/p.second;
    }
};