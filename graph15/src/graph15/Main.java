package graph15;
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
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
		Deque<Integer> deque = new LinkedList<Integer>();
		int[] check = new int[200001];
		int cur = N;
		check[cur] = 1;
		deque.addLast(cur);
		while(!deque.isEmpty()) {
			cur = deque.remove();
			if(cur == K) {
				return check[cur] - 1;
			}
			if(cur + 1 < 200000) {
				if(check[cur + 1] == 0 || check[cur] + 1 < check[cur + 1]) {
					deque.addLast(cur + 1);
					check[cur + 1] = check[cur] + 1;
				}
			}
			if(cur > 0) {
				if(check[cur - 1] == 0 || check[cur] + 1 < check[cur - 1]) {
					deque.addLast(cur - 1);
					check[cur - 1] = check[cur] + 1;
				}
			}
			if(2 * cur < 200000) {
				if(check[2 * cur] == 0 || check[cur] < check[2 * cur]) {
					deque.addFirst(2 * cur);
				check[2 * cur] = check[cur];
				}	
			}
		}
		return -1;		
	}

}
