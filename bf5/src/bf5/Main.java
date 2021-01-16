package bf5;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] paper;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			paper = new int[n][m];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					paper[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					count = Math.max(count, poly1(i, j));
					count = Math.max(count, poly2(i, j));
					count = Math.max(count, poly3(i, j));
					count = Math.max(count, poly4(i, j));
					count = Math.max(count, poly5(i, j));
				}
			}
			
			System.out.println(count);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static int poly1(int i, int j) {
		int count = -1;
		if(j <= m - 4) {
			count = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];
		}
		if(i <= n - 4) {
			count = Math.max(count, paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j]);
		}
		return count;
	}
	
	public static int poly2(int i, int j) {
		int count = 0;
		if(i > n - 2 || j > m - 2) {
			return -1;
		}
		count = paper[i][j] + paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1];
		return count;
	}
	
	public static int poly3(int i, int j) {
		int count = 0;
		if(i <= n - 3 && j <= m - 2) {
			count = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
			count = Math.max(count, paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j]);
		}
		if(i <= n - 2 && j <= m - 3) {
			count = Math.max(count, paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j] + paper[i + 1][j + 1]);
			count = Math.max(count, paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 1][j + 2]);
		}
		return count;
	}
	
	public static int poly4(int i, int j) {
		int count = 0;
		if(i <= n - 3 && j <= m - 2) {
			count = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j + 1];
			count = Math.max(count, paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j] + paper[i + 2][j + 1]);
			count = Math.max(count, paper[i][j] + paper[i][j + 1] + paper[i + 1][j] + paper[i + 2][j]);
			count = Math.max(count, paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1]);
		}
		if(i <= n - 2 && j <= m - 3) {
			count = Math.max(count, paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2] + paper[i][j + 2]);
			count = Math.max(count, paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2] + paper[i][j]);
			count = Math.max(count, paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 2]);
			count = Math.max(count, paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j]);
		}
		return count;
	}
	
	public static int poly5(int i, int j) {
		int count = -1;
		if(i <= n - 2 && j <= m - 3) {
			count = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 1];
			count = Math.max(count, paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 1][j + 2]);
		}
		if(i <= n - 3 && j <= m - 2) {
			count = Math.max(count, paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1]);
			count = Math.max(count, paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 1][j + 1]);
		}
		return count;
	}
}
