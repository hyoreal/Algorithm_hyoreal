import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> tempList = new ArrayList<>();
		Deque<Integer> q = new LinkedList<>();
		for (int i : arr) q.add(i);

		tempList.add(arr[0]);
		for (int i = 0; i < arr.length; i++) {
			int temp = q.remove();
			if (tempList.get(tempList.size()-1) == temp) continue;
			else tempList.add(temp);
		}

		int[] ans = new int[tempList.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = tempList.get(i);
		}

		return ans;
    }
}