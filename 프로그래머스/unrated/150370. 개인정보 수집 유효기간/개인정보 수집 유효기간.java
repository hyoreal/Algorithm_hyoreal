import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (String str : terms)
			map.put(str.split(" ")[0], Integer.parseInt(str.split(" ")[1]));

		int todayNum = getNum(today);

		for(int i = 0; i < privacies.length; i++) {
			String[] arr = privacies[i].split(" ");
			int tmpNum = getNum(arr[0]);
			int termsNum = map.get(arr[1]) * 28;

			if (todayNum >= tmpNum+termsNum) list.add(i+1);
		}

		return list.stream().mapToInt(i -> i).toArray();
	}

	static int getNum(String date) {
		int year = Integer.parseInt(date.split("\\.")[0]) * 12 * 28;
		int month = Integer.parseInt(date.split("\\.")[1]) * 28;
		int day = Integer.parseInt(date.split("\\.")[2]);

		return year+month+day;
	}
}