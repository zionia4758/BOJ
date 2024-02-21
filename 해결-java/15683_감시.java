
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DK_B15683 {
	
	static int[][] map;
	static int[][] cctvPos;
	static int[][] maxLen;
	static int n;
	static int m;
	static int result=0;
	static int answer=64;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(tk.nextToken());
		m = Integer.parseInt(tk.nextToken());
		result = n*m;
		map = new int[n][m];
		int cctvCnt = 0;
		cctvPos = new int[8][2];
		for(int y=0;y<n;y++) {
			tk = new StringTokenizer(br.readLine());
			for(int x=0;x<m;x++) {
				int num = Integer.parseInt(tk.nextToken());
				if(num==0) continue;
				result --;
				map[y][x] = num;
				if(num != 6) {
					cctvPos[cctvCnt] = new int[] {y,x};
					cctvCnt++;
				}
					
			}
		}
		//3-6-9-12 방향 벽을 만날떄까지 거리
		maxLen = new int[cctvCnt][4];
		for(int cIdx=0; cIdx<cctvCnt; cIdx++) {
			int[] pos = cctvPos[cIdx];
			int y=pos[0];
			int x=pos[1];
			for(int i=1; x+i<m; i++){
				if(map[y][x+i]==6) break;
				else if(map[y][x+i]!=0) {
					continue;
				}
				maxLen[cIdx][0]++;
			}
			for(int i=1; y+i<n; i++) {
				if(map[y+i][x]==6) break;
				else if(map[y+i][x]!=0) {
					continue;
				}
				maxLen[cIdx][1]++;
			}
			for(int i=1; x-i>=0; i++) {
				if(map[y][x-i]==6) break;
				else if(map[y][x-i]!=0) {
					continue;
				}
				maxLen[cIdx][2]++;
			}
			for(int i=1; y-i>=0; i++) {
				if(map[y-i][x]==6) break;
				else if(map[y-i][x]!=0){
					continue;
				}
				maxLen[cIdx][3]++;
			}
		}
		dfs(0);
		System.out.println(answer);
		
	}

	static boolean[][][] see = new boolean[][][] {
		{
			{true,false,false,false},
			{false,true,false,false},
			{false,false,true,false},
			{false,false,false,true}
		},
		{
			{true,false,true,false},
			{false,true,false,true}
		},
		{
			{true,true,false,false},
			{false,true,true,false},
			{false,false,true,true},
			{true,false,false,true}
		},
		{
			{true,true,true,false},
			{false,true,true,true},
			{true,false,true,true},
			{true,true,false,true}
		},
		{
			{true,true,true,true}
		}
	};
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static void dfs(int idx) {

		if(idx==maxLen.length) {
//			System.out.println(result);
//			for(int[] line:map) {
//				System.out.println(Arrays.toString(line));
//			}
//			System.out.println(answer);
//			System.out.println();
			answer = Math.min(answer,result);
			return;
		}
		int[] pos = cctvPos[idx];
		int type = map[pos[0]][pos[1]]-1;
		for(boolean[] range: see[type]) {
			for(int i=0; i<4; i++) {
				if(range[i]) {
					check(pos[0],pos[1],dy[i],dx[i]);
				}				
			}
			dfs(idx+1);
			for(int i=0; i<4; i++) {
				if(range[i]) {
					uncheck(pos[0],pos[1],dy[i],dx[i]);
				}				
			}
		}
		
		return ;
	}
	static void check(int y, int x, int dy, int dx) {
		int ny = y+dy;
		int nx = x+dx;
		while(ny<n&&ny>=0&&nx<m&&nx>=0) {
			if(map[ny][nx]==6) break;
			if(map[ny][nx]>=10) {
				map[ny][nx] += 10;
			}
			else if(map[ny][nx] == 0) {
				map[ny][nx] += 10;
				result --;
			}
			ny+=dy;
			nx+=dx;
		}
	}
	static void uncheck(int y, int x, int dy, int dx) {
		int ny = y+dy;
		int nx = x+dx;
		while(ny<n&&ny>=0&&nx<m&&nx>=0) {
			if(map[ny][nx]==6)break;
			if(map[ny][nx]>10) {
				map[ny][nx] -= 10;
			}
			else if(map[ny][nx] == 10) {
				map[ny][nx] = 0;
				result ++;
			}
			ny+=dy;
			nx+=dx;
		}
	}
}
