import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<Integer, String> pocketmon1 = new LinkedHashMap<>();
		Map<String, Integer> pocketmon2 = new LinkedHashMap<>();
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			pocketmon1.put(i, input);
			pocketmon2.put(input, i);
		}

		while (M-- > 0) {
			String prob = br.readLine();
			
			if (Character.isDigit(prob.charAt(0))) 
				sb.append(pocketmon1.get(Integer.parseInt(prob))).append("\n");
			else sb.append(pocketmon2.get(prob)).append("\n");
		}

		System.out.println(sb);
	}
}