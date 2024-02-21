
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DK_B1987 {

	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		n= Integer.parseInt(tk.nextToken());
		m = Integer.parseInt(tk.nextToken());
		char[][] map = new char[n][m];
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		//{int[] pos, hashset set}
		int answer = 0;
		System.out.println(dfs(0,0,1<<(map[0][0]-'A'),map));
		
	}
	static int dfs(int y, int x, int bitmask, char[][] map) {
		int result = Integer.bitCount(bitmask);
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(ny==-1 || ny == n || nx==-1 || nx==m) continue;
			if((bitmask&(1<<(map[ny][nx]-'A')) ) == 0) {
				result = Math.max(result,dfs(ny,nx,bitmask+(1<<(map[ny][nx]-'A')), map));
			}
		}
		
		
		return result;
	}
}
