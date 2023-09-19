import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int tmp = 1;

        while (tmp < arr.length) {
            tmp *= 2;
        }
 
        int[] answer = new int[tmp];
        Arrays.fill(answer, 0);

        System.arraycopy(arr, 0, answer, 0, arr.length);
        
        return answer;
    }
}