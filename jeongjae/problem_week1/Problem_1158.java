package problem;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_1158 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N, K;
		int count = 1;
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		StringBuilder output = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();		
		for(int i=1; i<=N; i++)
		{
			queue1.add(i);
		}
		while(!queue1.isEmpty())
		{
			if(count==K)
			{
				queue2.add(queue1.poll());
				count=1;
			}
			else
			{
				queue1.add(queue1.poll());
				count=count+1;
			}
		}
		output.append("<");
		for(int i=0; i<N-1; i++)
		{
			output.append(queue2.poll()).append(", ");
		}
		output.append(queue2.poll()).append(">");
		System.out.println(output);
	}
}