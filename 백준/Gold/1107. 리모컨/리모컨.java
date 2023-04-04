import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int now = 100;
	static boolean[] broken = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		if (M != 0) {
			String[] temp = br.readLine().split(" ");

			for (String str : temp) broken[Integer.parseInt(str)] = true;
		}

		if (N == 100) System.out.println(0);
		else if (M == 10) System.out.println(Math.abs(N - now));
		else {
			int ans = Math.abs(now - N);

			for (int i = 0; i < 1000000; i++) {
				// i까지 이동 후, +,-로 이동 브루트포스
				String[] number = Integer.toString(i).split("");

				boolean flag = true;
				//숫자로 이동 가능한지
				for (String index : number) {
					if (broken[Integer.parseInt(index)]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					ans = Math.min(ans, number.length + Math.abs(i - N));
				}
			}
			System.out.println(ans);
		}
	}
}