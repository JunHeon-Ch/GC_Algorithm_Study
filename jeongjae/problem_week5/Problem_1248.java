package problem_week5;

import java.util.Scanner;

public class Problem_1248 {
	
	//Reference : https://toastfactory.tistory.com/206
	public static int N;
	public static int[] arr;
	public static char[] ch;
	public static char[][] map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		ch = new char[N*(N+1)/2];
		map = new char[N][N];
		int index = 0;
		
		String temp = sc.next();
		
		for(int i=0; i<N*(N+1)/2; i++)
		{
			ch[i]=temp.charAt(i);
		}	
		
		for(int i=0; i<N; i++)
		{
			for(int j=i; j<N; j++) map[i][j] = ch[index++];
		}
		
		arr = new int[N];
		go(0);
	}
	
	public static void go(int count)
	{
		if(count==N)
		{
			for(int i=0; i<N; i++) System.out.print(arr[i]+" ");
			System.exit(0);
			return;
		}
		
		for(int j=-10; j<=10; j++)
		{
			arr[count]=j;
			if(check(count)) go(count+1);
		}
	}
	
	public static boolean check(int index)
	{
		for(int i=0; i<=index; i++)
		{
			int sum = 0;
			
			for(int j=i; j<=index; j++)
			{
				sum += arr[j];
				if(map[i][j]!=(sum==0 ? '0' : (sum>0 ? '+' : '-'))) return false;
			}
		}
		return true;
	}
}
