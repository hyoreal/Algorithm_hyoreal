import java.io.*;
import java.util.*;

public class Main {

	static final int INF = (int)1e9; // 무한대

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 유저의 수 2 ~ 100
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수 1 ~ 5000

		int[][] dist = new int[N + 1][N + 1]; // 플로이드 초기 거리 테이블 초기화

		for (int i = 0; i < N + 1; i++) Arrays.fill(dist[i], INF);
		for (int i = 1; i <= N; i++) dist[i][i] = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 가는 경로가 하나가 아닐 수 있다. 따라서 그 중 최소 비용을 저장해두면 된다.
			dist[a][b] = 1;
			dist[b][a] = 1;
		}

		// 플로이드 워셜 알고리즘
		// 노드를 1개부터 N개까지 거쳐가는 경우
		for (int k = 1; k <= N; k++) {
			// 노드 i에서 j로 가는 경우.
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
					// 또는 연결이 안되어있던 경우(INF) 연결 비용 갱신.
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		Result[] results = new Result[N + 1];
		results[0] = new Result(0,  INF);

		// 출력
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) sum += dist[i][j];
			results[i] = new Result(i, sum);
		}

		Arrays.sort(results);

		System.out.println(results[0].idx);
	}

	static class Result implements Comparable<Result> {

		int idx;
		int sum;

		public Result(int idx, int sum) {
			this.idx = idx;
			this.sum = sum;
		}

		@Override
		public int compareTo(Result o) {
			if (this.sum == o.sum) return Integer.compare(this.idx, o.idx);
			return Integer.compare(this.sum, o.sum);
		}
	}
}
