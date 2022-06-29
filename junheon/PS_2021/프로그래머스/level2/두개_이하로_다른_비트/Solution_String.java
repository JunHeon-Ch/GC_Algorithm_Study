package PS_2021.프로그래머스.level2.두개_이하로_다른_비트;

class Solution_String {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) answer[i] = numbers[i] + 1;
            else {
                String bit = Long.toBinaryString(numbers[i]);
                int zero = bit.lastIndexOf("0");
                if(zero == -1) {
                    bit = Long.toBinaryString(numbers[i] + 1);
                    bit = bit.substring(0, 2)
                            + bit.substring(2).replace("0", "1");
                } else {
                    int one = bit.indexOf("1", zero);
                    bit = bit.substring(0, zero) + "1"
                            + bit.substring(zero + 1, one) + "0"
                            + bit.substring(one + 1);
                }
                answer[i] = Long.parseLong(bit, 2);
            }
        }
        return answer;
    }
}