package bfs4;
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] maze;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			maze = new int[N][M];
			int[][] check = new int[N][M];
			
			for(int i = 0 ; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					maze[i][j] = input.charAt(j) - '0';
					check[i][j] = -1;
				}
			}
			
			int time = bfs(check);

			System.out.println(time);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int bfs(int[][] check) {
		ArrayDeque<Room> deque = new ArrayDeque<Room>();
		Room start = new Room(0, 0);
		deque.add(start);
		check[start.get_i()][start.get_j()] = 0;
		while(!deque.isEmpty()) {
			Room cur = deque.pollLast();
			int cur_i = cur.get_i();
			int cur_j = cur.get_j();
			
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				
				if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
					continue;
				
				if(maze[next_i][next_j] == 1) {
					if(check[next_i][next_j] == -1 || check[next_i][next_j] > check[cur_i][cur_j] + 1) {
						check[next_i][next_j] = check[cur_i][cur_j] + 1;
						deque.addLast(new Room(next_i, next_j));
					}
				}
				if(maze[next_i][next_j] == 0) {
					if(check[next_i][next_j] == -1 || check[next_i][next_j] > check[cur_i][cur_j]) {
						check[next_i][next_j] = check[cur_i][cur_j];
						deque.addFirst(new Room(next_i, next_j));
					}
				}
			}
		}
		return check[N-1][M-1];
	}
}

class Room {
	private int i, j;
	
	Room(int i, int j){
		this.i = i;
		this.j = j;
	}
	
	public int get_i(){
		return i;
	}
	
	public int get_j() {
		return j;
	}
}