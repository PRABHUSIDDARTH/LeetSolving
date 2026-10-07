class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int  max=0;
        while(left<right){
            int minH=Math.min(height[left],height[right]);
            int wid = right-left;
            int area = wid*minH;
            max = Math.max(max,area);
            if(height[right]>height[left])left++;
            else right--;
        }
        return max;
    }
}
// Pattern: two pointers (inward), greedy on the shorter side
// Insight: area = width * min(h). Moving the taller wall can never help
//          (width drops, min stays capped), so always move the shorter one.
// Stuck: forgot the pointer-move rule, peeked at old submission.