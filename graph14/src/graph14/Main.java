package graph14;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] map;
	static int[][] dist;
	static Queue<Island> queue = new LinkedList<Island>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			numbering();
			int bridge = find_bridge();
			
			sb.append(bridge);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void numbering() {
		int num = 2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					bfs(new Island(i, j), num);
					num++;
				}
			}
		}
	}
	
	public static int find_bridge() {
		queue.clear();
		//1.모든 섬을 큐에 넣는다.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					queue.add(new Island(i, j));
				}
			}
		}
		//2. bfs를 이용하여 섬을 한 칸 씩 확장
		int bridge = 2 * N;
		while(!queue.isEmpty()) {
			Island cur = queue.remove();
			int cur_x = cur.get_i();
			int cur_y = cur.get_j();
			for(int i = 0; i < 4; i++) {
				int next_x = cur.get_i() + dx[i];
				int next_y = cur.get_j() + dy[i];
				if(next_x < 0 || next_y < 0 || next_x > N - 1 || next_y > N - 1)
					continue;
				if(map[next_x][next_y] != 0 && map[next_x][next_y] != map[cur_x][cur_y]) {
					int len = dist[next_x][next_y] + dist[cur_x][cur_y];
					if(len < bridge) {
						bridge = len;
					}
				}
				if(map[next_x][next_y] == 0) {
					map[next_x][next_y] = map[cur_x][cur_y];
					dist[next_x][next_y] = dist[cur_x][cur_y] + 1;
					queue.add(new Island(next_x, next_y));
				}
			}
		}
		return bridge;
	}
	
	public static void bfs(Island start, int num) {
		map[start.get_i()][start.get_j()] = num;
		queue.add(start);
		while(!queue.isEmpty()) {
			Island cur = queue.remove();
			for(int i = 0; i < 4; i++) {
				int next_x = cur.get_i() + dx[i];
				int next_y = cur.get_j() + dy[i];
				if(next_x < 0 || next_y < 0 || next_x > N - 1 || next_y > N - 1)
					continue;
				if(map[next_x][next_y] == 1) {
					map[next_x][next_y] = num;
					queue.add(new Island(next_x, next_y));
				}
			}
		}
	}

}

class Island {
	private int i, j;
	Island(int i, int j){
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
