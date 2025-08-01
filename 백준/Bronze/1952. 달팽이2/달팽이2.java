import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
	static int[][] arr;
	static boolean[][] checked;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[M][N];
		checked = new boolean[M][N];

		methodOne(0, 0, 0);


		System.out.println(answer-2);
		
	}

	// 0 : 오른쪽, 1 : 아래쪽, 2 : 왼쪽, 3: 위쪽
	static public void methodOne(int x, int y, int d){
		arr[x][y]++;
		if(arr[x][y] > 2){
			return;
		}
		int nx = dx[d] + x;
		int ny = dy[d] + y;

		if(nx < 0 || nx >= M || ny < 0 || ny >= N || arr[nx][ny] != 0){
			answer++;
			methodOne(x, y, (d+1)%4);
		} else {
			methodOne(nx, ny, d);
		}
	}
}