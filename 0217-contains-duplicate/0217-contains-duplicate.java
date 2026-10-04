class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(hm.contains(nums[i]))return true;
            else hm.add(nums[i]);
        }
        return false;
    }
}