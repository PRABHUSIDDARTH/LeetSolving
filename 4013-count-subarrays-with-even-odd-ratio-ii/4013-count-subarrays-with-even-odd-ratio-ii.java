class Solution {
    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n =nums.length;
        int[] X = new int[n+1], Y = new int[n+1];
        for(int i=0;i<n;i++){
            X[i+1]=X[i]+(nums[i]%2==0?1:0);
            Y[i+1]=Y[i]+(nums[i]%2==0?0:1);
        }
        long[] f = new long[n+1];
        for(int i=0;i<=n;i++)f[i]=(long)b*X[i] - (long)a*Y[i];
        int[] firstOcc = new int[n+1];
        Arrays.fill(firstOcc,-1);
        for(int i=0;i<=n;i++)if(firstOcc[Y[i]]==-1)firstOcc[Y[i]]=i;
        long[] sorted = f.clone();
        Arrays.sort(sorted);
        long[] uniq = new long[n+1];
        int m=0;
        for(long v:sorted)if(m==0||uniq[m-1]!=v)uniq[m++]=v;
        int[] bit = new int[m+1];
        int added =0,totalInserted =0;
        long ans =0;
        for(int r=1;r<=n;r++){
            int mr = firstOcc[Y[r]];
            while(added<mr){
                int idx = lowerbound(uniq,m,f[added])+1;
                for(int i=idx;i<=m;i+=i & (-i))bit[i]++;
                totalInserted++;
                added++;
            }
            int rr = lowerbound(uniq,m,f[r])+1;
            int s =0;
            for(int i=rr-1;i>0;i-= i & (-i))s+=bit[i];
            ans+=totalInserted - s;
        }
        return ans;
    }
    private int lowerbound(long[] arr, int len, long key){
        int lo=0,hi=len;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid]<key)lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
}