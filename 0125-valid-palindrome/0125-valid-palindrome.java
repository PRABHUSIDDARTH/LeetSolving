class Solution {
    private char getChar(String s, int idx){
        char c = s.charAt(idx);
        if(c>='a'&&c<='z'){
            return (char)(c-'a'+'A');
        }
        return c;
    }
    public boolean isAlphaNumeric(char c){
        return(c>='A'&& c<='Z')||(c>='a'&&c<='z')||(c>='0'&&c<='9');
    }
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char ch=getChar(s,i);
            char c=getChar(s,j);
            if(!isAlphaNumeric(ch)){
                i++;
                continue;
            }
            if(!isAlphaNumeric(c)){
                j--;
                continue;
            }
            if(ch!=c)return false;
            i++;
            j--;
        }
        return true;
        
        
    }
}
// Pattern: two pointers (inward), skip invalid chars in place
// Insight: don't build a cleaned copy. Move i/j past non-alphanumerics,
//          compare case-insensitively. O(n) time, O(1) space.
// Stuck: first reached for replace/StringBuilder (extra space, slow).
//        Two pointers only clicked on the 3rd attempt.

