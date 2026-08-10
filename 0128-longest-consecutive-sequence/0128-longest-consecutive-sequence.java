class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0){
            return 0;
        }
        int maxSequence = 1;
        int currentSequence = 1;
        for(int i = 1 ; i < nums.length; i++){
            if(nums[i] == nums[i-1] + 1){
                currentSequence++;
                maxSequence = Math.max(maxSequence,currentSequence);
            } else if(nums[i] == nums[i-1])
                continue;
            else
                currentSequence = 1;
            
        }
        return maxSequence;
    }
}