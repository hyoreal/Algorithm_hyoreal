class Solution {
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        
        return cnt;
    }
    
    public void dfs(int[] numbers, int depth, int target, int sum) {
        // numbers : 알고리즘을 실행할 대상 배열
	    // depth : 노드의 깊이
	    // target : 타겟 넘버
	    // sum : 이전 노드 까지의 결과 값
        
        if (depth == numbers.length) {
            if (target == sum) cnt++;
            
            return;
        }
        
        int plus = sum + numbers[depth]; 
        int minus = sum - numbers[depth];
        
        dfs(numbers, depth + 1, target, plus);
        dfs(numbers, depth + 1, target, minus);  
    }
}