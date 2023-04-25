import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] board = new int[101];
	static int[] orderOfVisit = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 사다리 수
		M = Integer.parseInt(st.nextToken()); // 뱀 수

		// 보드판 초기화
		for (int i = 0; i < board.length; i++) board[i] = i;

		// 보드판 사다리, 뱀 위치 할당
		int all = N + M;
		while (all-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}

		System.out.println(BFS());
	}

	private static int BFS() {
		Deque<Integer> q = new LinkedList<>();
		q.add(1);
		orderOfVisit[1] = 0;

		while (true) {
			int visited = q.poll();

			// 주사위로 나오는 경우의 수
			for (int i = 1; i <= 6; i++) {
				int newDice = visited + i;
				if (newDice > 100) continue;
				if (orderOfVisit[board[newDice]] == 0) {
					q.add(board[newDice]);
					orderOfVisit[board[newDice]] = orderOfVisit[visited] + 1;
				}
				if (board[newDice] == 100) return orderOfVisit[100];
			}
		}
	}
}