import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] seoul) {
        return IntStream.range(0, seoul.length).filter(i -> seoul[i].equals("Kim")).mapToObj(String::valueOf).collect(Collectors.joining("", "김서방은 ", "에 있다"));
    }
}