import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int[] indices) {
        String[] arr = my_string.split("");

        for (int i = 0; i < indices.length; i++) arr[indices[i]] = "";

        return Arrays.stream(arr).collect(Collectors.joining());
    }
}