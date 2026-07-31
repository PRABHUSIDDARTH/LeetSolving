class Solution {
    public String simplifyPath(String path) {
        String[] st = path.split("/");
        Stack<String>sta = new Stack<>();
        for (String s : st) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!sta.isEmpty()) {
                    sta.pop();
                }
            } else {
                sta.push(s);
            }
        }
        StringBuilder sb = new StringBuilder("/");
            for (String s : sta) {
                sb.append(s);
                sb.append("/");
            }

            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }

            return sb.toString();
    }
}