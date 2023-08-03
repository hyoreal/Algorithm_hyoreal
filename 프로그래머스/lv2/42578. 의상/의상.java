import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] arr : clothes) {
            map.put(arr[1], map.getOrDefault(arr[1], 1) + 1);
        }
        int ans = 1;
        for (String key : map.keySet()) ans *= map.get(key);
        return ans-1;
    }
}