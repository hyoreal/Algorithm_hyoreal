import java.util.stream.Stream;

class Solution {
    public int[] solution(String myString) {
        return Stream.of(myString.split("x", -1))
            .mapToInt(s -> s.length())
            .toArray();
    }
}