import java.util.Arrays;

class Solution {
    public int solution(String[] order) {
        return Arrays.stream(order).mapToInt(str -> str.contains("latte") ? 5000 : 4500).sum();
    }
}