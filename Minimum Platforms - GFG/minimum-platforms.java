//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


class TrainTime {
    int time;
    char type;
    TrainTime(int time, char type) {
        this.time = time;
        this.type = type;
    }
}

//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int at[], int dt[], int n)
    {
        TrainTime[] times = new TrainTime[2*n];
        for(int i = 0; i < n; ++i) {
            times[i] = new TrainTime(at[i], 'A');
        }
        for(int i = n; i < 2*n; ++i) {
            times[i] = new TrainTime(dt[i-n], 'D');
        }
        Arrays.sort(times, (t1, t2) -> t1.time - t2.time);
        int currCount = 0, minPlatforms = 0;
        for(int i = 0; i < 2*n; ++i) {
            if(times[i].type == 'A') {
                ++currCount;
                minPlatforms = Math.max(currCount, minPlatforms);
            } else {
                --currCount;
            }
        }
        return minPlatforms; 
        
    }
    
}

