import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());   // 정점 개수
		int M = Integer.parseInt(st.nextToken());   // 간선 개수
		int V = Integer.parseInt(st.nextToken());   // 탐색시작할 정점 번호

		arr = new int[N+1][N+1]; // 정점 번호는 1 ~ N

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		visited = new boolean[N + 1]; // dfs 방문 여부
		dfs(V);

		sb.append("\n");

		visited = new boolean[N + 1]; // bfs 방문 여부
		bfs(V);
        
		System.out.print(sb);
	}

	// dfs 재귀
	static void dfs(int V) {
		visited[V] = true;
		sb.append(V).append(" ");

		if(V > arr.length - 1) return;

		for(int i = 1; i < arr.length; i++) {
			if(arr[V][i] == 1 && !visited[i]) dfs(i);
		}
	}

	// bfs deque
	static void bfs(int V) {
		Deque<Integer> deq = new LinkedList<>();

		deq.add(V); // 시작 정점
		visited[V] = true;
		sb.append(V).append(" ");

		while(!deq.isEmpty()) { // queue가 비어있지 않는 동안
			int temp = deq.poll();
			for(int i = 1; i < arr.length; i++) {
				if(arr[temp][i] == 1 && !visited[i]) {
					deq.add(i);
					visited[i] = true;
					sb.append(i).append(" ");
				}
			}
		}
	}
}