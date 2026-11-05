class Solution {
    public int climbStairs(int n) {
        if(n==1)return 1;
        if(n==0)return 1;
        int prev =3;
        int prev2=2;
        if(n==2)return prev2;
        if(n==3)return prev;
        for(int i=4;i<=n;i++){
            int cur=prev+prev2;
            prev2=prev;
            prev=cur;
        }
        return prev;

    }
}