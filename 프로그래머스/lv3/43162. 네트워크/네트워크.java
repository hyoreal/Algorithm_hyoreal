import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 방문 확인할 배열
        int answer = 0;

        for (int i = 0; i < n; i++) {
        	if(visited[i] == false) {
        		bfs(i, computers, visited);
    			answer++;
    		}
        }

        return answer;
    }
    
    public void bfs(int start, int[][] graph, boolean[] visited) {
        // 큐 선언
        Deque<Integer> q = new LinkedList<>();
        
        // 큐에 시작노드 삽입
        q.offer(start);
        // 첫 시작 노드 방문처리
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            for (int j = 0; j < graph[node].length; j++) {
                if(!visited[j] && graph[node][j] == 1) {
                    visited[j] = true;
                    q.offer(j);
                }
            }
        }
    }
}