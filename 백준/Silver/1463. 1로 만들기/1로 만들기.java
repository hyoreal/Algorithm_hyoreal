import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Integer[] memoization;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		memoization = new Integer[N + 1];
		memoization[0] = memoization[1] = 0;

		System.out.print(dp(N));
	}

	static int dp(int N) {
		if (memoization[N] == null) {
			// 6으로 나눠지는 경우
			if (N % 6 == 0) memoization[N] = Math.min(dp(N - 1), Math.min(dp(N / 3), dp(N / 2))) + 1;

			// 3으로만 나눠지는 경우
			else if (N % 3 == 0) memoization[N] = Math.min(dp(N / 3), dp(N - 1)) + 1;

			// 2로만 나눠지는 경우
			else if (N % 2 == 0) memoization[N] = Math.min(dp(N / 2), dp(N - 1)) + 1;

			// 2와 3으로 나누어지지 않는 경우
			else memoization[N] = dp(N - 1) + 1;

		}
		return memoization[N];
	}
}
