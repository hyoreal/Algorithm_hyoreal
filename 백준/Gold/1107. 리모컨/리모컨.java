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

		int result = Math.abs(N - now); //초기값 설정
		for(int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();

			boolean isBreak = false;
			for(int j = 0; j < len; j++) {
				if(broken[str.charAt(j) - '0']) { //고장난 버튼을 눌러야 하면
					isBreak = true;
					break; //더 이상 탐색하지 않고 빠져나온다.
				}
			}
			if(!isBreak) { //i를 누를때 고장난 버튼을 누르지 않는다면
				int min = Math.abs(N - i) + len; //i를 누른 후(len) target까지 이동하는 횟수(target - i)
				result = Math.min(min, result);
			}
		}
		System.out.println(result);
	}
}
