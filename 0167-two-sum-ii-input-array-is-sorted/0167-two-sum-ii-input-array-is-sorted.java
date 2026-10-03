class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*the key for this is the clue that they have give the input array is sorted so we need to to optimise with an search technique.

        we can use the previous two sum solution of an hash map but still it makes the space as O(n) coz hashmap at the worst can have the complete array.
        so to optimise it we use an search technique: sorted Array -> binary search*/

        int left=0;
        int right=nums.length-1;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum>target)right--;
            else if(sum<target)left++;
            else return new int[]{left+1,right+1};
        }
        return new int[]{-1,-1};
    }
}