package graph10;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int N, M;
	static char[][] board;
	static boolean[][] check;
	static int[][] dist;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static boolean cycle;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new char[N][M];
			check = new boolean[N][M];
			dist = new int[N][M];
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					board[i][j] = input.charAt(j);
				}
			}
			
			calc();
			
			if(cycle)
				System.out.println("Yes");
			else
				System.out.println("No");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void dfs(Dot start, int count) {
		int start_i = start.get_i();
		int start_j = start.get_j();
		if(check[start_i][start_j] == true) {
			if(count - dist[start_i][start_j] >= 4) {
				cycle = true;
				return;
			}
			return;
		}
		check[start_i][start_j] = true;
		dist[start_i][start_j] = count;
		for(int i = 0; i < 4; i++) {
			int next_i = start_i + dx[i];
			int next_j = start_j + dy[i];
			if(next_i < 0 || next_j < 0 || next_i > N - 1 || next_j > M - 1)
				continue;
			if(start.get_char() == board[next_i][next_j]) {
				dfs(new Dot(next_i, next_j, board[next_i][next_j]), count + 1);
			}
		}
	}
	
	public static void calc() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!check[i][j]) {
					dfs(new Dot(i, j, board[i][j]), 0);
					if(cycle) {
						return;
					}
				}
			}
		}
	}

}

class Dot {
	int i, j;
	char ch;
	Dot(int i, int j, char ch){
		this.i = i;
		this.j = j;
		this.ch = ch;
	}
	public int get_i() {
		return i;
	}
	public int get_j() {
		return j;
	}
	public char get_char() {
		return ch;
	}
}
