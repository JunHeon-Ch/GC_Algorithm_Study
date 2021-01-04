package problem;

import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Problem_10866 { 

   public static void main(String[] args) {
       // TODO Auto-generated method stub
	   Scanner sc = new Scanner(System.in);
	   Deque<Integer> deque = new LinkedList<>();
	   
	   int count = sc.nextInt();
	   for(int i=0; i<count; i++)
	   {
		   String order = sc.next();
		   if(order.equals("push_back")) deque.addLast(sc.nextInt());
		   else if(order.equals("push_front")) deque.addFirst(sc.nextInt());
		   else if(order.equals("pop_front")) System.out.println(deque.isEmpty()?-1:deque.pop());
		   else if(order.equals("pop_back")) System.out.println(deque.isEmpty()?-1:deque.removeLast());
		   else if(order.equals("size")) System.out.println(deque.size());
		   else if(order.equals("empty")) System.out.println(deque.isEmpty()?1:0);
		   else if(order.equals("front")) System.out.println(deque.isEmpty()?-1:deque.peek());
		   else if(order.equals("back")) System.out.println(deque.isEmpty()?-1:deque.peekLast());
	   }
   	}
}