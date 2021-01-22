package bfs1;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int time = bfs(N, K);
			System.out.println(time);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static int bfs(int N, int K) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] check = new int[100001];
		check[N] = 1;
		queue.add(N);
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			if(cur == K) {
				return check[cur] - 1;
			}
			if(2 * cur < 100001 && check[2 * cur] == 0) {
				queue.add(2 * cur);
				check[2 * cur] = check[cur] + 1;
			}
			if(cur + 1 < 100001 && check[cur + 1] == 0) {
				queue.add(cur + 1);
				check[cur + 1] = check[cur] + 1;
			}
			if(cur - 1 >= 0 && check[cur - 1] == 0) {
				queue.add(cur - 1);
				check[cur - 1] = check[cur] + 1;
			}
		}
		return -1;
	}

}
