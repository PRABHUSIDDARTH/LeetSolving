class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n =tasks.length,m=shifts.length;
        long[] prefix = new long[n+1];
        for(int i=0;i<n;i++)prefix[i+1]=prefix[i]+tasks[i];
        long total = prefix[n];
        long completed =0;
        int[] ans = new int[m];
        for(int j=0;j<m;j++){
            completed += shifts[j];
            if(completed>=total){
                ans[j]=0;
                completed =0;
            }
            else{
                int t=upperbound(prefix, completed);
                ans[j]=n-t;
            }
        }
        return ans;
    }
    private int upperbound(long[] prefix, long completed){
        int lo =0,hi = prefix.length-1;
        while(lo<hi){
            int mid = lo+(hi-lo+1)/2;
            if(prefix[mid]<=completed)lo = mid;
            else hi = mid-1;
            
        }
        return lo;
    }
}