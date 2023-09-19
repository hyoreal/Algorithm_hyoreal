import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        int[] a = IntStream.range(0, arr.length).filter(i -> arr[i] == 2).toArray();
		return a.length == 0 ? new int[]{-1} : IntStream.rangeClosed(a[0], a[a.length - 1]).map(i -> arr[i]).toArray();
    }
}