class Solution {
    public long maxPairStrength(int[] nums) {
        long max = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                long g = gcd(nums[i],nums[j]);
                long prod = 1L*nums[i]*nums[j];
                long tmp = prod/(g*g);
                max = Math.max(max,tmp);
            }
        }
        return max;
    }
    private int gcd(int a, int b){
        if(b==0)return a;
        else return gcd(b,a%b);
    }
}