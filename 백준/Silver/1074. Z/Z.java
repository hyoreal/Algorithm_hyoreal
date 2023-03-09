import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, r, c, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		double size = Math.pow(2, n);
		count = 0;
		solve(size, r, c);

		System.out.println(count);
	}

	public static void solve(double size, int r, int c) {
		if (size == 1)
			return;

		if (r < size / 2 && c < size / 2) {
			solve(size / 2, r, c);
		}
		else if (r < size / 2 && c >= size / 2) {
			count += Math.pow(size, 2) / 4;
			solve(size / 2, r, c - (int)size / 2);
		}
		else if (r >= size / 2 && c < size / 2) {
			count += Math.pow(size, 2) / 4 * 2;
			solve(size / 2, r - (int)size / 2, c);
		}
		else if (r >= size / 2 && c >= size / 2) {
			count += Math.pow(size, 2) / 4 * 3;
			solve(size / 2, r - (int)size / 2, c - (int)size / 2);
		}
	}
}