class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        for (int i : array) {
            answer += i == n ? 1 : 0;
        }
        return answer;
    }
}