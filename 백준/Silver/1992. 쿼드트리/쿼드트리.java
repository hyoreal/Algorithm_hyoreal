import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[][] quad;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		quad = new int[n][n];

		for (int i = 0; i < n; i++) {
			String st = br.readLine();
			for (int j = 0; j < n; j++) quad[i][j] = st.charAt(j) - '0';
		}

		QuadTree(0, 0, n);
		System.out.println(sb);
	}

	// 쿼드 트리 재귀
	public static void QuadTree(int x, int y, int size) {
		if (Compression(x, y, size)) { // 탈출 조건
			sb.append(quad[x][y]);
			return;
		}

		int half = size / 2;
		sb.append("(");

		QuadTree(x, y, half);
		QuadTree(x, y + half, half);
		QuadTree(x + half, y, half);
		QuadTree(x + half, y + half, half);

		sb.append(')');
	}

	// 공간을 줄일 수 있는지
	public static boolean Compression(int x, int y, int size) {
		int val = quad[x][y];

		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++)
				if(val != quad[i][j]) return false;
		}
		return true;
	}
}