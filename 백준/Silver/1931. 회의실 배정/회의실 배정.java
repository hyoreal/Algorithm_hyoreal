import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 회의의 수

		int[][] time = new int[N][2]; // 시작시간과 종료시간을 담기위한 이차원 배열

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());	// 시작시간 
			time[i][1] = Integer.parseInt(st.nextToken());	// 종료시간 
		}
		
		Arrays.sort(time, (o1, o2) -> {
			if(o1[1] == o2[1]) return o1[0] - o2[0]; // 종료시간이 같을 경우 시작시간이 빠른 순 정렬
			
			return o1[1] - o2[1];
		});

		int count = 0;
		int endTime = 0;

		for(int i = 0; i < N; i++) {
			if(endTime <= time[i][0]) {
				endTime = time[i][1];
				count++;
			}
		}

		System.out.println(count);
	}
}
