class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;      
        int k = 1;
        while (num > 0) {
            k *= num % 10;
            num /= 10;
        }
        if (k % t == 0) {
            return n;     
        } else {
            return smallestNumber(n + 1, t);
        }
    }
}