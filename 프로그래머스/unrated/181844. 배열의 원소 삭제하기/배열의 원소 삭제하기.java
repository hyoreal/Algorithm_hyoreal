import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        for (int i : arr) answer.add(i);
        
        for(int i : delete_list){
            int index = answer.indexOf(i);
            
            if (index != -1) 
                answer.remove(index);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}