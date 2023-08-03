import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i : nums) hash.add(i);
        if (nums.length/2 < hash.size()) return nums.length/2;
        else return hash.size();
    }
}