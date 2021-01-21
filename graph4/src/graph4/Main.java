package graph4;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] edges;
	static boolean bipartite;
	static int[] check;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			
			while(N --> 0) {
				st = new StringTokenizer(br.readLine());
				int V = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				edges = (ArrayList<Integer>[]) new ArrayList[V];
				check = new int[V]; //0->x 1->A 2->B
				bipartite = true;
				
				for(int i = 0; i < V; i++) {
					edges[i] = new ArrayList<Integer>();
				}
				
				for(int i = 0; i < E; i++) {
					st = new StringTokenizer(br.readLine());
					int n1 = Integer.parseInt(st.nextToken()) - 1;
					int n2 = Integer.parseInt(st.nextToken()) - 1;
					edges[n1].add(n2);
					edges[n2].add(n1);
				}
				
				calc();
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
	
	public static void dfs(int n, int prev) {
		if(check[n] != 0) {
			if(check[n] != 3 - check[prev])
				bipartite = false;
			return;
		}
		if(prev != -1) {
			check[n] = 3 - check[prev];
		}
		else {
			check[n] = 1;
		}
		for(int i = 0; i < edges[n].size(); i++) {
			int next = edges[n].get(i);
			dfs(next, n);
		}
	}
	
	public static void calc() {
		for(int i = 0; i < check.length; i++) {
			if(check[i] == 0) {
				dfs(i, -1);
				if(!bipartite) {
					sb.append("NO").append('\n');
					return;
				}
			}
		}
		sb.append("YES").append('\n');
	}
}
