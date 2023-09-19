import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(int n) {
        return IntStream.rangeClosed(1, n).mapToObj(i -> i % 2 == 1 ? "수" : "박").collect(Collectors.joining());
    }
}