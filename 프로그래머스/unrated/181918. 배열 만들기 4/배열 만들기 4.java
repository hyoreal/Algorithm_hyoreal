import java.util.Stack;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length;) {
            if (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty() || !stack.isEmpty() && stack.peek() < arr[i]) {
                stack.add(arr[i]);
                i++;
            }
        }
        
        return stack.stream().mapToInt(i -> i).toArray();
    }
}