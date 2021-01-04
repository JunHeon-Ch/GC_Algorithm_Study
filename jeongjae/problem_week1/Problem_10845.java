package problem;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_10845 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
    Queue<Integer> que = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    int temp = 0;
    
    int N = sc.nextInt();
    for(int i=0; i<N; i++)
    {	
    	String order = sc.next();
    	if(order.equals("push"))
    	{
    		temp = sc.nextInt();
    		que.add(temp);
    	}
    	else if(order.equals("front")) System.out.println(que.isEmpty()?-1:que.peek());
    	else if(order.equals("back")) System.out.println(que.isEmpty()?-1:temp);
    	else if(order.equals("size")) System.out.println(que.size());
    	else if(order.equals("pop")) System.out.println(que.isEmpty()?-1:que.poll());
    	else if(order.equals("empty")) System.out.println(que.isEmpty()?1:0);
    }
   }
}