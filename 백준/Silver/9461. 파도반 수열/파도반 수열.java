import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[t];
		int max = 0;

		for (int i = 0; i < t; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		long[] dp = new long[max+1];
		dp[1] = dp[2] = dp[3] = 1L;

		for (int i = 4; i <= max; i++)
			dp[i] = dp[i - 2] + dp[i - 3];

		for (int num : arr)
			System.out.println(dp[num]);
	}
}