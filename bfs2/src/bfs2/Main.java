package bfs2;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			bfs(N, K);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void bfs(int N, int K) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] check = new int[100001];
		int[] prev = new int[100001];
		int cur = N;
		int time = -1;
		check[cur] = 1;
		queue.add(cur);
		while(!queue.isEmpty()) {
			cur = queue.remove();
			if(cur == K) {
				time = check[cur] - 1;
				break;
			}
			if(2 * cur < 100001 && check[2 * cur] == 0) {
				check[2 * cur] = check[cur] + 1;
				prev[2 * cur] = cur;
				queue.add(2 * cur);
			}
			if(cur + 1 < 100001 && check[cur + 1] == 0) {
				check[cur + 1] = check[cur] + 1;
				prev[cur + 1] = cur;
				queue.add(cur + 1);
			}
			if(cur - 1 >= 0 && check[cur - 1] == 0) {
				check[cur - 1] = check[cur] + 1;
				prev[cur - 1] = cur;
				queue.add(cur - 1);
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		
		while(cur != N) {
			stack.add(cur);
			cur = prev[cur];
		}
		stack.add(cur);
		sb.append(time).append('\n');
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(' ');
		}
	}
}
