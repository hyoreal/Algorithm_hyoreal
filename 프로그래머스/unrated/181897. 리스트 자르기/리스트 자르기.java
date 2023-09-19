import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> list = new ArrayList<>();
        
        if (n == 1) {
            for(int i = 0; i <= slicer[1]; i++) {
                list.add(num_list[i]);
            }
        }
        if (n == 2) {
            for (int i = slicer[0]; i < num_list.length; i++) {
                list.add(num_list[i]);
            }
        }
        if (n ==3) {
            for (int i = slicer[0]; i <= slicer[1]; i++) {
                list.add(num_list[i]);
            }
        }
        if (n == 4) {
            for (int i = slicer[0]; i <= slicer[1]; i+=slicer[2]) {
                list.add(num_list[i]);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}