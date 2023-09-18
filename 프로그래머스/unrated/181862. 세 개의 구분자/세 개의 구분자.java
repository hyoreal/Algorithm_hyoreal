import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] arr = Arrays.stream(myStr.split("[abc]+")).filter(s -> !s.isEmpty()).toArray(String[]::new);
		return arr.length == 0 ? new String[]{"EMPTY"} : arr;
    }
}