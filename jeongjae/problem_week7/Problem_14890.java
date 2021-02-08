package problem_week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//reference : https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%8014890-%EA%B2%BD%EC%82%AC%EB%A1%9C-java
public class Problem_14890 {
	
	public static int N, L;
    public static int[][] map;
    public static int way = 0;

    public static void main(String[] args) throws Exception {
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++) {
        	//checking row
        	//행 검사
            if (possible_way(i, 0, 0)) way++;
            //checking column
            //열 검사
            if (possible_way(0, i, 1)) way++;
        }
        System.out.println(way);
    }

    public static boolean possible_way(int x, int y, int flag) {
        
    	//checking whether a slope can be disposed
    	//경사로가 배치될 수 있는지 없는지 체크
    	boolean[] check = new boolean[N];
    	//storing each height of the way
    	//길을 이루는 각 요소의 높이 저장
        int[] height = new int[N];

        for (int i=0; i<N; i++) {
        	if (flag==0) height[i]=map[x][y+i];
        	else height[i]=map[x+i][y];
        }

        for (int i=0; i<N-1; i++) {
            
        	//if the height difference is 0
        	//높이 차이가 없을 때
        	if (height[i]==height[i + 1]) continue;
        	
        	//if the height difference is more than 2
        	//높이 차이가 2 이상일 때
            if (Math.abs(height[i]-height[i + 1])>1) return false;
           
            //if the height difference is 1
            //높이 차이가 1일때(앞이 높은 경우)
            if (height[i]-1==height[i+1]) {
            	
            	//checking whether a slope whose length is L can be disposed
            	//길이가 L인 경사로가 배치될 수 있는지 없는지 체크
                for (int j=i+1; j<=i+L; j++) {
                    if (j>=N || check[j] || height[j]!=height[i + 1]) return false;
                    check[j] = true;
                }   
            }
            //if the height difference is 1
            //높이 차이가 1일때(뒤가 높은 경우)
            else if (height[i]+1==height[i+1]) {
            	
            	//checking whether a slope whose length is L can be disposed
            	//길이가 L인 경사로가 배치될 수 있는지 없는지 체크
                for (int j=i; j>i-L; j--) {
                    if (j<0 || check[j] || height[j]!=height[i]) return false;
                    check[j] = true;
                }
            }
        }
        
        return true;
    }
}