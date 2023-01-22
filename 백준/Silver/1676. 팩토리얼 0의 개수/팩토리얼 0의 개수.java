import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
                 
        int cnt_of_2 = 0;
        int cnt_of_5 = 0;
         
        // factorial 진행과정 중에서 2와 5의 곱의 개수를 파악한다.
        for(int i=1; i<=N; i++) {
            int target = i;
             
            // 소인수 분해하며 2의 개수를 파악한다.
            while((target % 2 == 0)) {
                cnt_of_2++;
                target = target / 2;
            }
             
            // 소인수 분해하여 5의 개수를 파악한다.
            while((target % 5 == 0)) {
                cnt_of_5++;
                target = target / 5;
            }
        }
         
        System.out.println(Math.min(cnt_of_2, cnt_of_5));
    }
}