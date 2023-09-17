class Solution {
    public int solution(int[] array, int n) {
        int answer = Integer.MAX_VALUE;
        for (int i : array) {
            int a = Math.abs(i-n);
            int b = Math.abs(answer-n);
            answer = a == b ? Math.min(answer, i) : a > b ? answer : i;
        }
        
        return answer;
    }
}