package graph2;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean[] check;
	static ArrayList<Integer>[] A;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			A = (ArrayList<Integer>[]) new ArrayList[N];
			
			for(int i = 0; i < N; i++) {
				A[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				A[n1 - 1].add(n2 - 1);
				A[n2 - 1].add(n1 - 1);
			}
			
			for(int i = 0; i < N; i++) {
				A[i].sort(null);
			}
			
			check = new boolean[N];
			dfs(V - 1);
			sb.append('\n');
			check = new boolean[N];
			bfs(V - 1);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void dfs(int start) {
		if(check[start])
			return;
		check[start] = true;
		sb.append(start + 1).append(' ');
		for(int i = 0; i < A[start].size(); i++) {
			int next = A[start].get(i);
			if(!check[next])
				dfs(next);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = true;
		while(!queue.isEmpty()) {
			int n = queue.remove();
			sb.append(n + 1).append(' ');
			for(int i = 0; i < A[n].size(); i++) {
				int next = A[n].get(i);
				if(!check[next]) {
					check[next] = true;
					queue.add(next);
				}
			}
		}
	}
}