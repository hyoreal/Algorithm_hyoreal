import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        System.arraycopy(num_list, 0, answer, 0, num_list.length);
        answer[answer.length-1] = answer[answer.length-2] > answer[answer.length-3] ? answer[answer.length-2] - answer[answer.length-3] : answer[answer.length-2]*2;
        return answer;
    }
}