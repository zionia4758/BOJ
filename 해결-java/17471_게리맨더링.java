
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DK_B17471 {

	static List<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int[] population = new int[n];
		for(int i=0; i<n; i++) {
			population[i] = Integer.parseInt(tk.nextToken());
		}
		graph = new ArrayList[n];
		for(int i=0; i<n; i++) {
			graph[i] = new ArrayList<>();
			tk = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(tk.nextToken());
			for(int cnt=0; cnt<c; cnt++) {
				graph[i].add(Integer.parseInt(tk.nextToken())-1);
			}
		}
		int answer = -1;
		
		loop:
		for(int bitmask = 1; bitmask<(1<<(n-1)); bitmask++) {

			//red = bit가 1, blue = bit가 2
			int[] visited = new int[n];
			
			int redCnt = 0;
			for(int i=0; i<n; i++) {
				//bit가 활성화된 곳들에서 1로 바꾸는 bfs 탐색을 한바퀴 돌린다.
				if(getColor(i,bitmask)==1 && visited[i]!=1) {
					bfs(visited,i,1,bitmask);
					break;
				}
			}
			for(int i=0; i<n; i++) {
				//bit가 활성화된 곳들에서 2로 바꾸는 bfs 탐색을 한바퀴 돌린다.
				if(getColor(i,bitmask)==2 && visited[i]!=2) {
					bfs(visited,i,2,bitmask);
					break;
				}
			}
			int red = 0;
			int blue = 0;
			//만약 결과가 bitmask와 다르다면 false
			for(int i=0; i<n; i++) {
				if(visited[i]==0) continue loop;
				if(visited[i] == 1) red += population[i];
				else blue += population[i];
			}
			int result = Math.abs(red-blue);
			if(answer == -1) answer = result;
			else if(result < answer) answer=  result;
		}
		System.out.print(answer);
	}
	static void bfs(int[] visited, int node, int color, int bitmask) {

		visited[node] = color;
		for(int nextNode : graph[node]) {
			if(visited[nextNode]==color || getColor(nextNode,bitmask)!=color) continue;
			bfs(visited,nextNode, color, bitmask);
		}
		return ;
	}
	static int getColor(int node, int bitmask) {
		if((bitmask&(1<<node))!=0) return 1;
		else return 2;
	}
}
