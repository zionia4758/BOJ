
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class DK_B2636 {

	static int[][] map = new int[100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		int total = 0;
		ArrayDeque<int[]> queue = new ArrayDeque<>(1024);
		ArrayDeque<int[]> blank = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				if(Integer.parseInt(tk.nextToken())==1) {
					map[i][j] = 1;
					total++;
				}

			}
		}
		
		queue.offer(new int[] {0,0,0});
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		visited[0][0] = true;
		int cnt = 0 ;
		int beforeTime = 0;
		while(!queue.isEmpty()) {
			int[] q = queue.pollFirst();
			

			int x=q[0];
			int y=q[1];
			int t=q[2];
			if(t>beforeTime) {
				beforeTime = t;
				cnt = total;
			}
			if(map[y][x]==0) {
				blank.offer(new int[] {x,y});
				while(!blank.isEmpty()) {
					q=blank.pollFirst();
					x=q[0];
					y=q[1];
					for(int i=0;i<4;i++) {
						int ny=y+dy[i];
						int nx=x+dx[i];
						if(ny==-1 || ny==n || nx==-1 || nx==m || visited[ny][nx]) continue;

						if(map[ny][nx]==0) {
							blank.offer(new int[] {nx,ny});
						}else if(map[ny][nx]==1) {
							queue.offer(new int[] {nx,ny,t+1});
						}
						visited[ny][nx]=true;		
					} 
				}
			}

			else {
				total --;
				for(int i=0;i<4;i++) {
					int ny=y+dy[i];
					int nx=x+dx[i];
					if(ny<0 || ny==n || nx<0 || nx==m || visited[ny][nx]) continue;

					if(map[ny][nx] == 1)
						queue.offer(new int[] {nx,ny,t+1});
					else
						queue.offerFirst(new int[] {nx,ny,t});
					visited[ny][nx]=true;
				}
			}
		}
		
		System.out.println(new StringBuilder().append(beforeTime).append('\n').append(cnt));

	
		
		

	}

}
