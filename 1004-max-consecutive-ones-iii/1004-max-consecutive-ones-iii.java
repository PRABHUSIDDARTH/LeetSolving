class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length, one=0;
        int i=0,j=0;
        int count=0;
        while(j<n){
            if(nums[j]==0) count++;
             while(count>k){
                if(nums[i]==0)count--;
                 i++;            
                
             }
             
            one = Math.max(one,(j-i+1));                
            j++;
           
        }
        return one;
        
    }
}