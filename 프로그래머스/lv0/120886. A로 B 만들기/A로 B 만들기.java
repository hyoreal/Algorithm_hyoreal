import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] be = before.toCharArray();
        char[] af = after.toCharArray();
        Arrays.sort(be);
        Arrays.sort(af);
        return String.valueOf(be).equals(String.valueOf(af)) ? 1 : 0;
    }
}