import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> temp = new ArrayList<>();
		Deque<Integer> q = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			if ((100 - progresses[i]) % speeds[i] == 0) q.add((100 - progresses[i]) % speeds[i]);
			else q.add((100 - progresses[i]) % speeds[i] + 1);
		}

		int tmp = q.poll();
		int cnt = 1;
		while (!q.isEmpty()) {
			if (tmp >= q.peek()) {
				cnt++;
				q.poll();
			}
			else {
				temp.add(cnt);
				cnt = 1;
				tmp = q.poll();
			}
		}
		temp.add(cnt);

		int[] ans = new int[temp.size()];
		for (int i = 0; i < ans.length; i++) ans[i] = temp.get(i);

		return ans;
    }
}