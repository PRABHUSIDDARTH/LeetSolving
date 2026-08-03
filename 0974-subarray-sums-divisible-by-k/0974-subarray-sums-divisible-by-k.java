class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        int prefix =0;
        int count=0;
        hm.put(0,1);
        for(int num:nums){
            prefix+=num;
            int rem = ((prefix%k)+k)%k;
            count+=hm.getOrDefault(rem,0);
            hm.put(rem,hm.getOrDefault(rem,0)+1);
        }
        return count;
    }
}