class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {0, 0};
        
        for (int i : num_list) answer[i % 2]++;
        
        return answer;
    }
}