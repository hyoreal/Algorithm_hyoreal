class Solution {
    public String solution(String my_string) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            answer += Character.isUpperCase(my_string.charAt(i)) ? String.valueOf(my_string.charAt(i)).toLowerCase() : String.valueOf(my_string.charAt(i)).toUpperCase(); 
        }
        return answer;
    }
}