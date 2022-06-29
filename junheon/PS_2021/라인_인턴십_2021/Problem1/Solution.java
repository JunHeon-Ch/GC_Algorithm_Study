package PS_2021.라인_인턴십_2021.Problem1;

/*
 * 알고리즘: 누적합
 * 누적합을 통해 양수인 경우 +1
 * 값의 범위를 신경 써야 함
 * 시간복잡도: O(n), n=100,000,000
 */
class Solution {
    public int solution(int[] arr) {
        long[] acc = new long[arr.length];
        for(int i = 0; i < arr.length; i++) {
            acc[i] = arr[i];
        }
        int answer = acc[0] > 0 ? 1 : 0;
        for(int i = 1; i < acc.length; i++) {
            acc[i] += acc[i - 1];
            if(acc[i] > 0) answer++;
        }
        return answer;
    }
}