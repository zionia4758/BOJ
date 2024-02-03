
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 봄버맨{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = bf.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);

        char[][] map = new char[r][c];
        for(int y=0; y<r; y++){
            for(int x=0; x<c; x++){
                if(bf.read() == 'O') map[y][x] = 'O';
                else map[y][x] = '.';
            }
            bf.readLine();
        }
 
        if(n == 1 || n == 0) {
            display(convert(map,r),out);
            return;
        }
        else if(n%2 == 0){
            char[] l = new char[c];
            Arrays.fill(l,'O');
            String answer = new String(l);
            for(int i=0; i<r; i++)
                out.write(answer+'\n');
            out.flush();
            return;
        }
        else if(n==3)
            map = putBombAvoidBomb(map, r, c);
        else if((n+1)/2%2 == 0)
            map = putBombAvoidBomb(putBombAvoidBomb(putBombAvoidBomb(map, r, c), r, c), r, c);
        else if((n+1)/2%2 == 1)
            map = putBombAvoidBomb(putBombAvoidBomb(map, r, c), r, c);
        
        display(convert(map,r),out);
    }
    static char[][] putBombAvoidBomb(char[][] map,int r,int c){
        char[][] next_map = new char[r][c];
        for(int y=0; y<r; y++){
            for(int x=0; x<c; x++){
                next_map[y][x] = '.';
                if(map[y][x] == 'O') continue; 
                if(x!=0 && (map[y][x-1] == 'O')) continue;
                if(x!=c-1 && (map[y][x+1] == 'O')) continue;
                if(y!=0 && (map[y-1][x]=='O')) continue;
                if(y!=r-1 && (map[y+1][x]=='O')) continue;
                next_map[y][x] = 'O';
            }
        }
        return next_map;
    }
    static void display(String[] answer,BufferedWriter out) throws IOException{
        for(String line: answer){
            out.write(line+'\n');
        }
        out.flush();
    }
    static String[] convert(char[][] map,int r){
        String[] answer = new String[r];
        for(int i=0; i<r; i++){
            answer[i] = new String(map[i]);
        }
        return answer;
    }
}
