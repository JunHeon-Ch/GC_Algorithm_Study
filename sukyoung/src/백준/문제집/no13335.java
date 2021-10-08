package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            truck[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        int time = 0, sum = 0;
        for(int i=0; i<truck.length; i++){
            int truckWeight = truck[i];

            while(true){
                if(queue.isEmpty()){
                    queue.add(truckWeight);
                    time++;
                    sum += truckWeight;
                    break;
                }
                else if(queue.size() == w)
                    sum -= queue.poll();
                else{
                    if(sum + truckWeight <= L){
                        queue.add(truckWeight);
                        sum += truckWeight;
                        time++;
                        break;
                    }
                    else{
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        System.out.println(time + w);
    }
}

