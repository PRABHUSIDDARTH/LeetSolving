class Solution {
    public int[] twoSum(int[] nums, int target) {
        //<number,pos> -> key to solve this problem: maintaining an map for the remaining to seen
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int sum=target-nums[i];
            if(hm.containsKey(sum)){
                return new int[]{hm.get(sum),i};
            }
            hm.put(nums[i],i);
        }
        return new int[]{};
    }
}