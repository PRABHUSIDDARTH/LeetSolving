class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length())return false;
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)- 'a']++;
            count[t.charAt(i)- 'a']--;
        }
        for(int c:count){
            if(c!=0)return false;
        }
        return true;
    }
}
// Pattern: frequency count (sorting also works)
// Insight: same length + same letter counts = anagram.
//          Sort is O(n log n); count array (ch - 'a') is O(n), O(1) space.
// Stuck: nothing, but didn't think of the count array first.