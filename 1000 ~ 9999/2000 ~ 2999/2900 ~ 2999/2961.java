import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Food {
	int sour;
	int salty;

	Food() {
	}

	Food(int sour, int salty) {
		this.sour = sour;
		this.salty = salty;
	}
}

public class Main {
	static int N;
	static int answer;
	static Food[] food;

	public static void makePowerSet(int count, boolean[] visit) {
		if (count >= N) {
			int sour = 1;
			int salty = 0;

			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					sour *= food[i].sour;
					salty += food[i].salty;
				}
			}

			if (sour != 1 && salty != 0) {
				answer = Math.min(answer, Math.abs(sour - salty));
			}
			
			return;
		}

		visit[count] = true;
		makePowerSet(count + 1, visit);

		visit[count] = false;
		makePowerSet(count + 1, visit);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		food = new Food[N];
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			food[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		makePowerSet(0, new boolean[N]);
		
		System.out.println(answer);
	}
}
