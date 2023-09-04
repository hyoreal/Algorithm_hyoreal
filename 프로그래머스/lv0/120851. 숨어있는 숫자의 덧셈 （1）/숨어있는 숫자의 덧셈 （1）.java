class Solution {
    public int solution(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[^0-9]","");
        
        for(int i = 0; i < my_string.length(); i++) {
            answer += Integer.parseInt(String.valueOf(my_string.charAt(i)));
        }    
        
        return answer;
    }
}