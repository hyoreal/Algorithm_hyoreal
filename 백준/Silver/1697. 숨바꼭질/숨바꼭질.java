import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 수빈 위치
		int k = Integer.parseInt(st.nextToken()); // 동생 위치

		if (n == k) {
            System.out.println(0);
            return;
        }

		boolean[] visited = new boolean[100001];
		visited[n] = true;

		Deque<Integer> deque = new LinkedList<>();
		deque.add(n);

		int cnt = 0;

		while (true) {
			cnt++;
			int size = deque.size();

			for (int i = 0; i < size; i++) {
				int x = deque.remove();
				visited[x] = true;
				if (x-1 == k || x+1 == k || x*2 == k) {
					System.out.println(cnt);
					return;
				}
				if (x-1 >= 0 && !visited[x-1]) {
					visited[x-1] = true;
					deque.add(x-1);
				}
				if (x+1 <= 100000 && !visited[x+1]) {
					visited[x+1] = true;
					deque.add(x+1);
				}
				if (x*2 <= 100000 && !visited[x*2]) {
					visited[x*2] = true;
					deque.add(x*2);
				}
			}
		}
	}
}
