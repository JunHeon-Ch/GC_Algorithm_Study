package 프로그래머스.lv3.징검다리건너기;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        while(left <= right){
            int mid = (left + right) / 2;
            if(check(mid, k, stones)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    //mid : 인원 => 건널 수 있는가 없는가
    public boolean check(int mid, int k, int[] stones){
        int count = 0;
        for(int i=0; i<stones.length; i++) {
            if(stones[i] - mid < 0) //mid보다 작으면 mid가 건널 수 없다.
                count++;
            else
                count = 0;

            if (count == k)
                return false;
        }
        return true;
    }
}
