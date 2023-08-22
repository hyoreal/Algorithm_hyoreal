import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) map.put(name[i], yearning[i]);
        
        for (int i = 0; i < photo.length; i++) {
            for (String n : photo[i]) {
                answer[i] += map.containsKey(n) ? map.get(n) : 0;
            }
        }
        
        return answer;
    }
}