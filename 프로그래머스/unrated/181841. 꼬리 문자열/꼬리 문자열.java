class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        
        for (String s : str_list) {
            answer += s.contains(ex) ? "" : s;
        }
        
        return answer;
    }
}