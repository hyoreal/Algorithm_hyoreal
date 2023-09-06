import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            while (!q.isEmpty() && prices[i] < prices[q.peek()]) {
                answer[q.peek()] = i - q.peek();
                q.pop();
            }
            q.push(i);
        }

        while (!q.isEmpty()) {
            answer[q.peek()] = prices.length - q.peek() - 1;
            q.pop();
        }

        return answer;
    }
}