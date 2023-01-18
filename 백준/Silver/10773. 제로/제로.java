import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

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
        for (int i = 0; i < size; i++) sum += deque.poll();
        System.out.println(sum);
    }
}
