class Solution {
    public int solution(String s) {
        return s.contains("^[-+]") ? Integer.parseInt(s.substring(1, s.length())) * -1 : Integer.parseInt(s);
    }
}