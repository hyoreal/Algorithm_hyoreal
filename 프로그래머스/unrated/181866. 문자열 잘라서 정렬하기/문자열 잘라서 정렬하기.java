import java.util.*;

class Solution {
    public String[] solution(String myString) {
        return Arrays.stream(myString.split("x"))
            .filter(str -> !str.isEmpty())
            .sorted()
            .toArray(String[]::new);
    }
}