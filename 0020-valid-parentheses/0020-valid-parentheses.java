class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if((c=='(')||(c=='{')||(c=='[')){
                st.push(c);
            }
            else{
                if(st.isEmpty())return false;
                else if((c==')'&&st.pop()!='(')||(c=='}'&&st.pop()!='{')||(c==']'&&st.pop()!='['))return false;
            }
        }
        return st.isEmpty();
    }
}