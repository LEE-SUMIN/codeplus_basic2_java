package graph7;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] maze;
	static int N, M;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			maze = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					maze[i][j] = input.charAt(j) - '0';
				}
			}
			
			bfs(new Pos(0, 0));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bfs(Pos start) {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(start);
		maze[start.get_i()][start.get_j()] = 1;
		while(!queue.isEmpty()) {
			Pos cur = queue.remove();
			int cur_i = cur.get_i();
			int cur_j = cur.get_j();
			int val = maze[cur_i][cur_j];
			if(cur_i == N - 1 && cur_j == M - 1) {
				System.out.println(maze[cur_i][cur_j]);
				return;
			}
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dx[i];
				int next_j = cur_j + dy[i];
				if(next_i < 0 || next_j < 0 || next_i > N - 1 || next_j > M - 1)
					continue;
				if(maze[next_i][next_j] == 1) {
					queue.add(new Pos(next_i, next_j));
					maze[next_i][next_j] = val + 1;
				}
			}
		}
	}

}

class Pos {
	private int i, j;
	
	Pos(int i, int j){
		this.i = i;
		this.j = j;
	}
	
	public int get_i() {
		return i;
	}
	
	public int get_j() {
		return j;
	}
}