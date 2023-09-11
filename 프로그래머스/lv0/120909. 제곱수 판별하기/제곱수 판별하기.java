class Solution {
    public int solution(int n) {
        return n % Math.sqrt(n) != 0 ? 2 : 1;
    }
}