package graph8;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int N, M;
	static int[][] box;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			box = new int[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					box[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = bfs();
			
			System.out.println(max);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int bfs() {
		int max = 1;
		Queue<Tomato> queue = new LinkedList<Tomato>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 1) {
					queue.add(new Tomato(i, j));
				}
			}
		}
		while(!queue.isEmpty()) {
			Tomato cur = queue.remove();
			int cur_i = cur.get_i();
			int cur_j = cur.get_j();
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dx[i];
				int next_j = cur_j + dy[i];
				if(next_i < 0 || next_j < 0 || next_i > N - 1 || next_j > M - 1)
					continue;
				if(box[next_i][next_j] == 0) {
					queue.add(new Tomato(next_i, next_j));
					int val = box[cur_i][cur_j] + 1;
					box[next_i][next_j] = val;
					if(max < val) {
						max = val;
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					return -1;
				}
			}
		}
		return max - 1;
	}

}

class Tomato {
	private int i, j;
	
	Tomato(int i, int j){
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
