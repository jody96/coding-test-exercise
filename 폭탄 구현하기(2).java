import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char[][] land_state = new char[n+1][n+1];
		int[][] land_value = new int[n+1][n+1];
		
		int[][] pos = {
			{0,0},
			{-1,0},
			{1,0},
			{0,1},
			{0,-1}
		};
		
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++){
				land_state[i][j] = st.nextToken().charAt(0);
			}
		}
		
		for(int i=0; i<k; i++){
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			char state = land_state[y][x];

			for(int j=0; j<5; j++){
				int ny = y + pos[j][0];
				int nx = x + pos[j][1];
				if(ny > n || ny < 1 || nx > n || nx < 1)
					continue;
				if(land_state[ny][nx] == '#')
					continue;
				else if(land_state[ny][nx] == '@')
					land_value[ny][nx] += 2;
				else
					land_value[ny][nx] += 1;
			}
		}
		
		int max = 0;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				max = Math.max(max, land_value[i][j]);
			}
		}
		
		System.out.println(max);
	}
}
