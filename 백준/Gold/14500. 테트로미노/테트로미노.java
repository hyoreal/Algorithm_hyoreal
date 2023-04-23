import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] paper;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 0, 0);
				specific(i, j);
			}
		}

		System.out.println(max);
	}

	// ㅜ 모양 제외
	private static void dfs(int i, int j, int sum, int cnt) {
		if (cnt == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int k = 0; k < 4; k++) {
			int row = i + dx[k];
			int col = j + dy[k];

			if (row < 0 || row >= N || col < 0 || col >= M) continue;
			if (visited[row][col]) continue;

			visited[row][col] = true;
			dfs(row, col, sum + paper[row][col], cnt + 1);
			visited[row][col] = false;
		}
	}

	// ㅜ 모양, + 모양에서 위의 한 칸을 제외시켜줫다
	private static void specific(int i, int j) {
		int room = 4; // + 에서 가운데를 제외한 상하좌우
		int min = Integer.MAX_VALUE;
		int sum = paper[i][j];

		for (int k = 0; k < 4; k++) {
			int row = i + dx[k];
			int col = j + dy[k];

			if (room <= 2) return;
			if (row < 0 || row >= N || col < 0 || col >= M) {
				room--;
				continue;
			}

			min = Math.min(min, paper[row][col]);
			sum += paper[row][col];
		}

		if (room == 4) sum -= min;
		max = Math.max(max, sum);
	}
}