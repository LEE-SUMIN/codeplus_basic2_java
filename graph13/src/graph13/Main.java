package graph13;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] answer;
	static ArrayList<Integer>[] edges;
	static int idx = 0;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			edges = (ArrayList<Integer>[]) new ArrayList[N];
			answer = new int[N];
			boolean[] check = new boolean[N];
			int[] order = new int[N];
			
			for(int i = 0; i < N; i++) {
				edges[i] = new ArrayList<Integer>();
			}
			for(int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken()) - 1;
				int n2 = Integer.parseInt(st.nextToken()) - 1;
				edges[n1].add(n2);
				edges[n2].add(n1);
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				answer[i] = Integer.parseInt(st.nextToken()) - 1;
				order[answer[i]] = i;
			}
			Comparator<Integer> dfsComparator = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					if(order[o1] > order[o2]) return 1;
					else if(order[o1] == order[o2]) return 0;
					else return -1;
				}
				
			};
			
			for(int i = 0; i < N; i++) {
				edges[i].sort(dfsComparator);
			}
			
			if(dfs(check, 0)) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean dfs(boolean[] check, int start) {
		check[start] = true;
		if(start != answer[idx]) {
			return false;
		}
		idx++;
		for(int i : edges[start]) {
			if(check[i])
				continue;
			if(!dfs(check, i)) {
				return false;
			}
		}
		return true;
	}

}
