import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> rope = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			rope.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(rope, Comparator.reverseOrder());

		double answer = rope.get(0);

		for (int i = 1; i < N; i++) {
			answer = Math.max(answer, rope.get(i) * (i + 1));
		}
		
		System.out.println((int)answer);
	}
}
