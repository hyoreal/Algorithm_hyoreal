import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int i, int j, int k) {
        return IntStream.rangeClosed(i, j).mapToObj(String::valueOf).map(m -> m.split("")).flatMap(Arrays::stream).filter(ch -> ch.equals(String.valueOf(k))).toArray().length;
    }
}