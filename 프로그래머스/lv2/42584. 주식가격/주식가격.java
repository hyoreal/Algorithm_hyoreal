import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            while (!q.isEmpty() && prices[i] < prices[q.peek()]) {
                answer[q.peek()] = i - q.peek();
                q.pop();  // 답을 구했기 때문에 stack에서 제거
            }
            q.push(i);
        }

        while (!q.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            answer[q.peek()] = prices.length - q.peek() - 1;
            q.pop();
        }

        return answer;
    }
}