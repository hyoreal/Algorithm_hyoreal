import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> map = new HashMap<>();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int x = 0; x < m; x++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			IntStream.rangeClosed(i, j).forEach(y -> map.put(y, k));
		}

		for (int i = 1; i <= n; i++)
			sb.append(map.get(i) == null ? 0 : map.get(i)).append(" ");

		System.out.println(sb.toString().trim());
	}
}
