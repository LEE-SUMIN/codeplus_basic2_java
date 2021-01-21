package graph3;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] edges;
	static boolean[] check;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //정점의 개수
			int M = Integer.parseInt(st.nextToken()); //간선의 개수
			edges = (ArrayList<Integer>[]) new ArrayList[N];
			check = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				edges[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken()) - 1;
				int n2 = Integer.parseInt(st.nextToken()) - 1;
				edges[n1].add(n2);
				edges[n2].add(n1);
			}
			
			int num = calc();
			
			System.out.println(num);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = true;
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			for(int i = 0; i < edges[cur].size(); i++) {
				int next = edges[cur].get(i);
				if(!check[next]) {
					queue.add(next);
					check[next] = true;
				}
			}
		}
	}
	
	public static int calc() {
		int count = 0;
		for(int i = 0; i < check.length; i++) {
			if(!check[i]) {
				bfs(i);
				count++;
			}
		}
		return count;
	}

}
