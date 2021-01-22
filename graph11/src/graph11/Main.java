package graph11;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] subway;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			subway = (ArrayList<Integer>[]) new ArrayList[N];
			int[] check = new int[N];
			
			for(int i = 0; i < N; i++) {
				subway[i] = new ArrayList<Integer>();
			}
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken()) - 1;
				int n2 = Integer.parseInt(st.nextToken()) - 1;
				subway[n1].add(n2);
				subway[n2].add(n1);
			}
			int start = 0;
			dfs(0, -1, check);
			int[] dist = bfs(check);
			
			for(int i = 0; i < N; i++) {
				sb.append(dist[i]).append(' ');
			}
			bw.write(sb.toString());
			bw.close();
			br.close();
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int dfs(int start, int prev, int[] check) {
		if(check[start] == 1) {
			return start;
		}
		check[start] = 1;
		for(int i = 0; i < subway[start].size(); i++) {
			int next = subway[start].get(i);
			if(next == prev)
				continue;
			int k = dfs(next, start, check);
			if(k == -2) {
				return -2;	
			}
			if(k >= 0) {
				check[start] = 2;
				if(k == start) {
					return -2;
				}
				else {
					return k;
				}
			}
		}
		return -1;
	}
	
	public static int[] bfs(int[] check) {
		int[] dist = new int[check.length];
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < check.length; i++) {
			if(check[i] == 2) {
				dist[i] = 0;
				queue.add(i);
			}
			else {
				dist[i] = -1;
			}
		}
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			for(int i = 0; i < subway[cur].size(); i++) {
				int next = subway[cur].get(i);
				if(dist[next] == -1) {
					if(check[next] == 2) {
						dist[next] = 0;
					}
					else {
						dist[next] = dist[cur] + 1;
					}
					queue.add(next);
					check[next] = 0;
				}
			}
		}
		return dist;
	}
}
