import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minPq = new PriorityQueue<>(); // 낮은 숫자 우선 순위
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder()); // 높은 숫자 우선 순위

        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String ch = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (minPq.size() < 1 && ch.equals("D")) continue;

            if (ch.equals("I")) {
                minPq.offer(value);
                maxPq.offer(value);
                continue;
            }

            if(value < 0) {
                int min = minPq.poll();
                maxPq.remove(min);
                continue;
            }

            int max = maxPq.poll();
            minPq.remove(max);
        }
        if(minPq.size() > 0 ) {
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }
        return answer;
    }
}