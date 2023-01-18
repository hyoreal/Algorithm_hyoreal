import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int count = 1;
        int range = 2;
        if (n.equals("1")) System.out.print(1);
        else {
            while (range <= Integer.parseInt(n)) {
                range += count * 6;
                count++;
            }
            System.out.print(count);
        }
    }
}