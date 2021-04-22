import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String num = br.readLine();

			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}
		
		int max = -1;
		long answer = 0;
		
		for(String num : map.keySet()) {
			int count = map.get(num);
			if(count > max) {
				max = count;
				answer = Long.parseLong(num);
			} else if(count == max) {
				answer = Math.min(answer, Long.parseLong(num));
			}
		}
		
		System.out.println(answer);
	}
}