package problem_week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.awt.Point;

public class Problem_15662 {
    
	public static int T, K;
    public static int cogwheel[][];
    public static int temp[][];
    public static boolean[] check;
    public static Queue<Point> q = new LinkedList<>();
    public static ArrayList<Point> al = new ArrayList<>();
    public static int count = 0;
    
    public static void main(String[] args) throws IOException{
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        cogwheel = new int[T+1][9];
        temp = new int[T+1][9];
        
        for(int i=1; i<=T; i++) {
            String line = br.readLine();
            for(int j=1; j<9; j++)  cogwheel[i][j] = line.charAt(j-1)-'0';
        }
  
        K = Integer.parseInt(br.readLine());
        
        for(int i=0; i<K; i++) {
            String[] line = br.readLine().split(" ");
            int num = Integer.parseInt(line[0]);
            int dir = Integer.parseInt(line[1]);
            q.add(new Point(num, dir));
        }
        
        //processing all operations
        //모든 연산 처리하기(톱니바퀴 회전시키기)
        while(!q.isEmpty()) {
        	
        	al.clear();
        	check= new boolean[T+1];
            Point p= q.remove();
            int num = p.x;
            int dir = p.y;
            check[num]=true;
            
            //finding out every cogwheel that can be rotated by others
            //한 톱니바퀴의 회전으로 인해 회전이 가능한 모든 톱니바퀴를 찾아낸다
            find_cogwheel(num,dir);
            
            //rotating every cogwheel that can be rotated
            //회전이 가능한 모든 톱니바퀴를 회전시킨다
            for(int i=0; i<al.size(); i++) rotate_cogwheel(al.get(i).x,al.get(i).y);
        }
        
        //총 K번 회전시킨 이후에 12시방향이 S극인 톱니바퀴의 개수 찾기
        for(int i=1; i<=T; i++) {
            if(cogwheel[i][1]==1) count++;
        }
        System.out.print(count);
    }
    
    //finding all cogwheels that rotate when one cogwheel(#num) rotates
    //번호가 num인 톱니바퀴가 회전했을때 그로 인해 회전하는 모든 톱니바퀴 찾기
    public static void find_cogwheel(int num, int dir) {
    	
        al.add(new Point(num, dir));
        
        if(num-1>=1 && cogwheel[num-1][3]!=cogwheel[num][7] && check[num-1]==false ) {
            check[num-1] = true;
            find_cogwheel(num-1, dir*-1);
        }
        if(num+1<=T && cogwheel[num+1][7] != cogwheel[num][3] && check[num+1]==false) {
            check[num+1] = true;
            find_cogwheel(num+1, dir*-1);
        }
    }
    
    //rotating one cogwheel
    //한개의 톱니바퀴 회전시키기
    public static void rotate_cogwheel(int num, int dir) {
    	
    	//copying the status of every cogwheel to 2D array temp
    	//2D array temp에 현재 모든 톱니바퀴의 상태 복사하기
        for(int i=1; i<=T; i++) {
            for(int j=1; j<9; j++) {
                temp[i][j]=cogwheel[i][j];
            }
        }
        //clock_wise_rotation
        //시계방향회전
        if(dir==1) {
            for(int i=1; i<9; i++) {
                if(i==1) {
                    cogwheel[num][1] = temp[num][8];
                }
                else {
                    cogwheel[num][i] = temp[num][i-1];
                }
            }
        }
        //counter_clock_wise_rotation
        //반시계방향회전
        else {
            for(int i=8; i>=1; i--) {
                if(i==8) {
                    cogwheel[num][8]=temp[num][1];
                }
                else {
                    cogwheel[num][i] = temp[num][i+1];
                }
            }
        }
    }
}