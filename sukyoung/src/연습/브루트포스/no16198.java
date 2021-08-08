package 연습.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no16198 {
    public static int ans;
    public static ArrayList<Integer> marble;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        marble = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            marble.add(Integer.parseInt(st.nextToken()));

        ans = 0;
        energy(n,0);
        System.out.println(ans);
    }
    public static void energy(int n,int sum){
        if(n == 2){
            ans = Math.max(ans,sum);
            return;
        }

        for(int i=1; i<marble.size()-1; i++){
            int energySum = marble.get(i-1) * marble.get(i+1);
            int energy = marble.get(i);

            marble.remove(i);
            energy(n-1, sum + energySum );
            marble.add(i,energy);
        }

    }
}
