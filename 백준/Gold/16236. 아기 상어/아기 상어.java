import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최종 결과값을 저장할 변수
        int result = 0;
        // 공간의 크기
        int N = Integer.parseInt(br.readLine());
        // 공간을 표현하기위해 2차원 배열로 생성
        int[][] map = new int[N][N];

        // 아기상어 변수 생성
        Fish shark = null;
        // 초기에 공간에 먹이가 있는지 판단하기 위해 사용하는 리스트
        List<Fish> feeds = new ArrayList<>();

        // NxN공간 초기화
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                // 초기화 과정에서 아기상어 위치를 발견하면
                if (Integer.parseInt(temp[j]) == 9) {
                    // 아기상어 변수에 아기상어 객체 생성
                    shark = new Fish(i, j, 2, 0,0);
                    // 지도에서 돌아다닐 때 몸집을 기준으로 판단하기 위해 9 대신 빈칸인 0으로 변경
                    map[i][j] = 0;
                    continue;
                }
                // 초기에 먹을 수 있는 먹이가 발견되면
                if (Integer.parseInt(temp[j]) == 1) {
                    // 먹이 리스트에 초기에 먹을 수 있는 먹이 저장
                    feeds.add(new Fish(i, j, 0, 0,0));
                }
                // 맵 초기화
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        // 맵 초기화가 종료되고 초기에 먹을 수 있는 먹이가 없을 경우
        if (feeds.isEmpty()) {
            // 0값 반환 후 종료
            System.out.println(0);
            return;
        }
        // 맵에서 상하좌우로 이동하기 위해 좌표계산에 사용하는 배열
        int[] moveR = {-1, 1, 0, 0};
        int[] moveC = {0, 0, -1, 1};

        // 먹이를 찾는 과정에서 먹을 수 있는 먹이들의 위치를 저장하기 위한 우선순위큐
        // 내부 정렬 기준은 다음과 같다.
        // 1. 가장 거리가 가까운 먹이
        // 2. 거리가 같은 경우 위에 있는 먹이'
        // 3. 같은 행에 있으면 가장 왼쪽에 있는 먹이
        PriorityQueue<Fish> pq = new PriorityQueue<Fish>(new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                if (o1.distance == o2.distance) {
                    if (o1.row == o2.row) {
                        return o1.col - o2.col;
                    } else {
                        return o1.row - o2.row;
                    }
                } else {
                    return o1.distance - o2.distance;
                }
            }
        });
        
        // BFS에 사용할 큐
        Queue<Fish> queue = new LinkedList<>();
        // 큐에 상어 넣기
        queue.offer(shark);

        // 엄마 부르기전까지 계속 반복
        while(true) {
            // BFS에서 방문여부를 체크하기 위한 2차원 배열
            boolean[][] chkMap = new boolean[N][N];
            // 초기 체크 2차원배열에 상어 위치 방문한 걸로 체크
            chkMap[queue.peek().row][queue.peek().col] = true;

            // 큐가 빌 때까지 반복
            while (!queue.isEmpty()) {
                // 큐에서 상어 꺼내기
                Fish fish = queue.poll();
                // 현재 상어의 위치 변수에 저장
                int nowRow = fish.row;
                int nowCol = fish.col;

                for (int i = 0; i < 4; i++) {
                    // 상하좌우 이동을 위한 좌표계산
                    int mr = nowRow + moveR[i];
                    int mc = nowCol + moveC[i];
                    
                    // 계산된 좌표가 맵을 벗어나거나, 방문한적이 있거나, 상어의 몸집보다 큰 물고기가 있다면 다음 좌표 계산
                    if (mr < 0 || mr >= N || mc < 0 || mc >= N || map[mr][mc] > fish.size || chkMap[mr][mc]) {
                        continue;
                    }

                    // 상어의 몸집보다 작으면서 빈칸이 아닌 경우
                    if (map[mr][mc] < fish.size && map[mr][mc] != 0) {
                        // 우선순위 큐에 먹이의 위치 저장
                        // 저장할 때 상어가 먹이 먹은 횟수, 상어가 이동한 횟수 1씩 증가
                        pq.offer(new Fish(mr, mc, fish.size, fish.eatCount + 1, fish.distance + 1));
                    }

                    // 해당 좌표로 이동하기 위해 큐에 상어의 이동횟수 1증가 시켜서 저장
                    queue.offer(new Fish(mr, mc, fish.size, fish.eatCount, fish.distance+1));
                    // 해당 좌표 방문처리
                    chkMap[mr][mc] = true;
                }
            }

            // BFS가 종료되고 먹을 수 있는 먹이가 없다면
            if (pq.isEmpty()) {
                // 현재까지 저장된 결과 값 반환 후 종료
                System.out.println(result);
                return;
            }

            // 먹이 꺼내기
            Fish fish = pq.poll();
            // 상어의 몸집이 먹이먹은 횟수와 동일하면
            if (fish.size == fish.eatCount) {
                // 상어 몸집 1 증가
                fish.size++;
                // 먹이먹은 횟수 0으로 초기화
                fish.eatCount = 0;
            }
            // 맵에서 좌표값 0으로 처리(먹이를 먹은 것임)
            map[fish.row][fish.col] = 0;
            // 먹이를 먹기위해 해당 좌표까지 이동한 거리 결과값에 더해서 갱신
            result += fish.distance;
            // 큐에 먹이를 먹은 상어 저장 (저장 할 때 이동거리 0으로 초기화)
            queue.offer(new Fish(fish.row, fish.col, fish.size, fish.eatCount, 0));
            // 먹이는 이동한 칸에 잇는 먹이 1개만 먹어야하므로 먹이를 저장한 우선순위 큐 비우기
            pq.clear();
        }
    }

    // 맵내에 있는 물고기를 표현할 클래스
    static class Fish {
        int row;            // 행
        int col;            // 열    
        int size;           // 상어의 몸집
        int eatCount;       // 상어가 먹이 먹은 횟수
        int distance;       // 상어가 이동한 횟수

        public Fish(int row, int col, int size, int eatCount, int distance) {
            this.row = row;
            this.col = col;
            this.size = size;
            this.eatCount = eatCount;
            this.distance = distance;
        }
    }
}