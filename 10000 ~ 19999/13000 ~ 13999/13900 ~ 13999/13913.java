import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 9999999;

		int MAX_SIZE = 200001;
		int[] dist = new int[MAX_SIZE];
		int[] parent = new int[MAX_SIZE];

		Arrays.fill(dist, 9999999);

		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		dist[N] = 0;
		parent[N] = -1;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == M && answer > dist[cur]) {
				answer = dist[cur];
				continue;
			}

			if (dist[cur] > dist[M]) {
				continue;
			}

			if (cur - 1 >= 0 && dist[cur - 1] > dist[cur] + 1) {
				q.offer(cur - 1);
				dist[cur - 1] = dist[cur] + 1;
				parent[cur - 1] = cur;
			}

			if (cur + 1 < MAX_SIZE && dist[cur + 1] > dist[cur] + 1) {
				q.offer(cur + 1);
				dist[cur + 1] = dist[cur] + 1;
				parent[cur + 1] = cur;
			}

			if (cur * 2 < MAX_SIZE && dist[cur * 2] > dist[cur] + 1) {
				q.offer(cur * 2);
				dist[cur * 2] = dist[cur] + 1;
				parent[cur * 2] = cur;
			}
		}
		
		sb.append(answer).append("\n");
		
		Stack<Integer> stk = new Stack<>();
		stk.add(M);
		
		int cur = M;
		
		while(true) {
			if(parent[cur] == -1)
				break;
			
			stk.add(parent[cur]);
			cur = parent[cur];
		}
		
		while(!stk.isEmpty()) {
			sb.append(stk.pop()).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
