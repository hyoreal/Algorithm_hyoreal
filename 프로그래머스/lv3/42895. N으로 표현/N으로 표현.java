import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        // 최솟값이 8보다 크면 -1이기때문에 통을 8개만 생성
        List<HashSet<Integer>> list = new ArrayList<>();
        
        // 8개의 통 초기화
        for (int i = 0; i <= 8; i++) {
            list.add(new HashSet<Integer>());
        }
        
        list.get(1).add(N); // 숫자 1개 사용값은 고정되어있음
        
        // 0번 통 = 0, 1번 통 = 1이므로 2부터 시작
        // n번 통 = x번 통 (+-*/) n-x번통, n-x번통 (+-*/) x번통, repeat(n)
        for (int i = 2; i <= 8; i++) {
            HashSet<Integer> set = list.get(i); 
            
            for (int j = 1; j <= i; j++) {
                HashSet<Integer> a = list.get(j);
                HashSet<Integer> b = list.get(i-j);
                
                for (int x : a) {
                    for (int y : b) {
                        set.add(x + y);
                        set.add(x - y);
                        set.add(x * y);
                        if(x != 0 && y != 0) set.add(x / y);
                    }
                }
                set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
            
            if (set.contains(number)) return i;
        }
        return -1;
    }
}