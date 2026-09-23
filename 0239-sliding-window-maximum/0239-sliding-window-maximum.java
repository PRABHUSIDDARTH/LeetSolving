class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<>();

        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty() && q.peekFirst()<=i-k)q.pollFirst();
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i])q.pollLast();
            q.addLast(i);
            if (i >= k - 1) res[i-k+1] = nums[q.peekFirst()];
        }
        return res;
    }
}