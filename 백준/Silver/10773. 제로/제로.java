import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();

        int k = Integer.parseInt(br.readLine());
        int sum = 0;

        while (k-- > 0) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                deque.removeLast();
                continue;
            }
            deque.add(temp);
        }

        int size = deque.size();
        for (int i = 0; i < size; i++) sum += deque.pop();
        System.out.println(sum);
    }
}