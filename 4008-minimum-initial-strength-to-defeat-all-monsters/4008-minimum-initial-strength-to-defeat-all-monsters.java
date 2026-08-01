class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] diff = new long[n+1];
        for(int[] b:boosts){
            diff[b[0]]+=b[2];
            if(b[1]+1<n)diff[b[1]+1]-=b[2];
        }
        long[] bonus = new long[n];
        bonus[0]=diff[0];
        for(int i=1;i<n;i++){
            bonus[i]=bonus[i-1]+diff[i];
        }
        long low =0,high=0;
        for(int x:monsters)high+=x;
        while(low<high){
            long mid = low+(high-low)/2;
            if(canWin(monsters, bonus,mid)){
                high =mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    private boolean canWin(int[] monsters, long[] bonous, long initial){
        long strength=initial;
        for(int i=0;i<monsters.length;i++){
            if(strength+bonous[i]<monsters[i])return false;
            strength-=monsters[i];
            if(strength<0)strength =0;
        }
        return true;
    }
}