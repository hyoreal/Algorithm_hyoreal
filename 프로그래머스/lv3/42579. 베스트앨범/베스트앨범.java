import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genresMap = new HashMap<>();
		HashMap<Integer, Integer> playsMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
			playsMap.put(i, plays[i]);
		}

		List<String> list = new ArrayList<>(genresMap.keySet());

		Collections.sort(list, (o1, o2) -> genresMap.get(o2).compareTo(genresMap.get(o1)));

		List<Integer> list2 = new ArrayList<>(playsMap.keySet());

		Collections.sort(list2, ((o1, o2) -> playsMap.get(o2).compareTo(playsMap.get(o1))));

		List<Integer> ans = new ArrayList<>();
		for (String genre : list) {
			int cnt = 1;
			for (int i : list2) {
				if (genres[i].equals(genre) && cnt <= 2) {
					cnt++;
					ans.add(i);
				}
			}
		}

		return ans;
    }
}