package 프로그래머스.lv2.다리를지나는트럭;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        int time = 0;
        int weightsum = 0;
        for(int i=0; i<truck_weights.length; i++){
            int truck = truck_weights[i];
            while(true){
                //다리에 아무 차도 없는 경우
                if(queue.isEmpty()){
                    queue.add(truck);
                    time++;
                    weightsum += truck;
                    break;
                }
                else if(queue.size() == bridge_length){
                    weightsum -= queue.poll();
                }
                else{
                    if(weightsum + truck <= weight){
                        queue.add(truck);
                        weightsum += truck;
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
        return time + bridge_length;
    }
}
