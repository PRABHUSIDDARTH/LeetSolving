// class Solution {
//     public String mergeAlternately(String word1, String word2) {
//         StringBuilder sb = new StringBuilder();
//         int i=0,j=0;
//         while(i<word1.length() &&j<word2.length()){
//             sb.append(word1.charAt(i++));
//             sb.append(word2.charAt(j++));
//         }
//         while(i<word1.length()) sb.append(word1.charAt(i++));
//         while(j<word2.length()) sb.append(word2.charAt(j++));
//         return sb.toString();
//     }
// }
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder s = new StringBuilder();
        int maxlen = Math.max(word1.length(),word2.length());
        for(int i=0;i<maxlen;i++){
            if(i<word1.length()){
                s.append(word1.charAt(i));
            }
            if(i<word2.length()){
                s.append(word2.charAt(i));
            }
        }
        return s.toString();
    }
}