import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        Integer[][] memo = new Integer[41][2];
        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            fibo(n , memo);
            sb.append(memo[n][0]).append(" ").append(memo[n][1]).append("\n");
        }
        System.out.print(sb);
    }

    private static Integer[] fibo(int n, Integer[][] memo) {
        if (memo[n][0] == null || memo[n][1] == null) {
            memo[n][0] = fibo(n-1, memo)[0] + fibo(n-2, memo)[0];
            memo[n][1] = fibo(n-1, memo)[1] + fibo(n-2, memo)[1];
        }
        return memo[n];
    }
}