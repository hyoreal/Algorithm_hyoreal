class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        return s.chars().filter(ch -> ch == 'p').count() == s.chars().filter(ch -> ch == 'y').count();
    }
}