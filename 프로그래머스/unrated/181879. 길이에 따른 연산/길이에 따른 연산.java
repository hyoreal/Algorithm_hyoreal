class Solution {
    public int solution(int[] num_list) {
        int ans = 1;
        if (num_list.length >= 11) {
            for(int i : num_list) ans += i;
            return ans-1;
        }
        else {
            for(int i : num_list) ans *= i;
            return ans;
        }
    }
}