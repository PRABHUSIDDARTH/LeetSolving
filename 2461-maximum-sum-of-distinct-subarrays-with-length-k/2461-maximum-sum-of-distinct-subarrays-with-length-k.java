class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < k) return 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        long currentSum = 0;
        long maxSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        if (freq.size() == k) {
            maxSum = currentSum;
        }
        for (int right = k; right < n; right++) {
            int outgoing = nums[right - k];
            int incoming = nums[right];
            currentSum -= outgoing;
            freq.put(outgoing, freq.get(outgoing) - 1);
            if (freq.get(outgoing) == 0) {
                freq.remove(outgoing);
            }
            currentSum += incoming;
            freq.put(incoming, freq.getOrDefault(incoming, 0) + 1);
            if (freq.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}