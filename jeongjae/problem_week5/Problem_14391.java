package problem_week5;

import java.util.*;

//Reference : https://lemonlemon.tistory.com/9
public class Problem_14391{
	
    public static void main(String[] args){
        Scanner sc= new Scanner (System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]a=new int [n][m];
        
        for(int i=0; i<n; i++)
        {
            String s=sc.next();
            for(int j=0; j<m; j++)
            {
                a[i][j]=s.charAt(j)-'0';
            }
        }
        
        int ans=0;
        
        for(int s=0; s<(1<<(n*m)); s++)
        {
            int sum=0;
            for(int i=0; i<n; i++){
                int current=0;
                for(int j=0; j<m; j++)
                {
                    int k=i*m+j;
                    if ((s&(1<<k))==0)
                    {
                        current=current*10+a[i][j];
                    }
                    else{
                        sum+=current;
                        current=0;
                    }
                }
                sum+=current;
            }
            for(int j=0;j<m; j++ )
            {
                int current=0;
                for(int i=0; i<n; i++)
                {
                    int k=i*m+j;
                    if ((s&(1<<k))!=0)
                    {
                        current=current*10+a[i][j];
                    }
                    else
                    {
                        sum+=current;
                        current=0;
                    }
                }
                sum+=current;
            }
            ans=Math.max(sum, ans);
        }
        System.out.println(ans);
    }
}