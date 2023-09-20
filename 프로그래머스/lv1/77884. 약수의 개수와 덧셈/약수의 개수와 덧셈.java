import java.util.stream.IntStream;

class Solution {
    public int solution(int left, int right) {
        return IntStream.rangeClosed(left, right).map(i -> i % Math.sqrt(i) == 0 ? -i : i).sum();
    }
}