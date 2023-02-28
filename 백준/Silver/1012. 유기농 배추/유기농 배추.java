import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K;
	static int[][] field;
	static boolean[][] visit;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트케이스

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 배추밭 가로 길이
			N = Integer.parseInt(st.nextToken()); // 배추밭 세로 길이
			K = Integer.parseInt(st.nextToken()); // 심긴 배추 개수

			int count = 0;
			field = new int[N][M];
			visit = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[y][x] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j] == 1 && !visit[i][j]) {
						count++;
						DFS(j, i);
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void DFS(int x, int y) {
		visit[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx < M && cy < N && cx >= 0 && cy >= 0) {
				if (field[cy][cx] == 1 && !visit[cy][cx]) {
					DFS(cx, cy);
				}
			}
		}
	}
}