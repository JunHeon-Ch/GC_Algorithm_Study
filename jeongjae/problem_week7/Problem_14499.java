package problem_week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14499 {
    
	public static int N, M, x, y, K;
	public static int[][] map;
	public static int[] dice = new int[7];
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
	 
    public static void main(String[] args) throws IOException {
    	// TODO Auto-generated method stub
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++) {
        	
            int move = Integer.parseInt(st.nextToken());
            int nx = x+dx[move-1];
            int ny = y+dy[move-1];
	 
            if (nx>=0 && ny>=0 && nx<N && ny<M) {
                
            	roll_dice(move);
                if (map[nx][ny]==0) map[nx][ny] = dice[6];
                else {
                	//copying the value on map to the base side of the dice
                	//맵의 값을 주사위의 밑면에 복사하기
                    dice[6] = map[nx][ny];
                    //write 0 on the map whose value is copied
                    //맵의 값을 주사위의 밑면에 복사하고 맵에 0이라 쓰기
                    map[nx][ny] = 0;
                }
                x = nx;
                y = ny;
                System.out.println(dice[1]);
            }
        }
    }
	 
    //rolling dice
    //주사위 굴리기
    public static void roll_dice(int direction) {
    	
    	//copying the status of the dice
    	//주사위의 상태 복사하기
        int[] temp = dice.clone();
        
        //east
        //동
        if (direction==1) {
        	
            dice[1] = temp[4];
            dice[3] = temp[1];
            dice[4] = temp[6];
            dice[6] = temp[3];
        }
        //west
        //서
        else if (direction==2) {
        	
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[4] = temp[1];
            dice[6] = temp[4];
        }
        //south
        //남
        else if (direction==3) {
        	
            dice[1] = temp[5];
            dice[2] = temp[1];
            dice[5] = temp[6];
            dice[6] = temp[2];
        }
        //north
        //북
        else {
        	
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[5] = temp[1];
            dice[6] = temp[5];
        }
    }
}