import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int k = 0; k < t; k++) {
			int n = Integer.parseInt(br.readLine());

			Map<String, Integer> clothes = new HashMap<>();

			while (n-- > 0) {
				String[] arr = br.readLine().split(" ");

				if (clothes.containsKey(arr[1]))
					clothes.put(arr[1], clothes.get(arr[1]) + 1);
				else clothes.put(arr[1], 1);
			}

			int result = 1;

			for (int i : clothes.values()) result *= (i + 1);

			System.out.println(result-1);
		}
	}
}