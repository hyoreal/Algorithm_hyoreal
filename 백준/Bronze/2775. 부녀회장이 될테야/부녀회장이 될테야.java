import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[][] matrix = new int[15][15];
        for (int i = 0; i < 15; i++) {
            matrix[i][1] = 1;
            matrix[0][i] = i;
        }

        for (int i = 1; i < 15; i++) 
            for (int j = 2; j < 15; j++)
                matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(matrix[k][n]);
        }
    }
}
