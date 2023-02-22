import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int s = 0;
		int m = Integer.parseInt(br.readLine());

		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("all")) s = (1 << 21) - 1;
			else if(str.equals("empty")) s = 0;
			else {
				int num = Integer.parseInt(st.nextToken());
				switch (str) {
					case "add":
						s |= (1 << num); // 00000001 << 1 = 00000010
						break;
					case "remove":
						s &= ~(1 << num);
						break;
					case "check":
						sb.append((s & (1 << num)) != 0 ? 1 : 0).append("\n");
						break;
					case "toggle":
						s ^= (1 << num);
						break;
				}
			}
		}
		System.out.println(sb);
	}
}
