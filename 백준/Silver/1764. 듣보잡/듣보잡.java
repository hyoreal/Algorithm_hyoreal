import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) map.put(br.readLine(), 1);
        
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name,0) +  1);
            if (map.get(name) == 2) list.add(name);
        }
      
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (String s : list) sb.append(s).append("\n");

        System.out.print(sb);
    }
}