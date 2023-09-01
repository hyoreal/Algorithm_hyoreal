import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        ArrayList<String> list = new ArrayList<>();
        int[] answer = new int[2];
        
        for (int i = 0; i < words.length; i++) {
            if (list.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
            list.add(words[i]);
            
            if (i > 0 && words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) ) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
        }
        return answer;
    }
}