class Solution {
    public int solution(String my_string) {
        int answer = 0;
		String[] arr = my_string.split("[a-zA-Z]");
        
		for (int i = 0; i < arr.length; i++) 
            answer += !arr[i].isEmpty() ? Integer.parseInt(arr[i]) : 0;
        
		return answer;
    }
}