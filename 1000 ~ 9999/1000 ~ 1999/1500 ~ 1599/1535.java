import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] HP; // 체력
	static int[] MP; // 기쁨
	static boolean[] visit;
	static int answer;

	public static void dfs(int curHP, int curMP, int index) {
		if (index >= N) {
			return;
		}

		for (int i = index; i < N; i++) {
			if (!visit[i] && curHP + HP[i] < 100) {
				visit[i] = true;
				answer = Math.max(answer, curMP + MP[i]);
				dfs(curHP + HP[i], curMP + MP[i], i + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		answer = 0;
		HP = new int[N];
		MP = new int[N];
		visit = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			HP[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			MP[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0, 0);
		System.out.println(answer);
	}
}